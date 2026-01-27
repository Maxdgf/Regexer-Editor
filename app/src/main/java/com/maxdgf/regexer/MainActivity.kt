package com.maxdgf.regexer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.maxdgf.regexer.ui.screens.MainAppScreen
import com.maxdgf.regexer.ui.theme.RegexerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegexerTheme {
                MainAppScreen()
            }
        }
    }
}