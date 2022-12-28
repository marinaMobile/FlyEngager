package com.superking.parchisi.stara.plc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityBrilliantBinding
import com.superking.parchisi.stara.one.AviOne
import com.superking.parchisi.stara.two.AviTwo

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

        bindBril.one.setOnClickListener {
            startActivity(Intent(this, AviOne::class.java))
        }

        bindBril.two.setOnClickListener {
            startActivity(Intent(this, AviTwo::class.java))
        }

        bindBril.shop.setOnClickListener {
            Toast.makeText(this, "SHOP", Toast.LENGTH_SHORT).show()
        }
    }
}