package com.project.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.presentation.R
import com.project.presentation.databinding.FragmentFixtureBinding
import com.project.presentation.databinding.FragmentMyViewPagerBinding

class MyViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentMyViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyViewPagerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}