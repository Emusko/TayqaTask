package com.example.tayqatask.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tayqatask.R
import com.example.tayqatask.network.model.GoalModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.goal_list_view.view.*
import java.util.*

class HomeAdapter (private val goals: MutableList<GoalModel>, private val clicked: (position: Int) -> Unit): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){
    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(goal: GoalModel, clicked: (position: Int) -> Unit){
            Picasso.get().load(goal.picture).into(itemView.goalImage)
            itemView.goalName.text = goal.name
            itemView.setOnClickListener {
                clicked.invoke(adapterPosition)
                goal.status = 1
                val image = itemView.downloadProgress
                val stateImage = itemView.stateImage
                stateImage.setImageResource(R.drawable.pause)
                image.visibility = View.VISIBLE
                android.os.Handler().postDelayed({
                    image.visibility = View.GONE
                    stateImage.setImageResource(R.drawable.upload)
                }, 7000)
            }
        }
    }

    fun swapItems(index: Int) {
        Collections.swap(goals, index, 0)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.goal_list_view, parent, false)
    )

    override fun getItemCount() = goals.size
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(goals[position], clicked)
    }
}