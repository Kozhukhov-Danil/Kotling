package com.lab_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.lab_6.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            user = savedInstanceState.getParcelable("USER")
        } else {
            user = intent.getParcelableExtra("USER")
        }

        binding.buttonToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("USER", user)
            }
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("USER", user)
    }
}
