package com.zjm.motionlayout.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.zjm.motionlayout.R
import com.zjm.motionlayout.ScaleFragment

class FragmentSample11 : Fragment(), MotionLayout.TransitionListener {


    private val scaleFragment: ScaleFragment by lazy {
        ScaleFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sample11, container, false)
        fragmentManager?.beginTransaction()?.replace(R.id.container, scaleFragment)?.commit()


        val motionLayout = view.findViewById<MotionLayout>(R.id.motionLayout)

        motionLayout.setTransitionListener(this)

        return view
    }


    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
        Log.i("AAAABBBCCC", "onTransitionStarted $p1  $p2")
    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
        Log.i("AAAABBBCCC", "onTransitionChange $p1  $p2  $p3")

        scaleFragment?.setScale(p3)

    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
        Log.i("AAAABBBCCC", "onTransitionChange $p1")
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
        Log.i("AAAABBBCCC", "onTransitionTrigger $p1  $p2  $p3")

    }


}