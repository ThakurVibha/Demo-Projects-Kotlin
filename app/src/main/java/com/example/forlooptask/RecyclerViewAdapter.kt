package com.example.forlooptask

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import java.util.*

@Suppress("UNREACHABLE_CODE")
class RecyclerViewAdapter(var list: List<RecyclerViewModel>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewHolder {
        val root2 = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return RecyclerviewHolder(root2)
    }
    override fun onBindViewHolder(holder: RecyclerviewHolder, position: Int) {
            holder.itemView.tvAlphabet.text=list[position].numberItem
        //to set random background color to item
        val rnd = Random()
        val currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        holder.itemView.setBackgroundColor(currentColor)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, list[position].numberItem, Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class RecyclerviewHolder(binding: View) : RecyclerView.ViewHolder(binding)


}

