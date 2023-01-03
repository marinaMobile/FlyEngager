package com.superking.parchisi.stara.two

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityAviaSecTableBinding
import kotlin.random.Random

class AviaSecTable : AppCompatActivity() {
    private lateinit var kidofk : ActivityAviaSecTableBinding
    private lateinit var sharedTable : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kidofk = ActivityAviaSecTableBinding.inflate(layoutInflater)

        val shar = getSharedPreferences("BACKS", Context.MODE_PRIVATE)

        val back = shar.getInt("backgr", 4)
        when (back) {
            0 -> kidofk.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_1)
            1 -> kidofk.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_2)
            2 -> kidofk.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_3)
            3 -> kidofk.root.background =
                ContextCompat.getDrawable(this, R.drawable.back_for_sale_4)
            else -> kidofk.root.setBackgroundResource(R.drawable.hghgg)
        }
        setContentView(kidofk.root)
        sharedTable = getSharedPreferences("crRec", MODE_PRIVATE)
        setRecord()

    }

    private fun setRecord() = with(kidofk){
        val currentRec = sharedTable.getInt("maxRec",0)
        val maxRes = "John Makkein - 6000 km"
        tvName1.text = maxRes
        tvName2.text = "Your record - $currentRec km"
        tvName3.text = AviaSecUtils.listrec[Random.nextInt(4)]
        button3.setOnClickListener {
            startActivity(Intent(this@AviaSecTable,AviTwo::class.java))
        }

    }
}