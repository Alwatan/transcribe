package tz.co.dbs.transcribe.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import tz.co.dbs.transcribe.data.NoteDao
import tz.co.dbs.transcribe.model.Note
import java.util.UUID
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dao: NoteDao
) {
    fun getNotes() = dao.get().flowOn(Dispatchers.IO).conflate()

    suspend fun getNote(id: UUID) = dao.get(id)

    suspend fun insert(note: Note) = dao.insert(note)

    suspend fun delete(note: Note) = dao.delete(note)

    suspend fun delete() = dao.delete()

    suspend fun update(note: Note) = dao.update(note)
}