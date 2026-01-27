package com.maxdgf.regexer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Creates a regexp match info item for lazycolumn.
 *
 * @param index match index.
 * @param matchValue match value.
 * @param start start match index.
 * @param end end match index.
 */
@Composable
fun RegexUiMatch(
    index: Int,
    matchValue: String,
    start: Int,
    end: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = index.toString(),
            fontWeight = FontWeight.Bold
        )

        Column {
            Text(text = matchValue)
            Text(
                text = "start: $start end: $end length: ${end - start}", // match data
                fontWeight = FontWeight.Light,
                fontSize = 10.sp
            )
        }
    }
}