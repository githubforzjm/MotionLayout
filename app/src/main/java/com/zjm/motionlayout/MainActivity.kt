package com.zjm.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zjm.motionlayout.ui.main.OnItemClickListener
import com.zjm.motionlayout.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        sectionsPagerAdapter.itemClickListener = this
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = sectionsPagerAdapter

    }

    override fun onItemClicked(type: String) {
        SampleActivity.startActivity(this, type)
    }
}