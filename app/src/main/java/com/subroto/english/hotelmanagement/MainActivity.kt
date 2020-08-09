package com.subroto.english.hotelmanagement

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.subroto.english.hotelmanagement.R
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3


class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var subTitlesList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar()?.hide(); //hide the title bar
        setContentView(R.layout.activity_main)
        listDataManager()

        view_pager2.adapter =
            ViewPagerAdapter(
                titlesList,
                subTitlesList,
                imagesList
            )
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator: CircleIndicator3 = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)
    }

    private fun addToListModel(title: String, subtTitle: String, image: Int) {
        titlesList.add(title)
        subTitlesList.add(subtTitle)
        imagesList.add(image)
    }

    private fun listDataManager() {
        for (i: Int in 1..3) {
            if (i == 1) {
                addToListModel(title = getString(R.string.slider_title1),subtTitle = getString(
                    R.string.slider_subtitle1
                ), image = R.drawable.slider_pic1
                )
            } else if (i == 2) {
                addToListModel(title = getString(R.string.slider_title2),subtTitle = getString(
                    R.string.slider_subtitle2
                ), image = R.drawable.slider_pic2
                )
            } else if (i == 3) {
                addToListModel(title = getString(R.string.slider_title3),subtTitle = getString(
                    R.string.slider_subtitle3
                ), image = R.drawable.slider_pic3
                )
            }
        }
    }
}