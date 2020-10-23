package com.indrayana.vp2advanced.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.indrayana.vp2advanced.R
import com.indrayana.vp2advanced.adapter.FragmentAdapter
import com.indrayana.vp2advanced.fragment.tabfragment.DynamicTabContentFragment
import kotlinx.android.synthetic.main.fragment_dynamic_tab.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 09/04/2020 15.31
 ****************************************************/
class DynamicTabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager(view_pager_dynamic_tab, dynamic_tab_layout)
    }

    private fun setupViewPager(viewPager2: ViewPager2, tabLayout: TabLayout) {
        val viewPager2Adapter = FragmentAdapter(requireActivity()).apply {
            for (i in 1..10) {
                addFragment(DynamicTabContentFragment().apply { title = "Fragment $i"}, "Fragment $i")
            }
        }

        viewPager2.apply {
            adapter = viewPager2Adapter
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }
        })

        TabLayoutMediator(
            tabLayout,
            viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = viewPager2Adapter.getFragmentTitle(position)
            }
        ).attach()
    }
}
