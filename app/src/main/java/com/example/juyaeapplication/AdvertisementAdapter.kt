package com.example.juyaeapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.juyaeapplication.databinding.ItemAdvertisementBinding

class AdvertisementAdapter : RecyclerView.Adapter<AdvertisementAdapter.AdvertisementViewHolder>(){

    val advertisementList = mutableListOf<AdvertisementData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdvertisementAdapter.AdvertisementViewHolder {
        val binding = ItemAdvertisementBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AdvertisementViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AdvertisementAdapter.AdvertisementViewHolder,
        position: Int
    ) {
        holder.onBind(advertisementList[position])
    }

    override fun getItemCount(): Int = advertisementList.size

    class AdvertisementViewHolder(
        private val binding : ItemAdvertisementBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(advertisementData: AdvertisementData) {
            binding.imageMainAdvertise.setImageResource(advertisementData.advertisement_image)
            binding.textviewTitleAdvertise.text = advertisementData.advertisement_title
            binding.textviewSubtitleAdvertise.text = advertisementData.advertisement_subtitle
        }
    }
}

