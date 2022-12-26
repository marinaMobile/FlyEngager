package com.superking.parchisi.stara.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.superking.parchisi.stara.R

class AviOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avi_one)
    }

    companion object{
        val KEY_BALAMCE = "balance"
        val MAIN_KEY_SHARED_PREF_BALANVE = "VOLCANO_BAL_SP"
        val KEY_GAME_VARIANT = "gaaame"
    }
}