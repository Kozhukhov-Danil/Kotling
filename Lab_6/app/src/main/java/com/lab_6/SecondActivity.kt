package com.lab_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.lab_6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            user = savedInstanceState.getParcelable("USER")
        } else {
            user = intent.getParcelableExtra("USER")
        }

        binding.textViewUser.text = "Name: ${user?.name}, Age: ${user?.age}"

        binding.buttonToThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java).apply {
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
