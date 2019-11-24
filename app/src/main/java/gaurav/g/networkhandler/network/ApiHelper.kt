package gaurav.g.networkhandler.network

import gaurav.g.networkhandler.model.response.UserDataResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by gaurav
 */
interface ApiHelper {

    @GET("api/users/2")
    fun userData(): Call<UserDataResponse>
}