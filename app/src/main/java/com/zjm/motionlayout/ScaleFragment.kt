package com.zjm.motionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class ScaleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scale, container, false)

    }

    fun setScale(level: Float) {
        val text = "${level * 100}%"
        val textsize = 10 + 30 * level

        val tv = view?.findViewById<AppCompatTextView>(R.id.tv)
        tv?.text = text
        tv?.textSize = textsize

    }
}