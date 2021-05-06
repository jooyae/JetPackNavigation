package com.example.juyaeapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.juyaeapplication.databinding.ItemPlaceResultBinding

class ListAdapter(val itemList : ArrayList<ListLayout>) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val binding = ItemPlaceResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(private val binding: ItemPlaceResultBinding):
            RecyclerView.ViewHolder(binding.root){
                fun onBind(listLayout: ListLayout){
                    binding.textviewAddressName.text = listLayout.address
                    binding.textviewCategoryGroup.text = listLayout.category_group
                    binding.textviewCategoryName.text = listLayout.category_name
                    binding.textviewPlaceName.text = listLayout.place_name
                }
            }

}