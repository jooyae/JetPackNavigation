package com.example.juyaeapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.juyaeapplication.R
import com.example.juyaeapplication.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun initMenuFragmentSignUp() {
        binding.buttonSignup.setOnClickListener {
            val signupName = binding.editextSignupName.text
            val signupID = binding.editextSignupId.text
            val signupPwd = binding.editextSignupPwd.text

            if (signupID.isNullOrBlank() || signupName.isNullOrBlank() || signupPwd.isNullOrBlank()) {
                Toast.makeText(context, "빈칸이 있는지 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "회원님의 정보가 저장되었습니다.", Toast.LENGTH_SHORT).show()

            }
        }

    }

}


