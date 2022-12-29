package com.superking.parchisi.stara.plc

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityBrilliantBinding
import com.superking.parchisi.stara.one.AviOne
import com.superking.parchisi.stara.set.AudioPlay
import com.superking.parchisi.stara.set.AviSet
import com.superking.parchisi.stara.two.AviTwo


class Brilliant : AppCompatActivity() {
    lateinit var music: MediaPlayer

    lateinit var bindBril: ActivityBrilliantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBril = ActivityBrilliantBinding.inflate(layoutInflater)
        setContentView(bindBril.root)

        val animBlink = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.blink);

        bindBril.imageView4.startAnimation(animBlink)

//        music = MediaPlayer.create(this, R.raw.inf);
//        music.start();


        AudioPlay.playAudio(this, R.raw.inf)


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

        bindBril.setTings.setOnClickListener {
            startActivity(Intent(this, AviSet::class.java))
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