package com.superking.parchisi.stara.set

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool


object AudioPlay {
    var mediaPlayer: MediaPlayer? = null
    private var soundPool: SoundPool? = null
    var isplayingAudio = false
    fun playAudio(c: Context?, id: Int) {
        mediaPlayer = MediaPlayer.create(c, id)
        soundPool = SoundPool(4, AudioManager.STREAM_MUSIC, 100)
        if (!mediaPlayer!!.isPlaying) {
            isplayingAudio = true
            mediaPlayer!!.isLooping
            mediaPlayer!!.start()
        }
    }

    fun stopAudio() {
        isplayingAudio = false
        mediaPlayer!!.stop()
    }
}