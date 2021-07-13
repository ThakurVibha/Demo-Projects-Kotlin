package com.example.paging.viewmore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forlooptask.R
import kotlinx.android.synthetic.main.item.view.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter(var list: ArrayList<Array<String>>, context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewHolder {
        val root2 = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return RecyclerviewHolder(root2)
    }
    override fun onBindViewHolder(holder: RecyclerviewHolder, position: Int) {
        //to set random background color to item

        holder.itemView.txtItem.setText(list.get(position).toString());
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class RecyclerviewHolder(binding: View) : RecyclerView.ViewHolder(binding)


}

