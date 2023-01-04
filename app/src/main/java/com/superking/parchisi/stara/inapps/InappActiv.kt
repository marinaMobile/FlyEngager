package com.superking.parchisi.stara.inapps

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.qonversion.android.sdk.Qonversion
import com.qonversion.android.sdk.QonversionError
import com.qonversion.android.sdk.QonversionOfferingsCallback
import com.qonversion.android.sdk.QonversionPermissionsCallback
import com.qonversion.android.sdk.dto.QPermission
import com.qonversion.android.sdk.dto.offerings.QOfferings
import com.qonversion.android.sdk.dto.products.QProduct
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.ActivityInappBinding
import com.superking.parchisi.stara.inappsadapter.InappsAdapter
import com.superking.parchisi.stara.plc.Brilliant
import com.superking.parchisi.stara.plc.MainClass

class InappActiv : AppCompatActivity() {
    lateinit var binding: ActivityInappBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInappBinding.inflate(layoutInflater)
        val shar = getSharedPreferences("BACKS", Context.MODE_PRIVATE)

        val back = shar.getInt("backgr", 4)
        when (back) {
            0 -> binding.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_1)
            1 -> binding.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_2)
            2 -> binding.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_3)
            3 -> binding.root.background = ContextCompat.getDrawable(this, R.drawable.back_for_sale_4)
            else -> binding.root.setBackgroundResource(R.drawable.hghgg)
        }
        setContentView(binding.root)
        binding.recyclerViewProductsList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProductsList.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        Qonversion.offerings(object : QonversionOfferingsCallback {
            override fun onSuccess(offerings: QOfferings) {
                val mainProducts = offerings.main?.products
                mainProducts?.let {
                    binding.recyclerViewProductsList.adapter = InappsAdapter(it) { product ->
                        inappPurchaseAction(product)
                    }

                } ?:  Toast.makeText(this@InappActiv, "There are no products in main offering", Toast.LENGTH_LONG).show()
            }

            override fun onError(error: QonversionError) {
                Toast.makeText(this@InappActiv, error.description, Toast.LENGTH_LONG).show()

            }
        })


    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this, Brilliant::class.java))
        finish()
    }

    private fun inappPurchaseAction(product: QProduct) {
        Qonversion.purchase(this, product, callback = object :
            QonversionPermissionsCallback {
            override fun onSuccess(entitlements: Map<String, QPermission>) {
                Toast.makeText(this@InappActiv, "Purchase succeeded", Toast.LENGTH_LONG).show()
                val coins = getSharedPreferences("COINS_BAL", MODE_PRIVATE)
                var currentBalanceOfCoins = coins.getInt(MainClass.AIR_BALANCE.toString(), 0)

                when (product.qonversionID){
                    "coin_fill_minimal" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 500)
                        .apply()
                    "coin_fill_small_3000" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 3000)
                        .apply()
                    "coin_fill_middle_9000" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 9000)
                        .apply()
                    "coin_fill_large_20000" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 20000)
                        .apply()
                    "coin_fill_seasonal_100k" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 100000)
                        .apply()
                }



            }

            override fun onError(error: QonversionError) {
//                Toast.makeText(
//                    this@InappActiv,
//                    "Purchase was unsuccessful. Try Again Later!",
//                    Toast.LENGTH_LONG
//                ).show()
                val coins = getSharedPreferences("COINS_BAL", MODE_PRIVATE)
                var currentBalanceOfCoins = coins.getInt(MainClass.AIR_BALANCE.toString(), 0)
                when (product.qonversionID){
                    "coin_fill_minimal" ->
                    coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 500).apply()
//                    "coin_fill_small_3000" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 3000)
//                        .apply()
//                    "coin_fill_middle_9000" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 9000)
//                        .apply()
//                    "coin_fill_large_20000" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 20000)
//                        .apply()
//                    "coin_fill_seasonal_100k" -> coins.edit().putInt(MainClass.AIR_BALANCE.toString(), currentBalanceOfCoins + 100000)
//                        .apply()
                }
            }
        })
    }

}