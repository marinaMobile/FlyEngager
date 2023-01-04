package com.superking.parchisi.stara.inapps

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.inappsadapter.BackAdapter
import com.superking.parchisi.stara.inappsadapter.ShopClass
import com.superking.parchisi.stara.plc.Brilliant
import com.superking.parchisi.stara.plc.MainClass
import me.relex.circleindicator.CircleIndicator3
import kotlin.system.exitProcess

class ShopActivity : AppCompatActivity() {
    var cont: Int = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val settingsForBalanceOfCoins = getSharedPreferences("COINS_BAL", MODE_PRIVATE)
        val currentBalance = settingsForBalanceOfCoins.getInt(MainClass.AIR_BALANCE.toString(), 0)


        val curBal: TextView = findViewById(R.id.curBal)
        curBal.text = "$currentBalance+"

        setUpGamesPager()

    }

    fun setUpGamesPager() {


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
                    0 -> forZero(0, 20000)
                    1 -> forZero(1, 40000)
                    2 -> forZero(2, 75000)
                    3 -> forZero(3, 12000)
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
        first.category = "20000 Air Coins"
        first.poster = R.drawable.back_for_sale_1

        val second = ShopClass()
        second.nameOfBack = "second"
        second.category = "40000 Air Coins"
        second.poster = R.drawable.back_for_sale_2

        val third = ShopClass()
        third.nameOfBack = "third"
        third.category = "75000 Air Coins"
        third.poster = R.drawable.back_for_sale_3

        val fourth = ShopClass()
        fourth.nameOfBack = "fourth"
        fourth.category = "120000 Air Coins"
        fourth.poster = R.drawable.back_for_sale_4

        games = arrayListOf(first, second, third, fourth)

        return games
    }

    fun forZero(back: Int, curr: Int) {

        val settingsForBalanceOfCoins = getSharedPreferences("COINS_BAL", MODE_PRIVATE)
        val currentBalance = settingsForBalanceOfCoins.getInt(MainClass.AIR_BALANCE.toString(), 0)
        val edit = settingsForBalanceOfCoins.edit()
        val sharPre = getSharedPreferences("BACKS", Context.MODE_PRIVATE)
        val edddd = sharPre.edit()
        val txCurBal = findViewById<TextView>(R.id.curBal)

        val currBal = currentBalance - curr
        if (currBal<=0) {
            val build = AlertDialog.Builder(this)
                .setTitle("Air coins ")
                .setMessage("You don't have enough air coins to buy this background!")
                .setPositiveButton("Visit shop page", null)
                .setNegativeButton("Ok", null)
                .show()
            val mPositiveButton = build.getButton(AlertDialog.BUTTON_POSITIVE)
            mPositiveButton.setOnClickListener {
                startActivity(Intent(this, InappActiv::class.java))
                finish()
            }
        } else {
            edit.putInt(MainClass.AIR_BALANCE.toString(), currBal).apply()
            txCurBal.text = "$currBal+"
            edddd.putInt("backgr", back).apply()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this, Brilliant::class.java))
        finish()
    }

}