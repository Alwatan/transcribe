package tz.co.dbs.transcribe.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "created_at")
    val createdAt: Date = Date()
)
