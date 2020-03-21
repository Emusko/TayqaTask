package com.example.tayqatask.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tayqatask.R
import com.example.tayqatask.data.model.GoalModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.goal_list_view.view.*

class HomeAdapter(
    private val goals: MutableList<GoalModel>,
    private val clicked: (goal: GoalModel) -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(goal: GoalModel, clicked: (goal: GoalModel) -> Unit) {
            Picasso.get().load(goal.picture).into(itemView.goalImage)
            itemView.goalName.text = goal.name
            val progressBar = itemView.downloadProgress
            val stateImage = itemView.stateImage
            if (goal.status == 1) {
                stateImage.setImageResource(R.drawable.pause)
                progressBar.visibility = View.VISIBLE
                android.os.Handler().postDelayed({
                    progressBar.visibility = View.GONE
                    stateImage.setImageResource(R.drawable.upload)
                    stateImage.setImageResource(R.drawable.done)
                    goal.status = 2
                    clicked.invoke(goal)
                }, 7000)
            } else if (goal.status == 2) {
                stateImage.setImageResource(R.drawable.done)
                progressBar.visibility = View.GONE
            }
        }
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(true)
    }

    override fun getItemViewType(position: Int) = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.goal_list_view, parent, false)
    )

    override fun getItemCount() = goals.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(goals[position], clicked)
        holder.itemView.setOnClickListener {
            val goal = goals[position]
            if (goal.status == 0) {
                goal.status = 1
                clicked.invoke(goal)
                goals.remove(goal)
                goals.add(0, goal)
                notifyItemMoved(position, 0)
                notifyDataSetChanged()
            }
        }
    }
}