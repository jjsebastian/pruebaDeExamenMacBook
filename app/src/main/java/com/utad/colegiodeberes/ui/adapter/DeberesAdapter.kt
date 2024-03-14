package com.utad.colegiodeberes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.utad.colegiodeberes.data.network.model.HomeWorkResponse
import com.utad.colegiodeberes.databinding.ItemBaseBinding

class DeberesAdapter(): ListAdapter<HomeWorkResponse, DeberesAdapter.BaseViewHolder>(BaseItemCallBack) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBaseBinding.inflate(inflater, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)

        //TODO pintar datos de la recycler view

        holder.binding.tvTitle.text = item.title
        holder.binding.tvTeacher.text = item.teacherName
        holder.binding.tvSubject.text = "${item.subject.title} - ${item.subject.classX}"
        holder.binding.tvDate.text = item.date

    }


    inner class BaseViewHolder(val binding: ItemBaseBinding) : RecyclerView.ViewHolder(binding.root)


}


object BaseItemCallBack : DiffUtil.ItemCallback<HomeWorkResponse>() {
    override fun areItemsTheSame(oldItem: HomeWorkResponse, newItem: HomeWorkResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeWorkResponse, newItem: HomeWorkResponse): Boolean {
        return oldItem == newItem
    }

}