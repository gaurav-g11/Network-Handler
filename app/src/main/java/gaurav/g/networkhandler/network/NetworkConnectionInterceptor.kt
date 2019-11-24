package gaurav.g.networkhandler.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.util.Log


/**
 * Created by gaurav
 */
class NetworkConnectionInterceptor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (!isInternetAvailable()) {
           Log.d("Alert : ","No Internet Available")
        }
        return chain.proceed(request)
    }


    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}