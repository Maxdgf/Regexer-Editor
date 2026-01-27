package com.maxdgf.regexer.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

import com.maxdgf.regexer.core.data_management.databases.saved_regexp_patterns_database.RegexpPatternDatabase

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRegexpPatternAppDatabase(@ApplicationContext context: Context): RegexpPatternDatabase =
        Room.databaseBuilder(
            context,
            RegexpPatternDatabase::class.java,
            "regexp_database"
        ).fallbackToDestructiveMigration(false).build()

    @Singleton
    @Provides
    fun regexpPatternDao(regexpPatternDatabase: RegexpPatternDatabase) = regexpPatternDatabase.getRegexpPatternDao()
}