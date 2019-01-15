package com.ranveeraggarwal.flashcards.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "flashCard",
    indices = [Index(value = ["cid"], unique = true)],
    primaryKeys = ["cid"])
data class FlashCard (@ColumnInfo(name = "cid") val id: Long,
                      @ColumnInfo(name = "question") @NonNull val question: String,
                      @ColumnInfo(name = "answer") @NonNull val answer: String)