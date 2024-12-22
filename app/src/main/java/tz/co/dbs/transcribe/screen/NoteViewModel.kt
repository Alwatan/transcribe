package tz.co.dbs.transcribe.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import tz.co.dbs.transcribe.model.Note
import tz.co.dbs.transcribe.repository.NoteRepository
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {


    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNotes().distinctUntilChanged().collect {
                _notes.value = it
            }
        }
    }

    fun insert(note: Note)  = viewModelScope.launch { repository.insert(note) }

    fun delete(note: Note) = viewModelScope.launch { repository.delete(note) }

    fun delete() = viewModelScope.launch { repository.delete() }

    fun update(note: Note) = viewModelScope.launch { repository.update(note) }

    fun getNote(id: UUID) = viewModelScope.launch { repository.getNote(id) }
}