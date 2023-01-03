package com.superking.parchisi.stara.two

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.superking.parchisi.stara.plc.MainClass.Companion.AIR_BALANCE
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityAviaSecResBinding
import kotlin.random.Random

class AviaSecRes : AppCompatActivity() {
    private lateinit var neudifj : ActivityAviaSecResBinding
    private lateinit var sharedTable : SharedPreferences
    private lateinit var settingsForBalanceOfCoins : SharedPreferences
    var currentBalance = 0

    private val winOrNot = listOf(
        "+",
        "-"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        neudifj = ActivityAviaSecResBinding.inflate(layoutInflater)
        setContentView(neudifj.root)
         settingsForBalanceOfCoins = getSharedPreferences("COINS_BAL", MODE_PRIVATE)
        currentBalance = settingsForBalanceOfCoins.getInt(AIR_BALANCE.toString(), 0)
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
        val wn = winOrNot[Random.nextInt(2)]
        when(wn){
            "+" -> {
                if(currentBalance>200){
                val wonner = AviaSecUtils.listWin[Random.nextInt(15)]
                currentBalance = currentBalance.plus(wonner)
                settingsForBalanceOfCoins.edit().putInt(AIR_BALANCE.toString(),currentBalance).apply()
                tvBalance.text = "Your won : + $wonner"

            }else {
                    tvBalance.text = "Nothing won"
                    Toast.makeText(this@AviaSecRes, "Your balance is low", Toast.LENGTH_LONG).show()
            }
                }

            "-" -> {
                if (currentBalance>0){
                    val losser = AviaSecUtils.listWin[Random.nextInt(15)]
                    currentBalance = currentBalance.minus(losser)
                    settingsForBalanceOfCoins.edit().putInt(AIR_BALANCE.toString(),currentBalance).apply()
                    tvBalance.text = "Your loose : - $losser"
                } else {
                    currentBalance = 0
                    tvBalance.text = "Nothing won"
                    Toast.makeText(this@AviaSecRes, "Your balance is 0", Toast.LENGTH_LONG).show()
                }

            }
        }
        tvRecNew.text = "Your result - $resList km"
        tvRec.text = "Your record - $resRec km"
        if(resList>resRec){
            tvRec.text = "Your record - $resList km"
            sharedTable.edit().putInt("maxRec",resList).apply()
        }

        button.setOnClickListener {
            startActivity(Intent(this@AviaSecRes,AviTwo::class.java))
        }

    }

}