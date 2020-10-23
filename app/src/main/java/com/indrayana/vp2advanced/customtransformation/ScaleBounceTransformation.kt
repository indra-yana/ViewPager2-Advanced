package com.indrayana.vp2advanced.customtransformation

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs
import kotlin.math.max


class ScaleBounceTransformation : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val myOffset = position * - (2 * PAGE_OFFSET + PAGE_MARGIN)
        when {
            position < -1 -> page.translationX = -myOffset
            position <= 1 -> {
                val scaleFactor = max(0.7f, 1 - abs(position - 0.14285715f))
                page.translationX = myOffset
                page.scaleY = scaleFactor
                page.alpha = scaleFactor
            }
            else -> {
                page.alpha = MIN_ALPHA
                page.translationX = myOffset
            }
        }
    }

    companion object {
        private const val PAGE_MARGIN = 0.90f
        private const val PAGE_OFFSET = 0.90f
        private const val MIN_ALPHA   = 0.0f
    }
}