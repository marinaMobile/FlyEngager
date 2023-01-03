package com.superking.parchisi.stara.set

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityAviSetBinding


class AviSet : AppCompatActivity() {
    lateinit var bindSet: ActivityAviSetBinding
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avi_set)
        bindSet = ActivityAviSetBinding.inflate(layoutInflater)

        bindSet.light.setOnClickListener {
            this.setTheme(R.style.Theme_BrilliantPearl)
        }



        bindSet.sbtBtn.setOnClickListener {

        }


    }
}