package science.example.toast


import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    var sharedPreferences: SharedPreferences? = null
    var sharedEditor: SharedPreferences.Editor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            sharedPreferences = getPreferences(MODE_PRIVATE)
            sharedEditor = sharedPreferences!!.edit()

            if (isFirstStart()) {

            } else {
                    Toast.makeText(this, "Холодный старт!", Toast.LENGTH_SHORT).show()
            }


        }
    }

    private fun isFirstStart(): Boolean {
        return if (sharedPreferences!!.getBoolean("firstTime", true)) {
                sharedEditor!!.putBoolean("firstTime", false)
                sharedEditor!!.apply()
                true
            } else {
                false
            }
    }
}




