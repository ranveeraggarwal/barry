package com.ranveeraggarwal.flashcards.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.support.annotation.NonNull

@Entity(tableName = "flashCard",
    indices = [Index(value = ["cid"], unique = true)],
    primaryKeys = ["cid"])
data class FlashCard (@ColumnInfo(name = "cid") val id: Long,
                      @ColumnInfo(name = "question") @NonNull val question: String,
                      @ColumnInfo(name = "answer") @NonNull val answer: String)