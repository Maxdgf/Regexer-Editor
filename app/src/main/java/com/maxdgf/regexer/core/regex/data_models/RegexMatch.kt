package com.maxdgf.regexer.core.regex.data_models

import androidx.compose.runtime.Immutable
import java.util.UUID

@Immutable
data class RegexMatch(
    val match: String, // match value(string)
    val start: Int, // match end index
    val end: Int, // match start index
    val id: String = UUID.randomUUID().toString() // key for lazycolumn
)