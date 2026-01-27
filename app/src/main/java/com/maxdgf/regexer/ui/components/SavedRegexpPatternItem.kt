package com.maxdgf.regexer.ui.components

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import com.maxdgf.regexer.R

/**
 * Creates a saved regexp pattern item for lazycolumn.
 *
 * @param regexpName name of regexp pattern.
 * @param flagsString all enabled flags string.
 * @param regexp regexp.
 * @param itemClickFunction item click function.
 * @param deleteButtonFunction delete item function.
 */
@Composable
fun SavedRegexpPatternUiItem(
    regexpName: String,
    flagsString: String,
    regexp: AnnotatedString,
    itemClickFunction: () -> Unit,
    deleteButtonFunction: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { itemClickFunction() })
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = regexpName,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = regexp,
                modifier = Modifier.basicMarquee(Int.MAX_VALUE)
            )

            if (flagsString.isNotEmpty())
                Text(
                    text = flagsString,
                    modifier = Modifier.basicMarquee(Int.MAX_VALUE),
                    fontWeight = FontWeight.Light
                )
        }

        IconButton(
            onClick = { deleteButtonFunction() },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_delete_outline_24),
                contentDescription = null
            )
        }
    }
}