package tz.co.dbs.transcribe.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import tz.co.dbs.transcribe.model.Note
import java.util.UUID

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun get(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id=(:id)")
    suspend fun get(id: UUID): Note?

    @Delete
    suspend fun delete(note: Note)

    @Query("DELETE FROM notes")
    suspend fun delete()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)
}