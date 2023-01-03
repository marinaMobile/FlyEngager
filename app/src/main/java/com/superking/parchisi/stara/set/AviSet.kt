package com.superking.parchisi.stara.set

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityAviSetBinding


class AviSet : AppCompatActivity() {
    lateinit var bindSet: ActivityAviSetBinding
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avi_set)
        bindSet = ActivityAviSetBinding.inflate(layoutInflater)

        val shar = getSharedPreferences("BACKS", Context.MODE_PRIVATE)

            val back = shar.getInt("backgr", 4)
            when (back) {
                0 -> bindSet.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_1)
                1 -> bindSet.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_2)
                2 -> bindSet.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_3)
                3 -> bindSet.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_4)
                else -> bindSet.root.setBackgroundResource(R.drawable.hghgg)
            }
            setContentView(bindSet.root)

        bindSet.light.setOnClickListener {
            this.setTheme(R.style.Theme_BrilliantPearl)
        }

        bindSet.sbtBtn.setOnClickListener {

        }


    }
}