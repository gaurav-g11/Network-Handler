package gaurav.g.networkhandler.network

import gaurav.g.networkhandler.base.BaseApplication.Companion.context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gaurav
 */
object ApiClient {
    private const val BASE_URL = "https://reqres.in/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(NetworkConnectionInterceptor(context))
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/json")
                .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: ApiHelper by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

            retrofit.create(ApiHelper::class.java)

    }



}