package com.superking.parchisi.stara.two

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.superking.parchisi.stara.databinding.ActivityAviTwoBinding

class AviTwo : AppCompatActivity() {
    private lateinit var mainbind : ActivityAviTwoBinding
    private var choosed = 0
    private var isDash = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbind = ActivityAviTwoBinding.inflate(layoutInflater)
        setContentView(mainbind.root)

        bCheckNav()
        checkersRad()
        mainbind.imgPlaneFrst.setOnClickListener {
            mainbind.imgPlaneSec.alpha = 0.8f
            mainbind.imgThirdPlane.alpha = 0.8f
            Handler().postDelayed({
                clickFstImg()
            },1500)

        }

        mainbind.imgPlaneSec.setOnClickListener {
            mainbind.imgPlaneFrst.alpha = 0.8f
            mainbind.imgThirdPlane.alpha = 0.8f
            Handler().postDelayed({
                clickSecImg()
            },1500)
        }

        mainbind.imgThirdPlane.setOnClickListener {
            mainbind.imgPlaneSec.alpha = 0.8f
            mainbind.imgPlaneFrst.alpha = 0.8f
            Handler().postDelayed({
                clickThirdImg()
            },1500)
        }
    }

    private fun bCheckNav() = with(mainbind){
        bDash.setOnClickListener {
            if (isDash == false){
                startActivity(Intent(this@AviTwo,AviaSecTable::class.java))
            } else{
                if(hundRadB.isChecked || threeHundRadB.isChecked || fifthHundRadB.isChecked){
                    startActivity(Intent(this@AviTwo,FlySecScr::class.java)
                        .putExtra("imgs",choosed)
                    )
                }
            }
        }

    }

    private fun clickFstImg() = with(mainbind){
        choosed = 1
        stepChooseIng()
    }
    private fun clickSecImg() = with(mainbind){

        choosed = 2
        stepChooseIng()
    }

    private fun clickThirdImg() = with(mainbind){
        choosed = 3
        stepChooseIng()
    }


    private fun checkersRad() = with(mainbind){
        hundRadB.setOnCheckedChangeListener{
                _,ischecked -> if (ischecked){
            threeHundRadB.isChecked = false
            fifthHundRadB.isChecked = false
            bDash.alpha = 1.0f


        }else {
            bDash.alpha = 0.8f
        }
        }

        threeHundRadB.setOnCheckedChangeListener{
                _,ischecked -> if (ischecked){
            hundRadB.isChecked = false
            fifthHundRadB.isChecked = false
            bDash.alpha = 1.0f


        }else {
            bDash.alpha = 0.8f
        }
        }

        fifthHundRadB.setOnCheckedChangeListener{
                _,ischecked -> if (ischecked){
            threeHundRadB.isChecked = false
            hundRadB.isChecked = false
            bDash.alpha = 1.0f


        }else {
            bDash.alpha = 0.8f
        }
        }
    }


    private fun stepChooseIng() = with(mainbind){
         imgPlaneFrst.visibility = View.GONE
         imgPlaneSec.visibility = View.GONE
         imgThirdPlane.visibility = View.GONE
         tvChooseTakeoff.visibility = View.GONE
         bDash.alpha = 0.8f
         bDash.text = "Start fly"
         tvChsEngine.visibility = View.VISIBLE
         tvMkFly.visibility = View.VISIBLE
         tvOne.visibility = View.VISIBLE
         tvTwo.visibility = View.VISIBLE
         tvThree.visibility = View.VISIBLE
         tvAttent.visibility = View.VISIBLE
         hundRadB.visibility = View.VISIBLE
         threeHundRadB.visibility = View.VISIBLE
         fifthHundRadB.visibility = View.VISIBLE
         isDash = true


    }
}