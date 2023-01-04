package com.superking.parchisi.stara.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.one.fffrrrragg.LauuunchFragment
import com.superking.parchisi.stara.plc.Brilliant
import com.superking.parchisi.stara.plc.MainClass.Companion.AIR_BALANCE
import com.superking.parchisi.stara.set.AudioPlay

class AviOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avi_one)
    }

    override fun onBackPressed() {
        val fragmentInstance =
            supportFragmentManager.findFragmentById(R.id.frag_cont)?.childFragmentManager?.fragments?.last()
        if (fragmentInstance is LauuunchFragment) {
            val intent = Intent(this, Brilliant::class.java)
            startActivity(intent)
            finish()
        } else{
            super.onBackPressed()
        }
    }


    companion object{
        val KEY_BALAMCE = AIR_BALANCE.toString()
        val MAIN_KEY_SHARED_PREF_BALANVE = "COINS_BAL"
        val KEY_GAME_VARIANT = "gaaame"
    }
}