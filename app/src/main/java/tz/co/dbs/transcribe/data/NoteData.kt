package tz.co.dbs.transcribe.data

import tz.co.dbs.transcribe.model.Note

object NotesDataSource {
    val notes = mutableListOf(
        Note(title = "Monday Madness", description = "Modification of groups CRUD endpoints in order to map only the necessary details needed"),
        Note(title = "Writing unit tests for permissions feature", description = "Re-writing permissions endpoint to retrieve all permissions from keycloak"),
        Note(title = "Re-writing CRUD endpoints for roles feature", description = "Provide technical support for financial systems reviewed and implemented by June 2026"),
        Note(title = "Vimeo vya Thursday", description = "Added endpoints to assign and unassign permissions to a specific role"),
        Note(title = "Errors and bug fixes on roles and permissions", description = "Had a meeting with the team to discuss the scope of level of work that is already completed in identity management")
    )

    fun loadNotes(): List<Note> {
        return notes
    }

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun removeNote(note: Note) {
        notes.removeIf { it.id.equals(note.id) }
    }
}