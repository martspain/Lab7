package com.example.lab6.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R

class CustomAdapter(val surveyList: ArrayList<Survey>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return surveyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val survey: Survey = surveyList[position]
        holder.textViewQuestion.text = survey.question
        holder.textViewAnswer.text = survey.answer
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textViewQuestion = itemView.findViewById(R.id.textViewQuestion) as TextView
        val textViewAnswer = itemView.findViewById(R.id.textViewAnswer) as TextView
    }

}