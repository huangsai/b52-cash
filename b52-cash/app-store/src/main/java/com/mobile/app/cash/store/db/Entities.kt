package com.mobile.app.cash.store.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "message"
)
data class DbMessage(
    @ColumnInfo(name = "_id") @PrimaryKey(autoGenerate = true) val _id: Long
)