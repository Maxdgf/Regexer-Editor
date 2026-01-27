package com.maxdgf.regexer.ui.data_management.data_models

import androidx.compose.runtime.Immutable
import java.util.UUID

@Immutable
data class RegexFlagItem(
    val name: String, // flag name
    val flag: RegexOption, // regex flag
    val isSelected: Boolean = false, // is flag selected state
    val id: String = UUID.randomUUID().toString() // key for lazycolumn
)
