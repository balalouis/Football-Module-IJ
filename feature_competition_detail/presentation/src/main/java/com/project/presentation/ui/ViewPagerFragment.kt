package com.project.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.presentation.FixtureFragment
import com.project.presentation.TableFragment
import com.project.presentation.TeamFragment
import com.project.presentation.adapter.ViewPageAdapter
import com.project.presentation.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private var competitionId: Long = 0L
    private lateinit var name: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    private fun initAdapter(){
        val viewPageAdapter = ViewPageAdapter(
            childFragmentManager
        )
        viewPageAdapter.addFragment(TableFragment().apply {
            arguments = Bundle().apply {
                putLong("id", competitionId)
            }
        }, "Table")
        viewPageAdapter.addFragment(FixtureFragment().apply {
            arguments = Bundle().apply {
                putLong("id", competitionId)
            }
        }, "Fixtures")
        viewPageAdapter.addFragment(TeamFragment().apply {
            arguments = Bundle().apply {
                putLong("id", competitionId)
            }
        }, "Team")

        // Set up the ViewPager with the sections adapter.
        binding.container.adapter = viewPageAdapter
        binding.tabs.setupWithViewPager(binding.container)
    }

}