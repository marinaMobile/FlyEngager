package com.superking.parchisi.stara.two

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityAviaSecResBinding
import kotlin.random.Random

class AviaSecRes : AppCompatActivity() {
    private lateinit var neudifj : ActivityAviaSecResBinding
    private lateinit var sharedTable : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        neudifj = ActivityAviaSecResBinding.inflate(layoutInflater)
        setContentView(neudifj.root)
        sharedTable = getSharedPreferences("crRec", MODE_PRIVATE)
        checkCurrentPlane()
        setRecords()
    }

    private fun checkCurrentPlane() = with(neudifj){
        val checkImg = intent.getIntExtra("total_res",0)
        when(checkImg){
            1-> {
                imgRes.setImageResource(R.drawable.pl_sec_gm)

            }

            2-> {
                imgRes.setImageResource(R.drawable.airplane_red)

            }

            3-> {
                imgRes.setImageResource(R.drawable.airplane_good)

            }
        }
    }

    private fun setRecords() = with(neudifj){
        val resList = AviaSecUtils.listResults[Random.nextInt(8)]
        val resRec = sharedTable.getInt("maxRec",0)
        tvRecNew.text = "Your result - $resList km"
        tvRec.text = "Your record - $resRec"
        if(resList>resRec){
            tvRec.text = "Your record - $resList"
            sharedTable.edit().putInt("maxRec",resList).apply()
        }

        button.setOnClickListener {
            startActivity(Intent(this@AviaSecRes,AviTwo::class.java))
        }

    }
}