package com.ranveeraggarwal.flashcards.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ranveeraggarwal.flashcards.database.entities.FlashCard

@Dao
interface FlashCardDao {
    @Query("SELECT * FROM flashCard WHERE cid = :id LIMIT 1")
    fun findFlashCardById(id: Long): FlashCard

    @Query("SELECT cardId FROM card_tag WHERE tagName = :tag")
    fun findFlashCardIdsByTag(tag: String): LiveData<List<Long>>
}