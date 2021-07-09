package com.zjm.motionlayout.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.zjm.motionlayout.R

class FragmentSample12 : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sample12, container, false)




        view.findViewById<ImageButton>(R.id.imageButton2).setOnClickListener(this)

        return view
    }


    override fun onClick(v: View?) {
        val motionLayout = view?.findViewById<MotionLayout>(R.id.motionLayout) ?: return

        if (motionLayout.progress < 0.5f) {
            motionLayout.transitionToEnd()
        } else {
            motionLayout.transitionToStart()
        }
    }

}