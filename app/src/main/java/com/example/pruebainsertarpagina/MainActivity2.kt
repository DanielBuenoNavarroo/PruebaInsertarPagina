package com.example.pruebainsertarpagina

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(url = "https://aulavirtual.centroafuera.es/moodle/")
        }
    }
}

@Composable
fun App(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = Client()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    }, modifier = Modifier.fillMaxSize())
}