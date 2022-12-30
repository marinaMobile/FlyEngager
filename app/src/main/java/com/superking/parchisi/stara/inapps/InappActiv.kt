package com.superking.parchisi.stara.inapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.qonversion.android.sdk.Qonversion
import com.qonversion.android.sdk.QonversionError
import com.qonversion.android.sdk.QonversionOfferingsCallback
import com.qonversion.android.sdk.QonversionPermissionsCallback
import com.qonversion.android.sdk.dto.QPermission
import com.qonversion.android.sdk.dto.offerings.QOfferings
import com.qonversion.android.sdk.dto.products.QProduct
import com.superking.parchisi.stara.databinding.ActivityInappBinding
import com.superking.parchisi.stara.inappsadapter.InappsAdapter

class InappActiv : AppCompatActivity() {
    lateinit var binding: ActivityInappBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityInappBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.recyclerViewProductsList.layoutManager = LinearLayoutManager(this)
//        binding.recyclerViewProductsList.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                DividerItemDecoration.VERTICAL
//            )
//        )
//        Qonversion.offerings(object : QonversionOfferingsCallback {
//            override fun onSuccess(offerings: QOfferings) {
//                val mainProducts = offerings.main?.products
//                mainProducts?.let {
//                    binding.recyclerViewProductsList.adapter = InappsAdapter(it) { product ->
//                        inappPurchaseAction(product)
//                    }
//
//                } ?:  Toast.makeText(this@InappActiv, "There are no products in main offering", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onError(error: QonversionError) {
//                Toast.makeText(this@InappActiv, error.description, Toast.LENGTH_LONG).show()
//
//            }
//        })
//    }
//
//    private fun inappPurchaseAction(product: QProduct) {
//        Qonversion.purchase(this, product, callback = object :
//            QonversionPermissionsCallback {
//            override fun onSuccess(entitlements: Map<String, QPermission>) {
//                Toast.makeText(this@InappActiv, "Purchase succeeded", Toast.LENGTH_LONG).show()
//
//            }
//
//            override fun onError(error: QonversionError) {
//                Toast.makeText(
//                    this@InappActiv,
//                    "Purchase was unsuccessful. Try Again Later!",
//                    Toast.LENGTH_LONG
//                ).show()
//
//            }
//        })
    }
}