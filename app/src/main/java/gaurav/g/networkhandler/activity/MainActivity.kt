package gaurav.g.networkhandler.activity

import android.os.Bundle
import gaurav.g.networkhandler.R
import gaurav.g.networkhandler.base.BaseActivity
import gaurav.g.networkhandler.model.response.UserDataResponse
import gaurav.g.networkhandler.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiClient.instance.userData().enqueue(object : Callback<UserDataResponse>{
            override fun onFailure(call: Call<UserDataResponse>, t: Throwable) {
                 showToast(""+t.message)
            }

            override fun onResponse(
                call: Call<UserDataResponse>,
                response: Response<UserDataResponse>
            ) {
                showToast(""+response.body()?.data!!.first_name)
            }

        })
    }
}
