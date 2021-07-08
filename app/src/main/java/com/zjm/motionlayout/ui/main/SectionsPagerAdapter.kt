package com.zjm.motionlayout.ui.main

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zjm.motionlayout.LayoutType
import com.zjm.motionlayout.R

private val TAB_TITLES = arrayOf(
    LayoutType.LAYOUT_1,
    LayoutType.LAYOUT_2,
    LayoutType.LAYOUT_3,
    LayoutType.LAYOUT_4,
    LayoutType.LAYOUT_5, LayoutType.LAYOUT_6, LayoutType.LAYOUT_7, LayoutType.LAYOUT_8,LayoutType.LAYOUT_9,LayoutType.LAYOUT_10
)

class SectionsPagerAdapter(val context: Context) :
    RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflate = View.inflate(context, R.layout.rv_item_sample, null)
        return Holder(inflate)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.textView.text = TAB_TITLES[position]

        holder.root.setOnClickListener {
            itemClickListener?.onItemClicked(TAB_TITLES[position])
        }
    }

    override fun getItemCount(): Int {
        return TAB_TITLES.size
    }

    var itemClickListener: OnItemClickListener? = null

}

interface OnItemClickListener {
    fun onItemClicked(type: String)
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val root = itemView
    val textView: TextView = itemView.findViewById(R.id.tv_name)
}