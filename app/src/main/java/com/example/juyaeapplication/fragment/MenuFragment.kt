package com.example.juyaeapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juyaeapplication.AdvertisementAdapter
import com.example.juyaeapplication.AdvertisementData
import com.example.juyaeapplication.R
import com.example.juyaeapplication.databinding.FragmentHomeBinding
import com.example.juyaeapplication.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding
    private lateinit var advertisementAdapter : AdvertisementAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        advertisementAdapter = AdvertisementAdapter()
        binding.recyclerviewAdvertisement.adapter = advertisementAdapter

        binding.recyclerviewAdvertisement.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        advertisementAdapter.advertisementList.addAll(
            listOf<AdvertisementData>(
                AdvertisementData(
                    advertisement_image = R.drawable.jtbc,
                    advertisement_title = "JTBC NEWS",
                    advertisement_subtitle = "2017.01.23"
                ),
                AdvertisementData(
                    advertisement_image = R.drawable.sbs,
                    advertisement_title = "SBS NEWS",
                    advertisement_subtitle = "2020.03.14"
                ),
                AdvertisementData(
                    advertisement_image = R.drawable.sports,
                    advertisement_title = "Sports Seoul",
                    advertisement_subtitle = "2021.12.25"
                ),
                AdvertisementData(
                    advertisement_image = R.drawable.ytn,
                    advertisement_title = "YTN",
                    advertisement_subtitle = "2020.07.02"
                )
            )

        )
        advertisementAdapter.notifyDataSetChanged()
    }


}


