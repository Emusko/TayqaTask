package com.example.tayqatask.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tayqatask.R
import com.example.tayqatask.network.model.GoalModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.goal_list_view.view.*

class HomeAdapter (private val goals: List<GoalModel>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){
    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(goal: GoalModel){
            Picasso.get().load(goal.picture).into(itemView.goalImage)
            itemView.goalName.text = goal.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.goal_list_view, parent, false)
    )

    override fun getItemCount() = goals.size
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(goals[position])
    }
}