package com.superking.parchisi.stara.plc

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=LbwKKoO9eF4GLMz")
    suspend fun getData(): Response<CountryCodeJS>
}

interface HostInterface {
    @GET("bee.json")
    suspend fun getDataDev(): Response<GeoDev>
}

class CountryRepo(private val countryApi: ApiInterface) {
    suspend fun getDat() = countryApi.getData()
}
class DevRepo(private val devData: HostInterface) {
    suspend fun getDataDev() = devData.getDataDev()
}

@Keep
data class CountryCodeJS(
    @SerializedName("countryCode")
    val cou: String,
)


@Keep
data class GeoDev(
    @SerializedName("ge")
    val geo: String,
    @SerializedName("vi")
    val view: String,
    @SerializedName("aps")
    val appsChecker: String,
)