package com.maxdgf.regexer.core.data_management.databases.saved_regexp_patterns_database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [RegexpPatternEntity::class], // entities
    version = 3 // db version index
)
abstract class RegexpPatternDatabase : RoomDatabase() {
    abstract fun getRegexpPatternDao(): RegexpPatternDao
}