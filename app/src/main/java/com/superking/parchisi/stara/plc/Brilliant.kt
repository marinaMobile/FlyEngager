package com.superking.parchisi.stara.plc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Layout
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityBrilliantBinding
import com.superking.parchisi.stara.inapps.InappActiv
import com.superking.parchisi.stara.inapps.ShopActivity
import com.superking.parchisi.stara.one.AviOne
import com.superking.parchisi.stara.plc.MainClass.Companion.AIR_BALANCE
import com.superking.parchisi.stara.set.AudioPlay
import com.superking.parchisi.stara.set.AviSet
import com.superking.parchisi.stara.two.AviTwo


class Brilliant : AppCompatActivity() {
    lateinit var music: MediaPlayer

//    val shar = getSharedPreferences("BACK", Context.MODE_PRIVATE)
//    val back = shar.getInt("back", 4)

    lateinit var bindBril: ActivityBrilliantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBril = ActivityBrilliantBinding.inflate(layoutInflater)

        val shar = getSharedPreferences("BACK", Context.MODE_PRIVATE)

        setContentView(bindBril.root)




        val settings = getSharedPreferences("PREFS_NAME", 0)


        val settingsForBalanceOfCoins = getSharedPreferences("COINS_BAL", MODE_PRIVATE)
        var currentBalance = settingsForBalanceOfCoins.getInt(AIR_BALANCE.toString(), 0)

        bindBril.balanceAirTextView.text = "$currentBalance+"


        if (settings.getBoolean("my_first_time", true)) {
            shar.edit().putInt("backgr", 4).apply()
            settings.edit().putBoolean("my_first_time", false).apply()
        } else {
            val back = shar.getInt("backgr", 4)
            when (back) {
                0 -> bindBril.llMain.setBackgroundResource(R.drawable.back_for_sale_1)
                1 -> bindBril.llMain.setBackgroundResource(R.drawable.back_for_sale_2)
                2 -> bindBril.llMain.setBackgroundResource(R.drawable.back_for_sale_3)
                3 -> bindBril.llMain.setBackgroundResource(R.drawable.back_for_sale_4)
                else -> bindBril.llMain.setBackgroundResource(R.drawable.hghgg)
            }
        }




        val animBlink = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.blink);

        bindBril.imageView4.startAnimation(animBlink)

//        music = MediaPlayer.create(this, R.raw.inf);
//        music.start();


        AudioPlay.playAudio(this, R.raw.inf)

        bindBril.balanceAirTextView.setOnClickListener {
            startActivity(Intent(this, InappActiv::class.java))
            finish()
        }


        bindBril.ploci.setOnClickListener {
            val intent = Intent(this, PearlActivity::class.java)
            intent.putExtra("WebInt", "policy")
            startActivity(intent)
            finish()
        }

        bindBril.one.setOnClickListener {
            startActivity(Intent(this, AviOne::class.java))
            finish()
        }

        bindBril.two.setOnClickListener {
            startActivity(Intent(this, AviTwo::class.java))
            finish()
        }

        bindBril.shop.setOnClickListener {
            Toast.makeText(this, "SHOP", Toast.LENGTH_SHORT).show()
        }

        bindBril.setTings.setOnClickListener {
            startActivity(Intent(this, AviSet::class.java))
            finish()
        }

        bindBril.shop.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
            finish()
        }
    }


    override fun onResume() {
        super.onResume()
        AudioPlay.playAudio(this, R.raw.inf)
    }

    override fun onPause() {
        super.onPause()
        AudioPlay.stopAudio()
    }

}