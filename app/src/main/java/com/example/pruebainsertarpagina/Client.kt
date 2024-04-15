package com.example.pruebainsertarpagina

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast


class Client : WebViewClient() {

    /*override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url.toString()
        if (url.endsWith(".pdf") || url.contains(".pdf?")) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(url), "application/pdf")
            try {
                view?.context?.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    view?.context,
                    "No se encontró una aplicación para abrir PDF",
                    Toast.LENGTH_SHORT
                ).show()
            }
            return true
        }
        return super.shouldOverrideUrlLoading(view, request)
    }*/

    @Deprecated("Deprecated in Java")
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
            view?.loadUrl(url)
            true
        } else {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            view?.context?.startActivity(intent)
            true
        }
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?) : Boolean {
        val url = request?.url.toString()
        return if (url.startsWith("http://") || url.startsWith("https://")) {
            view?.loadUrl(url)
            true
        } else {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            view?.context?.startActivity(intent)
            true
        }
    }

}



