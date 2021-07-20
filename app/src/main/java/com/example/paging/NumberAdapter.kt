package com.example.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.endlessrecyclerview.MyPagingActivity
import com.example.forlooptask.R

class NumberAdapter(val activity: MyPagingActivity) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(LayoutInflater.from(activity).inflate(R.layout.rv_child_number, parent, false))
    }
    override fun getItemCount(): Int {
        return activity.numberList.size
    }
    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.tvNumber.text = activity.numberList[position]
        holder.tvNumber2.text=activity.numberList[position]
    }
    class NumberViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvNumber = v.findViewById<TextView>(R.id.tv_number)
        val tvNumber2 = v.findViewById<TextView>(R.id.tv_number2)
    }
}