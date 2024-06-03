package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

@Database(entities = [Item::class], version=1, exportSchema = false)
abstract class InventryDatabase : RoomDatabase(){
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventryDatabase? = null

        fun getDatabase(context: Context): InventryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}