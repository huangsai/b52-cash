package com.mobile.app.cash.core.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mobile.app.cash.store.db.DbMessage
import com.mobile.app.cash.store.db.PlatformDatabase

@Database(
    entities = [
        DbMessage::class,
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase(), PlatformDatabase {

    class DbCallback : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
        }

        override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
            super.onDestructiveMigration(db)
        }
    }

    class DbMigration(startVersion: Int, endVersion: Int) : Migration(startVersion, endVersion) {

        override fun migrate(database: SupportSQLiteDatabase) {
        }
    }
}