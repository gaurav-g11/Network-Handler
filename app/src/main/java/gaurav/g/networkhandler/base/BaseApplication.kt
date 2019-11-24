package gaurav.g.networkhandler.base

import android.app.Application
import android.content.Context

/**
 * Created by gaurav
 */
class BaseApplication : Application() {

    companion object {
        // lateinit var context: Context
        // or
        lateinit var context: BaseApplication

}


    override fun onCreate() {
        super.onCreate()
        context = this
    }
}