package com.superking.parchisi.stara.two

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityFlySecScrBinding

class FlySecScr : AppCompatActivity() {
    private lateinit var kxskmsd : ActivityFlySecScrBinding
    var fgtefwfdfssf: Animation? = null
    var checkImg = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kxskmsd = ActivityFlySecScrBinding.inflate(layoutInflater)

        val shar = getSharedPreferences("BACKS", Context.MODE_PRIVATE)

        val back = shar.getInt("backgr", 4)
        when (back) {
            0 -> kxskmsd.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_1)
            1 -> kxskmsd.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_2)
            2 -> kxskmsd.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_3)
            3 -> kxskmsd.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_4)
            else -> kxskmsd.root.setBackgroundResource(R.drawable.hghgg)
        }

        setContentView(kxskmsd.root)
        fgtefwfdfssf = AnimationUtils.loadAnimation(applicationContext, R.anim.plane_fly_anim_sec)
        checkCurrentPlane()
        launchAnim()

    }



    private fun launchAnim() = with(kxskmsd){
        imageView.startAnimation(fgtefwfdfssf)
        Handler().postDelayed({
            imageView2.startAnimation(fgtefwfdfssf)
        },1000)

        Handler().postDelayed({
            imageView3.startAnimation(fgtefwfdfssf)
        },2000)

        fgtefwfdfssf?.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                imageView.visibility = View.GONE
                imageView2.visibility = View.GONE
                imageView3.visibility = View.GONE
                startActivity(
                    Intent(this@FlySecScr, AviaSecRes::class.java)
                        .putExtra("total_res",checkImg)
                )


            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
    }

    private fun checkCurrentPlane() = with(kxskmsd){
       checkImg = intent.getIntExtra("imgs",0)
        when(checkImg){
            1-> {
              imageView.setImageResource(R.drawable.pl_sec_gm)
              imageView2.setImageResource(R.drawable.pl_sec_gm)
              imageView3.setImageResource(R.drawable.pl_sec_gm)
                checkImg = 1
            }

            2-> {
                imageView.setImageResource(R.drawable.airplane_red)
                imageView2.setImageResource(R.drawable.airplane_red)
                imageView3.setImageResource(R.drawable.airplane_red)
                checkImg = 2
            }

            3-> {
                imageView.setImageResource(R.drawable.airplane_good)
                imageView2.setImageResource(R.drawable.airplane_good)
                imageView3.setImageResource(R.drawable.airplane_good)
                checkImg = 3
            }
        }
    }
}