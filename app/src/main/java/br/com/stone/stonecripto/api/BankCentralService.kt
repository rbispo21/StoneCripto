package br.com.stone.stonecripto.api

import br.com.stone.stonecripto.model.BankCentralModelRest
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BankCentralService {
    companion object {
        val instance: BankCentralService by lazy {
            val gson = GsonBuilder().setLenient().create()
            val client = OkHttpClient.Builder()
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)


            val builder = Retrofit.Builder()
            builder.baseUrl("https://olinda.bcb.gov.br/")
            builder.addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
            val retrofit = builder.build()
            retrofit.create(BankCentralService::class.java)
        }
    }

    @GET("olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    fun getCriptoPrice(@Query("@dataCotacao") data: String, @Query("\$format") format: String): Observable<BankCentralModelRest>
}