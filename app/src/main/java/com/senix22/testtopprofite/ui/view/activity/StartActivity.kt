package com.senix22.testtopprofite.ui.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.senix22.testtopprofite.R
import kotlinx.coroutines.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val scope = CoroutineScope(Job())
        scope.launch(Dispatchers.IO) {
            delay(3500)
            randomActivity()
        }
    }

    private fun randomActivity() {
        val randomNumber = Math.random() < 0.5
        if (randomNumber) {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, ProductrActivity::class.java)
            startActivity(intent)
        }
    }
}