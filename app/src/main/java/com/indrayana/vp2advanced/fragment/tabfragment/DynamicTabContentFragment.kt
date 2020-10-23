package com.indrayana.vp2advanced.fragment.tabfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.indrayana.vp2advanced.R
import kotlinx.android.synthetic.main.fragment_dynamic_tab_content.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 09/04/2020 15.31
 ****************************************************/
class DynamicTabContentFragment() : Fragment() {

    var title: String? = "FRAGMENT_TITLE"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dynamic_tab_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_fragment_title.text = title
    }

    companion object {
        private const val BUNDLE_ARGS_1 = "BUNDLE_ARGS_1"

        @JvmStatic
        fun newInstance(param1: String): DynamicTabContentFragment {
            return DynamicTabContentFragment().apply {
                arguments = Bundle().apply {
                    putString(BUNDLE_ARGS_1, param1)
                }
                title = param1
            }
        }
    }

}
