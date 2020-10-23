package com.indrayana.vp2advanced.customtransformation

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


class ScaleTransformation : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val r = 1 - abs(position)
        page.scaleY = 0.85f + r * 0.15f
    }
}