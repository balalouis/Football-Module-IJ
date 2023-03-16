package com.competition.detail.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.competition.detail.R
import com.competition.detail.databinding.FragmentViewPagerBinding
import com.project.detail.adapter.ViewPageAdapter

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle()
        getIntents()
        initAdapter()
    }

    private fun setTitle(){
        val actionBar=(activity as AppCompatActivity?)!!.supportActionBar
        actionBar?.title = resources.getString(R.string.premier_league)
    }

    private fun initAdapter(){
        val bundle = Bundle().apply {
            putLong("id" ,competitionId)
        }
        val viewPageAdapter = ViewPageAdapter(
            childFragmentManager
        )
        viewPageAdapter.addFragment(TableFragment().apply {
            arguments = bundle
        }, "Table")
        viewPageAdapter.addFragment(FixturesFragment().apply {
            arguments = bundle
        }, "Fixtures")
        viewPageAdapter.addFragment(TeamFragment().apply {
            arguments = bundle
        }, "Team")

        // Set up the ViewPager with the sections adapter.
        binding.container.adapter = viewPageAdapter
        binding.tabs.setupWithViewPager(binding.container)
    }

    private fun getIntents() {
        val args: ViewPagerFragmentArgs by navArgs()
        competitionId = args.competitionId.toLong()
    }

}