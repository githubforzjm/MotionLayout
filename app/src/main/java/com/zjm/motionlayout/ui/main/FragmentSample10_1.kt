package com.zjm.motionlayout.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.zjm.motionlayout.R
import com.zjm.motionlayout.ViewPagerAdapter

class FragmentSample10_1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sample10_1, container, false)


        val motionLayout = view.findViewById<MotionLayout>(R.id.motionLayout)
        val pager = view.findViewById<ViewPager>(R.id.pager)
        val tabs = view.findViewById<TabLayout>(R.id.tabs)


        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addPage("Page 1", R.layout.motion_16_viewpager_page1)
        adapter.addPage("Page 2", R.layout.motion_16_viewpager_page2)
        adapter.addPage("Page 3", R.layout.motion_16_viewpager_page3)
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val numPages = 3
                motionLayout.progress = (position + positionOffset) / (numPages - 1)
                Log.i("AAABBBCCC", "${motionLayout.progress}")
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        return view
    }


}