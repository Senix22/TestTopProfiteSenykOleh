package com.senix22.testtopprofite.ui.view.activity

import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.senix22.testtopprofite.R

class WebActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_activity)

        webView = findViewById(R.id.webView)
        webView.loadUrl("https://www.google.com/")

        webView.webViewClient = MyWebViewClient()
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
            Toast.makeText(this, "Going back inside a WebView", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Exiting a WebView", Toast.LENGTH_SHORT).show()
        }
    }
}