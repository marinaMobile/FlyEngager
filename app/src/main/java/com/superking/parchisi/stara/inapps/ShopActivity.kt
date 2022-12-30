package com.superking.parchisi.stara.inapps

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.inappsadapter.BackAdapter
import com.superking.parchisi.stara.inappsadapter.ShopClass
import me.relex.circleindicator.CircleIndicator3

class ShopActivity : AppCompatActivity() {
    var cont: Int = 0

//    val sharPre = getSharedPreferences("BACKS", Context.MODE_PRIVATE)
//    val edit = sharPre.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        setUpGamesPager()
    }

    fun setUpGamesPager() {
        val sharPre = getSharedPreferences("BACKS", Context.MODE_PRIVATE)
        val edddd = sharPre.edit()

        val gamesViewPager: ViewPager2 = findViewById(R.id.gamesVP)
        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        gamesViewPager.clipToPadding= false
        gamesViewPager.clipChildren = false
        gamesViewPager.offscreenPageLimit = 3
        gamesViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        gamesViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compPageTransf = CompositePageTransformer()
        compPageTransf.addTransformer(MarginPageTransformer(10))
        compPageTransf.addTransformer { page, position ->
            val r: Float = 1 - Math.abs(position)
            page.scaleY = (0.85f+r*0.15f)
            page.setOnClickListener{
                when (cont) {
                    0 -> edddd.putInt("backgr", 0).apply()
                    1 -> edddd.putInt("backgr", 1).apply()
                    2 -> edddd.putInt("backgr", 2).apply()
                    3 -> edddd.putInt("backgr", 3).apply()
                }
            }
        }
        gamesViewPager.setPageTransformer(compPageTransf)
        gamesViewPager.adapter = BackAdapter(getGames())
        indicator.setViewPager(gamesViewPager)


        gamesViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {



            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position) {
                    0 -> cont = 0
                    1 -> cont = 1
                    2 -> cont = 2
                    3 -> cont = 3
                }
                Log.e("Selected_Page", position.toString())
            }

        })
    }

    fun getGames(): List<ShopClass> {
        val games: List<ShopClass>


        val first = ShopClass()
        first.nameOfBack = "First back"
        first.category = "duge"
        first.poster = R.drawable.back_for_sale_1

        val second = ShopClass()
        second.nameOfBack = "second"
        second.category = "second"
        second.poster = R.drawable.back_for_sale_2

        val third = ShopClass()
        third.nameOfBack = "third"
        third.category = "third"
        third.poster = R.drawable.back_for_sale_3

        val fourth = ShopClass()
        fourth.nameOfBack = "fourth"
        fourth.category = "fourth"
        fourth.poster = R.drawable.back_for_sale_4

        games = arrayListOf(first, second, third, fourth)

        return games
    }

}