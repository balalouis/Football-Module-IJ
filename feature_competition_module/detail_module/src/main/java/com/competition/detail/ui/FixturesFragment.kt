package com.competition.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.competition.detail.databinding.FragmentFixturesBinding

class FixturesFragment : Fragment() {

    private lateinit var binding: FragmentFixturesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}