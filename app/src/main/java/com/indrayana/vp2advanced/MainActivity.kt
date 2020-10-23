package com.indrayana.vp2advanced

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.indrayana.vp2advanced.adapter.FragmentAdapter
import com.indrayana.vp2advanced.fragment.CardItemFragment
import com.indrayana.vp2advanced.fragment.DynamicTabFragment
import com.indrayana.vp2advanced.fragment.SliderFragment
import com.indrayana.vp2advanced.fragment.TabFragment
import kotlinx.android.synthetic.main.activity_main.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 06/04/2020 21.31
 ****************************************************/
class MainActivity : AppCompatActivity() {

    private var backPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_slider -> {
                    view_pager2.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_card -> {
                    view_pager2.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_tab -> {
                    view_pager2.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_dynamic_tab -> {
                    view_pager2.currentItem = 3
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }

        setupViewPager(view_pager2)
    }

    private fun setupViewPager(viewpager2: ViewPager2) {
        val viewPager2Adapter = FragmentAdapter(this).apply {
            addFragment(SliderFragment(), getString(R.string.title_fragment_slider))
            addFragment(CardItemFragment(), getString(R.string.title_fragment_card))
            addFragment(TabFragment(), getString(R.string.title_fragment_tab))
            addFragment(DynamicTabFragment(), getString(R.string.title_fragment_dynamic_tab))
        }

        viewpager2.isUserInputEnabled = false
        viewpager2.adapter = viewPager2Adapter
    }

    private fun setSelectedBottomNavigation(position: Int) {
        when (position) {
            0 -> bottom_navigation.selectedItemId = R.id.menu_slider
            1 -> bottom_navigation.selectedItemId = R.id.menu_card
            2 -> bottom_navigation.selectedItemId = R.id.menu_tab
            3 -> bottom_navigation.selectedItemId = R.id.menu_dynamic_tab
        }
    }

    override fun onBackPressed() {
        if (view_pager2.currentItem > 0) {
            view_pager2.currentItem = 0
            setSelectedBottomNavigation(view_pager2.currentItem)
        } else {
            // Check if back is already pressed. If yes, then exit the app.
            if (backPressedOnce) {
                super.onBackPressed()
                return
            }

            backPressedOnce = true
            Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show()

            Handler().postDelayed({
                backPressedOnce = false
            }, 2000)
        }
    }

}
