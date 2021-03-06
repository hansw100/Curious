package com.team.rich.curious.controller

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.rich.curious.CuriousDetailActivity
import com.team.rich.curious.R
import com.team.rich.curious.models.Curious
import kotlinx.android.synthetic.main.item_main_goal.view.*
import java.util.ArrayList

class GoalAdapter(private val items: ArrayList<Curious>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class GoalViewHolder(val mView: View) : RecyclerView.ViewHolder(mView)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_main_goal, viewGroup, false)
        return GoalViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(vh: RecyclerView.ViewHolder, i: Int) {
        val viewHolder = vh as GoalViewHolder
        viewHolder.mView.text_goal_title.text = items[i].name
        viewHolder.mView.text_goal_provider.text = items[i].contentsProvider.name
        viewHolder.mView.button_main_go.setOnClickListener {
            viewHolder
                .mView.context
                .startActivity(Intent(viewHolder.mView.context, CuriousDetailActivity::class.java)
                    .putExtra("curiousName",items[i].name)
                    .putExtra("curiousSrc" ,items[i].srcUrl)
                    .putExtra("providerName",items[i].contentsProvider.name)
                )
        }
    }

}