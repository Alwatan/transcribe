package tz.co.dbs.transcribe.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tz.co.dbs.transcribe.model.Converters
import tz.co.dbs.transcribe.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}