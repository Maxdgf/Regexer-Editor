package com.maxdgf.regexer.core.data_management.databases.saved_regexp_patterns_database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RegexpPatternRepository @Inject constructor(private val regexpPatternDao: RegexpPatternDao) {
    fun allSavedRegexpPatterns(): Flow<List<RegexpPatternEntity>> = regexpPatternDao.getAllSavedRegexpPatterns()
        .flowOn(Dispatchers.IO)
        .conflate()
}