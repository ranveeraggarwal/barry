package com.ranveeraggarwal.flashcards.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ranveeraggarwal.flashcards.database.entities.CardTag

@Dao
public interface CardTagDao {
    @Query("SELECT * FROM card_tag ORDER BY tagName ASC")
    fun getAllTags(): LiveData<List<CardTag>>
}