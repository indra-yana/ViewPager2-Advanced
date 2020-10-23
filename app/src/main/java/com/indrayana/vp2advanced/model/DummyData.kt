package com.indrayana.vp2advanced.model

import android.content.Context
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.indrayana.vp2advanced.R
import com.indrayana.vp2advanced.customtransformation.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 08/04/2020 08.10
 ****************************************************/
object DummyData {

    fun cardItemDummyData(context: Context?): MutableList<CardItem> {
        return mutableListOf(
            CardItem(
                context?.getString(R.string.title_text) + " items 1", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_1
            ),
            CardItem(
                context?.getString(R.string.title_text) + " items 2", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_2
            ),
            CardItem(
                context?.getString(R.string.title_text) + " items 3", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_3
            ),
            CardItem(
                context?.getString(R.string.title_text) + " items 4", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_4
            ),
            CardItem(
                context?.getString(R.string.title_text) + " items 5", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_5
            ),
            CardItem(
                context?.getString(R.string.title_text) + " items 6", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_6
            ),
            CardItem(
                context?.getString(R.string.title_text) + " items 7", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_7
            ),
            CardItem(
                context?.getString(R.string.title_text) + " items 8", context?.getString(
                    R.string.lorem_ipsum_text
                ), R.drawable.poster_8
            )
        )
    }

    fun cardItemDummyDataLarge(context: Context?, amountData: Int): MutableList<CardItem> {
        val items = mutableListOf<CardItem>()
        (0..amountData).map {
            items.add(cardItemDummyData(context).random())
        }

        return items
    }

    fun transformationDummyData(): MutableList<TransformationItem> {
        return mutableListOf(
            TransformationItem(
                "Overlap Slider Transformation",
                OverlapSliderTransformation(ViewPager2.ORIENTATION_HORIZONTAL)
            ),
            TransformationItem(
                "Simple Slider Transformation",
                SimpleSliderTransformation()
            ),
            TransformationItem(
                "Scale Transformation",
                CompositePageTransformer().apply {
                    addTransformer(MarginPageTransformer(10))
                    addTransformer(ScaleTransformation())
                }),
            TransformationItem(
                "ScaleBounce Transformation",
                ScaleBounceTransformation()
            ),
            TransformationItem(
                "CubeInScaling Transformation",
                CubeInScalingTransformation()
            ),
            TransformationItem(
                "CubeOut Rotation Transformation",
                CubeOutRotationTransformation()
            ),
            TransformationItem("Depth Transformation", DepthTransformation()),
            TransformationItem("FadeOut Transformation", FadeOutTransformation()),
            TransformationItem("Fan Transformation", FanTransformation()),
            TransformationItem(
                "FidgetSpin Transformation",
                FidgetSpinTransformation()
            ),
            TransformationItem("Hinge Transformation", HingeTransformation()),
            TransformationItem("Pop Transformation", PopTransformation()),
            TransformationItem(
                "AntiClockSpin Transformation",
                AntiClockSpinTransformation()
            ),
            TransformationItem("Spin Transformation", SpinTransformation()),
            TransformationItem(
                "StackSlider Transformation", StackSliderTransformation(
                    ViewPager2.ORIENTATION_HORIZONTAL,
                    0.2f,
                    0.5f
                )
            ),
            TransformationItem(
                "VerticalFlip Transformation",
                VerticalFlipTransformation()
            ),
            TransformationItem(
                "VerticalShut Transformation",
                VerticalShutTransformation()
            ),
            TransformationItem("ZoomOut Transformation", ZoomOutTransformation())
        )
    }

}