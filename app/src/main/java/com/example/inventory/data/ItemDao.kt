package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {
    @Insert
    suspend fun  insert (item:Item)

    @Update
    suspend fun  update(item:Item)

    @Delete
    suspend fun  Delete(item: Item)

    @Query("SELECT * FROM items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query( "SELECT * FROM items ORDER BY name ASC")
    fun getALLItems(): Flow<List<Item>>

}