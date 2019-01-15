package com.ranveeraggarwal.flashcards.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ranveeraggarwal.flashcards.database.daos.FlashCardDao
import com.ranveeraggarwal.flashcards.database.entities.CardTag
import com.ranveeraggarwal.flashcards.database.entities.FlashCard
import android.support.annotation.VisibleForTesting


@Database(entities = [FlashCard::class, CardTag::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun FlashCardDao(): FlashCardDao

    companion object {
        private var sInstance: AppDatabase? = null

        @VisibleForTesting
        val DATABASE_NAME = "App_database"

        fun getInstance(context: Context): AppDatabase {
            val tempInstance = sInstance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                sInstance = instance
                return instance
            }
        }

        fun destroyInstance() {
            sInstance = null
        }
    }

}