package com.indrayana.vp2advanced.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_1
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_2
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_3
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_4
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_5
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_6
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_7
import com.indrayana.vp2advanced.ItemViewType.Companion.VIEW_TYPE_CARD_8
import com.indrayana.vp2advanced.R
import com.indrayana.vp2advanced.adapter.CardAdapter
import com.indrayana.vp2advanced.adapter.OnItemClickListenerImpl
import com.indrayana.vp2advanced.customtransformation.OverlapSliderTransformation
import com.indrayana.vp2advanced.customtransformation.SimpleSliderTransformation
import com.indrayana.vp2advanced.model.CardItem
import com.indrayana.vp2advanced.model.DummyData.cardItemDummyDataLarge
import kotlinx.android.synthetic.main.fragment_card.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 06/04/2020 21.31
 ****************************************************/
class CardItemFragment : Fragment() {

    private lateinit var itemList: MutableList<CardItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList = cardItemDummyDataLarge(requireActivity(), 20)

        setupVp2TypeSlider()
        setupVp2CardType1()
        setupVp2CardType2()
        setupVp2CardType3()
        setupVp2CardType4()
        setupVp2CardType5()
        setupVp2CardType7()
        setupVp2CardType8()
    }

    private fun setupVp2TypeSlider() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_6)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemLongClick(view: View?, position: Int) {
                super.onItemLongClick(view, position)
                Toast.makeText(
                    context,
                    "Long click item: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_6.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(OverlapSliderTransformation(ViewPager2.ORIENTATION_HORIZONTAL))

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(50, 0, 50, 0)
        }
    }

    private fun setupVp2CardType1() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_1)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_1.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(MarginPageTransformer(20))

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(20, 0, 150, 0)
        }
    }

    private fun setupVp2CardType2() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_2)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonItemClick(view: View?, position: Int) {
                super.onButtonItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_2.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(SimpleSliderTransformation())

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(50, 0, 50, 0)
        }
    }

    private fun setupVp2CardType3() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_3)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonItemClick(view: View?, position: Int) {
                super.onButtonItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_3.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(MarginPageTransformer(10))

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(20, 0, 150, 0)
        }
    }

    private fun setupVp2CardType4() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_4)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonItemClick(view: View?, position: Int) {
                super.onButtonItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_4.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(MarginPageTransformer(10))

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(20, 0, 450, 0)
        }
    }

    private fun setupVp2CardType5() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_5)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_5.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(MarginPageTransformer(10))

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(20, 0, 150, 0)
        }

        with(vp2_card_type_5) {
            adapter = sliderAdapter
        }
    }

    private fun setupVp2CardType7() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_7)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonNotificationItemClick(view: View?, position: Int) {
                super.onButtonNotificationItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button notification item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonShareItemClick(view: View?, position: Int) {
                super.onButtonShareItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button share item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_7.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(MarginPageTransformer(10))

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(20, 0, 150, 0)
        }

        with(vp2_card_type_7) {
            adapter = sliderAdapter
        }
    }

    private fun setupVp2CardType8() {
        val sliderAdapter = CardAdapter(itemList, VIEW_TYPE_CARD_8)
        sliderAdapter.onItemClickListener = object : OnItemClickListenerImpl() {
            override fun onItemClick(view: View?, position: Int) {
                super.onItemClick(view, position)
                Toast.makeText(
                    context,
                    "Item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonItemClick(view: View?, position: Int) {
                super.onButtonItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonNotificationItemClick(view: View?, position: Int) {
                super.onButtonNotificationItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button notification item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onButtonShareItemClick(view: View?, position: Int) {
                super.onButtonShareItemClick(view, position)
                Toast.makeText(
                    context,
                    "Button share item clicked: ${itemList[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        vp2_card_type_8.apply {
            adapter = sliderAdapter
            offscreenPageLimit = 3
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            setPageTransformer(MarginPageTransformer(10))

            val recyclerViewChild = children.firstOrNull() as RecyclerView
            recyclerViewChild.clipChildren = false
            recyclerViewChild.clipToPadding = false
            recyclerViewChild.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            recyclerViewChild.setPadding(20, 0, 150, 0)
        }

        with(vp2_card_type_8) {
            adapter = sliderAdapter
        }
    }

}
