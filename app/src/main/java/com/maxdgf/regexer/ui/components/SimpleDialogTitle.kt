package com.maxdgf.regexer.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.maxdgf.regexer.R

/**
 * Creates a simple custom title with custom title icon, custom title text and custom dismiss button.
 *
 * @param titleIconTint title icon tint.
 * @param titleTextColor title text color.
 * @param titleTextContent title text content.
 * @param titleIconPainter painter for title icon.
 * @param dismissButtonPainter painter for dismiss icon button.
 * @param onDismissRequestFunction on dismiss request function.
 */
@Composable
fun SimpleUiDialogTitle(
    titleIconTint: Color = MaterialTheme.colorScheme.onSecondary,
    titleTextColor: Color = MaterialTheme.colorScheme.onSecondary,
    titleTextContent: String,
    titleIconPainter: Painter,
    dismissButtonPainter: Painter = painterResource(R.drawable.baseline_clear_24),
    onDismissRequestFunction: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(
            painter = titleIconPainter,
            contentDescription = null,
            tint = titleIconTint,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = titleTextContent,
            color = titleTextColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 10.dp)
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { onDismissRequestFunction() }) {
            Icon(
                painter = dismissButtonPainter,
                contentDescription = null
            )
        }
    }
}