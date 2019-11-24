package gaurav.g.networkhandler.model.response

import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("data")
    val data: Data
)