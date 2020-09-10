package lv.romstr.mobile.rtu_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_clicker.*

class ClickerActivity : AppCompatActivity() {


    private var clicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clicker)

        clicks = savedInstanceState?.getInt(CLICKS_EXTRA) ?: 0
        clickerText.text="$clicks"

        clickerButton.setOnClickListener { incrementClickCount() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState . putInt (CLICKS_EXTRA, clicks)
    }

    private fun updClickerText (kliki : Int ){
        clickerText.text="$kliki"
    }

    private fun incrementClickCount() {
        clicks++
        //clickerText.text = "$clicks"
        updClickerText(clicks)

        if (clicks % 10 == 0) {
            Toast.makeText(this, getString(R.string.clicker_toast, clicks), Toast.LENGTH_SHORT)
                .show()
        }
    }
    companion object {
        private const val CLICKS_EXTRA = "pr07"
    }
}