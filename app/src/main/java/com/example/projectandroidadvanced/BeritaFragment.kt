package com.example.projectandroidadvanced

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class BeritaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_berita, container, false)

        val viewPager : ViewPager = view.findViewById(R.id.pager)
        val tab : TabLayout = view.findViewById(R.id.tabLayout)

        viewPager.adapter = ViewPagerAdapter(childFragmentManager)
        tab.setupWithViewPager(viewPager)

        return view
    }


}
