package com.example.juyaeapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.juyaeapplication.*
import com.example.juyaeapplication.databinding.FragmentHomeBinding
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val listItems = arrayListOf<ListLayout>()
    private val listAdapter = ListAdapter(listItems)
    private var keyword = ""
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = MapView(requireActivity())
        val mapViewContainer = binding.mapviewSearchPlace
        mapViewContainer.addView(mapView)

        binding.recyclerviewSearchPlace.adapter = listAdapter
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.5514579595, 126.951949155),true)

        searchPlace()

    }

    private fun searchKeyword(keyword : String){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(KakaoAPI::class.java)
        val call = api.getSearchKeyword(API_KEY,keyword)

        call.enqueue(object : Callback<SearchPlaceData>{
            override fun onResponse(
                call: Call<SearchPlaceData>,
                response: Response<SearchPlaceData>
            ) {
                if (response.isSuccessful) {
                    addItemsAndMarkers(response.body())
                }
            }

            override fun onFailure(call: Call<SearchPlaceData>, t: Throwable) {
                Log.w("HomeFragment","통신 어림도 없지 ~~ :${t.message}")
            }


        })
    }

    private fun searchPlace(){
        binding.buttonSearchPlace.setOnClickListener {
            keyword = binding.edittextSearchPlace.text.toString()
            searchKeyword(keyword)

        }
    }
    private fun addItemsAndMarkers(searchResult: SearchPlaceData?){
        if(!searchResult?.documents.isNullOrEmpty()){
            listItems.clear()
            mapView.removeAllPOIItems()


            for(document in searchResult!!.documents){
                val item = ListLayout(
                    document.address_name,
                    document.category_group_name,
                    document.category_name,
                    document.place_name
                )
                listItems.add(item)

                val point = MapPOIItem()
                point.apply {
                    itemName = document.place_name
                    mapPoint = MapPoint.mapPointWithGeoCoord(document.y.toDouble(),
                    document.x.toDouble())
                    markerType = MapPOIItem.MarkerType.YellowPin
                    selectedMarkerType = MapPOIItem.MarkerType.RedPin
                }
                mapView.addPOIItem(point)
            }
            listAdapter.notifyDataSetChanged()
        }

    }

    companion object {
        const val BASE_URL = "https://dapi.kakao.com"
        const val API_KEY = "KakaoAK 8305444d28bd868ba6ec8a6d3f2b00e4"
    }
}