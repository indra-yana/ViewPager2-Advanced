package com.indrayana.vp2advanced.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.indrayana.vp2advanced.R
import com.indrayana.vp2advanced.adapter.FragmentAdapter
import com.indrayana.vp2advanced.fragment.tabfragment.ConfirmedFragment
import com.indrayana.vp2advanced.fragment.tabfragment.DeliveredFragment
import com.indrayana.vp2advanced.fragment.tabfragment.PendingFragment
import kotlinx.android.synthetic.main.fragment_tab.*


/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 06/04/2020 21.31
 ****************************************************/
class TabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager(view_pager_tab, tab_layout)
    }

    private fun setupViewPager(viewPager2: ViewPager2, tabLayout: TabLayout) {
        val viewPager2Adapter = FragmentAdapter(requireActivity()).apply {
            addFragment(
                PendingFragment(),
                getString(R.string.pending_fragment),
                R.drawable.ic_tab_pending
            )
            addFragment(
                ConfirmedFragment(),
                getString(R.string.confirmed_fragment),
                R.drawable.ic_tab_confirmed
            )
            addFragment(
                DeliveredFragment(),
                getString(R.string.delivered_fragment),
                R.drawable.ic_tab_delivered
            )
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
                    val badgeDrawable = tab.orCreateBadge
                    if (badgeDrawable.isVisible) {
                        Handler().postDelayed({
                            badgeDrawable.isVisible = false
                        }, 2000)
                    }
                }
            }
        })

        TabLayoutMediator(
            tabLayout,
            viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = viewPager2Adapter.getFragmentTitle(position)
                tab.setIcon(viewPager2Adapter.getFragmentIcon(position))

                tab.orCreateBadge.apply {
                    backgroundColor = resources.getColor(R.color.colorBlue1, null)
                    number = 10
                    isVisible = true
                    maxCharacterCount = 3
                }
            }
        ).attach()
    }

}
