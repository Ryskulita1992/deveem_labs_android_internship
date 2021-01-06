package kg.geektech.deveem_labs_android_internship.ui.detailed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.deveem_labs_android_internship.databinding.ActivitySecondBinding

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}