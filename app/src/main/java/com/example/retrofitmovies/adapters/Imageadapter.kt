package com.example.myfirstapp.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forlooptask.databinding.MoviesItemBinding
import com.example.retrofitmovies.model.MoviesModelItem

class Imageadapter(var mList: ArrayList<MoviesModelItem>):RecyclerView.Adapter<Imageadapter.Myviewholder>(){

    class Myviewholder(val binding:MoviesItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder = Myviewholder(MoviesItemBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))
    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        holder.binding.tvTitle.text = mList[position].title
        holder.binding.tvRealse.text = mList[position].release_date
        holder.binding.tvDirector.text = mList[position].director
        holder.binding.tvProducer.text = mList[position].producer
        holder.binding.tvDescription.text = mList[position].description
        holder.binding.tvOrigTitle.text = mList[position].original_title_romanised
    }
    override fun getItemCount(): Int {
        return mList.size
    }

//    fun updateAdapter(list: ArrayList<Mymodel>){
//        this.mList = list
//        notifyDataSetChanged()
//    }
}