package com.example.juyaeapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.juyaeapplication.KakaoAPI
import com.example.juyaeapplication.R
import com.example.juyaeapplication.SearchPlaceData
import com.example.juyaeapplication.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

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
        searchKeyword("은행")
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
                Log.d("Test","Raw: ${response.raw()}")
                Log.d("Test","Body : ${response.body()}")
            }

            override fun onFailure(call: Call<SearchPlaceData>, t: Throwable) {
                Log.w("HomeFragment","통신 어림도 없지 ~~ :${t.message}")
            }


        })
    }

    companion object {
        const val BASE_URL = "https://dapi.kakao.com"
        const val API_KEY = "KakaoAK 8305444d28bd868ba6ec8a6d3f2b00e4"
    }
}