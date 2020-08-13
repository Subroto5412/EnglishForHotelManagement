package com.subroto.english.hotelmanagement.ui.main.slider

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.R

class ViewPagerAdapter(
    private var title: List<String>,
    private var subTitle: List<String>,
    private var images: List<Int>
) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.title)
        val itemSubTitle: TextView = itemView.findViewById(R.id.sub_title)
        val images: ImageView = itemView.findViewById(R.id.slider_img)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Pager2ViewHolder {

        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.index_page, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemSubTitle.text = subTitle[position]
        holder.images.setImageResource(images[position])
        if (position == 0) {
            holder.itemTitle.setTextColor(Color.parseColor("#0D81FF"));
        } else if (position == 1) {
            holder.itemTitle.setTextColor(Color.parseColor("#30D64C"));
        } else if (position == 2) {
            holder.itemTitle.setTextColor(Color.parseColor("#FF7A00"));
        }
    }
}