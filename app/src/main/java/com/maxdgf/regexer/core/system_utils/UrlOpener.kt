package com.maxdgf.regexer.core.system_utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

class UrlOpener(private val context: Context) {
    /**
     * Opens specified url link.
     * @param url target url string.
     */
    fun openUrl(url: String) {
        val uri = url.toUri() // url as uri
        val intent = Intent(Intent.ACTION_VIEW, uri)

        context.startActivity(intent) // open url
    }
}