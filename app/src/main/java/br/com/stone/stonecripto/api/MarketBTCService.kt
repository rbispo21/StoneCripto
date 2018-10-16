package br.com.stone.stonecripto.api

import br.com.stone.stonecripto.model.TickerModelRest
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface MarketBTCService {
    companion object {
        val instance: MarketBTCService by lazy {
            val gson = GsonBuilder().setLenient().create()
            val client = OkHttpClient.Builder()
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)


            val builder = Retrofit.Builder()
            builder.baseUrl("https://www.mercadobitcoin.net/")
            builder.addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
            val retrofit = builder.build()
            retrofit.create(MarketBTCService::class.java)
        }
    }

    @GET("api/{coin}/ticker/")
    fun getCriptoPrice(@Path("coin") coin: String): Observable<TickerModelRest>
}