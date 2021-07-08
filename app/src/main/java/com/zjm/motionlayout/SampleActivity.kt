package com.zjm.motionlayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SampleActivity : AppCompatActivity() {

    companion object {
        const val PARAM_TYPE = "param_type"
        fun startActivity(activity: Activity, type: String) {

            val intent = Intent(activity, SampleActivity::class.java).apply {
                putExtra(PARAM_TYPE, type)
            }

            activity.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val type = intent.getStringExtra(PARAM_TYPE) ?: LayoutType.LAYOUT_1

        val newInstance = FragmentGenerator.newInstance(type)
        supportFragmentManager.beginTransaction().replace(R.id.root, newInstance).commit()

    }


}