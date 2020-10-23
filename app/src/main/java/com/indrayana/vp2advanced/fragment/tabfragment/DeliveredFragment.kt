package com.indrayana.vp2advanced.fragment.tabfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.indrayana.vp2advanced.R

/****************************************************
 * Created by Indra Muliana (indra.ndra26@gmail.com)
 * On 09/04/2020 15.31
 ****************************************************/
class DeliveredFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivered, container, false)
    }

}
