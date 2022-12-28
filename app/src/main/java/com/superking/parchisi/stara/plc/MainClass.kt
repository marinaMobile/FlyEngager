package com.superking.parchisi.stara.plc

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import java.util.*

class MainClass: Application() {

    companion object {
        const val ONESIGNAL_APP_ID = "7e3c29e0-0bec-4c8d-8b74-4ecbcdc0a429"
        val myId: String = "myID"
        var instId: String? = "instID"
        var urlMain: String = "link"
        var MAIN_ID: String? = "main_id"
        var C1: String? = "c11"
        const val myTrId = "18664610231773509174"
        val appsCheckChe: String = "appsCheckChe"
        val geoCo: String = "geoCo"
//        val userCo: String = "userCo"
        val codeCode: String = "uff"
        val deepL: String = "deepL"
    }

    override fun onCreate() {
        super.onCreate()

        val shP = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settings = getSharedPreferences("PREFS_NAME", 0)

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled = true
        val IDIN = UUID.randomUUID().toString()

        if (settings.getBoolean("my_first_time", true)) {
            trackerParams.setCustomUserId(IDIN)
            shP.edit().putString(myId, IDIN).apply()
            shP.edit().putString(instId, instID).apply()
            settings.edit().putBoolean("my_first_time", false).apply()

        } else {
            val shIDIN = shP.getString(myId, IDIN)
            trackerParams.setCustomUserId(shIDIN)
        }
        MyTracker.initTracker(myTrId, this)

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@MainClass)
            modules(listOf(
                viewModelModule, appModule
            ))
        }

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}