package com.maxdgf.regexer.ui.data_management.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

import com.maxdgf.regexer.ui.data_management.data_models.RegexFlagItem
import com.maxdgf.regexer.core.regex.data_models.RegexMatch

class AppState : ViewModel() {
    // regexp settings and parameters management (states)
    var regexInputFieldState by mutableStateOf("")
    var currentRegexAsString by mutableStateOf("")
    var matchesCount by mutableIntStateOf(0)
    var saveRegexpName by mutableStateOf("")
    var regexExceptionMessage: String? by mutableStateOf(null) // regexp exception message
    var regexExceptionView by mutableStateOf(false)
    var regexFlagsView by mutableStateOf(false)
    private val _regexFlagsList = MutableStateFlow(
        listOf<RegexFlagItem>(
            RegexFlagItem("Ignore Case", RegexOption.IGNORE_CASE),
            RegexFlagItem("Multiline", RegexOption.MULTILINE),
            RegexFlagItem("Literal", RegexOption.LITERAL),
            RegexFlagItem("Dot matches all", RegexOption.DOT_MATCHES_ALL),
            RegexFlagItem("Unix lines", RegexOption.UNIX_LINES)
        )
    )
    val regexFlagsList = _regexFlagsList.asStateFlow()
    private val _isRegexGlobalSearch = MutableStateFlow(true)
    val isRegexGlobalSearch = _isRegexGlobalSearch.asStateFlow()
    private val _isLiteralFlagEnabled = MutableStateFlow(false)
    val isLiteralFlagEnabled = _isLiteralFlagEnabled.asStateFlow()
    var regexFlagsEnabledCount by mutableIntStateOf(0)
    var regexSelectionMatchesColor: Color? by mutableStateOf(null)
    var allMatchesByRegexpList by mutableStateOf(emptyList<RegexMatch>())

    // other (states)
    var textInputFieldState by mutableStateOf("")
    var bottomCheatSheetState by mutableStateOf(false)
    var dropdownMenuState by mutableStateOf(false)
    var colorPickerState by mutableStateOf(false)
    var aboutAppInfoSheetState by mutableStateOf(false)
    var isTestTextFieldFocusedState by mutableStateOf(false)
    var saveRegexpPatternDialogState by mutableStateOf(false)
    var regexpMatchesLisDialogState by mutableStateOf(false)

    // regexp settings and parameters management (state functions)

    /**Updates regex input field state.
     * @param text input text.*/
    fun updateRegexInputFieldState(text: String) {
        regexInputFieldState = text
        currentRegexAsString = text
    }

    /**Returns selected flags as string. Example (Ignore case, Multiline)
     * @return flags string.*/
    fun getSelectedFlags(): String {
        val selectedFlags = _regexFlagsList.value.filter { flag -> flag.isSelected }
        return selectedFlags.joinToString(", ") { flag -> flag.name }
    }

    /**Selects flag by index.
     * @param index flag index.*/
    private fun selectFlag(index: Int) {
        _regexFlagsList.update { list ->
            list.toMutableList().apply {
                this[index] = this[index].copy(isSelected = true)
            }
        }
    }

    /**Sets selected flags from saved regexp.
     * @param flags flags string.*/
    fun setSelectedFlags(flags: String) {
        val flags = flags.split(", ")
        flags.forEach { name ->
            when (name) {
                "Ignore Case" -> selectFlag(0)
                "Multiline" -> selectFlag(1)
                "Literal" -> selectFlag(2)
                "Dot matches all" -> selectFlag(3)
                "Unix lines" -> selectFlag(4)
            }
        }
    }

    fun updateSaveRegexpName(name: String) { saveRegexpName = name }

    fun updateMatchesCount(count: Int) { matchesCount = count }

    fun updateRegexExceptionMessageState(message: String?) { regexExceptionMessage = message }

    fun updateRegexExceptionViewState(state: Boolean) { regexExceptionView = state }

    fun updateRegexFlagsView(state: Boolean) { regexFlagsView = state }

    /**Updates flags list state, selects and sets state to flag by name.
     * @param state bool state to set.
     * @param name flag name.*/
    fun setSelectedRegexFlagState(state: Boolean, name: String) {
        // get current flag item index by name
        val index = _regexFlagsList.value.indexOfFirst { flag ->
            name == flag.name
        }

        // update isSelected state in current flag item by index
        _regexFlagsList.update { list ->
            list.toMutableList().apply {
                this[index] = this[index].copy(isSelected = state)
            }
        }

        // if flag item name is Literal -> update isLiteralFlagEnabled state by current state
        if (name == "Literal") _isLiteralFlagEnabled.value = state
    }

    fun updateIsRegexGlobalSearch(state: Boolean) { _isRegexGlobalSearch.value = state }

    fun updateAllMatchesByRegexpList(matchesList: List<RegexMatch>) { allMatchesByRegexpList = matchesList }


    // other (state functions)
    fun updateTextInputFieldState(text: String) { textInputFieldState = text }

    fun updateBottomCheatSheetState(state: Boolean) { bottomCheatSheetState = state }

    fun updateDropdownMenuState(state: Boolean) { dropdownMenuState = state }

    fun updateRegexFlagsEnabledCount(count: Int) { regexFlagsEnabledCount = count }

    fun updateRegexSelectionMatchesColorState(color: Color) { regexSelectionMatchesColor = color }

    fun updateColorPickerState(state: Boolean) { colorPickerState = state }

    fun updateAboutAppInfoSheetState(state: Boolean) { aboutAppInfoSheetState = state }

    fun updateIsTestTextFieldFocusedState(state: Boolean) { isTestTextFieldFocusedState = state }

    fun updateSaveRegexpPatternDialogState(state: Boolean) { saveRegexpPatternDialogState = state }

    fun updateRegexpMatchesListDialogState(state: Boolean) { regexpMatchesLisDialogState = state }
}