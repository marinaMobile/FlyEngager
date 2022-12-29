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
        val switchOne: Switch = findViewById(R.id.sitchTheme)
        val switchTwo: Switch = findViewById(R.id.switchMusic)
//
//        bindSet.sitchTheme.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                Toast.makeText(this@AviSet, "checked", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this@AviSet, "is not checked", Toast.LENGTH_SHORT).show()
//            }
//        })

        bindSet.sbtBtn.setOnClickListener {
            val statusSwitch1: String =
                if (switchOne.isChecked) switchOne.textOn
                    .toString() else switchOne.textOff.toString()
            val statusSwitch2: String =
                if (switchTwo.isChecked) switchTwo.textOn
                    .toString() else switchTwo.textOff.toString()

            Log.d("StatusSwitch", "Switch1 :$statusSwitch1\n" +
                    "Switch2 :$statusSwitch2")
//            Toast.makeText(this@AviSet, "Switch1 :$statusSwitch1\nSwitch2 :$statusSwitch2", Toast.LENGTH_LONG).show()

        }


    }
}