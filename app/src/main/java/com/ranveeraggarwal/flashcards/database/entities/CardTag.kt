package com.ranveeraggarwal.flashcards.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.support.annotation.NonNull

@Entity(tableName = "card_tag",
    foreignKeys = [ForeignKey(entity = FlashCard::class, parentColumns=["cid"],
        childColumns = ["cardId"], onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["cardId", "tagName"], unique = true)],
    primaryKeys = ["cardId", "tagName"])
data class CardTag(@ColumnInfo(name = "cardId") @NonNull val cardId: Long,
                   @ColumnInfo(name = "tagName") @NonNull val tagName: String)