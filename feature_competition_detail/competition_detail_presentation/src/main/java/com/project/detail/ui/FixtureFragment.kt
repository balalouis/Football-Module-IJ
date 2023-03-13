package com.project.detail.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.presentation.databinding.FragmentFixtureBinding

class FixtureFragment : Fragment() {

    private lateinit var binding: FragmentFixtureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixtureBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}