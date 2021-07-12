package com.example.retrofit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forlooptask.R
import com.example.retrofit.model.CoinModel
import kotlinx.android.synthetic.main.coin_desk_item.view.*
import kotlin.collections.ArrayList

 class CoinDeskAdapter(
     context: Context,
 ) : RecyclerView.Adapter<CoinDeskAdapter.CoinDeskViewHolder>() {
     var list = ArrayList<CoinModel>()
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinDeskViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.coin_desk_item, parent, false)
        return CoinDeskViewHolder(root)
    }

    override fun onBindViewHolder(holder: CoinDeskViewHolder, position: Int) {
        val currentPosition = list[position]
//        holder.itemView.code.setText(list.getName());
//
//        holder.itemView.code.text = currentPosition.bpi.EUR.code
//        holder.itemView.rate.text=currentPosition.disclaimer
//        holder.itemView.description.text=currentPosition.bpi.GBP.description
    }
    override fun getItemCount(): Int {
        return list.size
    }

//    fun update(it: CoinModel) {
//        list = it
//        this.notifyDataSetChanged()
//    }

    class CoinDeskViewHolder(binding: View) : RecyclerView.ViewHolder(binding)


}
