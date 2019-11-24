package gaurav.g.networkhandler.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by gaurav
 */
open class BaseActivity : AppCompatActivity() {

  fun showToast(msg:String){
      Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
  }
}