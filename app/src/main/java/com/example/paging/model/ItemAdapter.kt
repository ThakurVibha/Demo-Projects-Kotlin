package com.example.paging.model

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


//class ItemAdapter internal constructor(mCtx: Context) : PagingDataAdapter<Item, ItemAdapter.ItemViewHolder>(DIFF_CALLBACK) {
//    private val mCtx: Context
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        val view: View = LayoutInflater.from(mCtx).inflate(R.layout.users, parent, false)
//        return ItemViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val item = getItem(position)
//        if (item != null) {
//            holder.textView.text = item.owner.display_name
//            Glide.with(mCtx)
//                .load(item.owner.profile_image)
//                .into(holder.imageView)
//        } else {
//            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show()
//        }
//    }
//
//    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    }
//    companion object {
//        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Item> =
//            object : DiffUtil.ItemCallback<Item>() {
//                override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
//                    return oldItem.question_id == newItem.question_id
//                }
//
//                override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
//                    return oldItem == newItem
//                }
//            }
//    }
//
//    init {
//        this.mCtx = mCtx
//    }
//}