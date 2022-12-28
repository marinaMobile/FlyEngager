package com.superking.parchisi.stara.plc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityBrilliantBinding

class Brilliant : AppCompatActivity() {
    lateinit var bindBril: ActivityBrilliantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBril = ActivityBrilliantBinding.inflate(layoutInflater)
        setContentView(bindBril.root)

        bindBril.ploci.setOnClickListener {
            val intent = Intent(this, PearlActivity::class.java)
            intent.putExtra("WebInt", "policy")
            startActivity(intent)
        }
    }
}