package com.indrayana.vp2advanced.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_6
import com.indrayana.vp2advanced.R
import com.indrayana.vp2advanced.adapter.CardAdapter
import com.indrayana.vp2advanced.adapter.OnItemClickListenerImpl
import com.indrayana.vp2advanced.model.CardItem
import com.indrayana.vp2advanced.model.DummyData.cardItemDummyDataLarge
import com.indrayana.vp2advanced.model.DummyData.transformationDummyData
import kotlinx.android.synthetic.main.fragment_slider.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 06/04/2020 21.31
 ****************************************************/
class SliderFragment : Fragment() {

    private lateinit var itemList: MutableList<CardItem>

    private val sliderInterval: Long = 5000
    private val sliderHandler = Handler()
    private val sliderRunnable = Runnable {
        if (itemList.isNotEmpty()) {
            if (vp2_slider.currentItem + 1 == itemList.size) {
                vp2_slider.currentItem = 0
            } else {
                vp2_slider.currentItem = vp2_slider.currentItem + 1
            }
        }
    }

    private val sliderTransformerList = transformationDummyData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList = cardItemDummyDataLarge(requireActivity(), 5)

        setupListOfPageTransformer()

        btn_view_all.setOnClickListener {
            Toast.makeText(context, "See all clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, sliderInterval)
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    private fun setupListOfPageTransformer() {
        val listOfPageTransformer = mutableListOf<String>()
        for (item in sliderTransformerList) {
            listOfPageTransformer.add(item.title)
        }
        val adapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_list_item_1,
            listOfPageTransformer
        )

        transformation_list.adapter = adapter
        transformation_list.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {
                setupViewPager2(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    private fun setupViewPager2(position: Int) {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_6).apply {
            onItemClickListener = object : OnItemClickListenerImpl() {
                override fun onItemClick(view: View?, position: Int) {
                    super.onItemClick(view, position)
                    showToast("Item clicked: ${itemList[position].title}")
                }

                override fun onItemLongClick(view: View?, position: Int) {
                    super.onItemLongClick(view, position)
                    showToast("Long click item: ${itemList[position].title}")
                }
            }
        }

        vp2_slider.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(50, 0, 50, 0)

            setPageTransformer(sliderTransformerList[position].transformer)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderHandler.removeCallbacks(sliderRunnable)
                    sliderHandler.postDelayed(sliderRunnable, sliderInterval)
                }
            })
        }

        dots_indicator.setViewPager2(vp2_slider)
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}
