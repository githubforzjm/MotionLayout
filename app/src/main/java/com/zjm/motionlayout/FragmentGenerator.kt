package com.zjm.motionlayout

import androidx.fragment.app.Fragment
import com.zjm.motionlayout.ui.main.*

object FragmentGenerator {

    fun newInstance(type: String): Fragment {
        return when (type) {
            LayoutType.LAYOUT_1 -> {
                FragmentSample1()
            }
            LayoutType.LAYOUT_2 -> {
                FragmentSample2()
            }
            LayoutType.LAYOUT_3 -> {
                FragmentSample3()
            }
            LayoutType.LAYOUT_4 -> {
                FragmentSample4()
            }

            LayoutType.LAYOUT_5 -> {
                FragmentSample5()
            }
            LayoutType.LAYOUT_6 -> {
                FragmentSample6()
            }
            LayoutType.LAYOUT_7 -> {
                FragmentSample7()
            }
            LayoutType.LAYOUT_8 -> {
                FragmentSample8()
            }
            LayoutType.LAYOUT_9 -> {
                FragmentSample9()
            }
            LayoutType.LAYOUT_10 -> {
                FragmentSample10()
            }
            else -> {
                FragmentSample1()
            }
        }
    }

}