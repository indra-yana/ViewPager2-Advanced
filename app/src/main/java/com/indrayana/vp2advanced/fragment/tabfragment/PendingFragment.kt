package com.indrayana.vp2advanced.fragment.tabfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.indrayana.vp2advanced.R
import kotlinx.android.synthetic.main.fragment_pending.*

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 09/04/2020 15.31
 ****************************************************/
class PendingFragment : Fragment() {

    private var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counter()
    }

    private fun counter() {
        btnPlus.setOnClickListener {
            count++
            tvResult.text = count.toString()
        }

        btnMinus.setOnClickListener {
            count--
            tvResult.text = count.toString()
        }
    }
}
