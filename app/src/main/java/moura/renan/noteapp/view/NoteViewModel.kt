package moura.renan.noteapp.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import moura.renan.noteapp.data.Note
import moura.renan.noteapp.data.repository.NoteRepository

class NoteViewModel : ViewModel() {

    var noteLiveData : LiveData<List<Note>>
    private var repository = NoteRepository()

    init {
        noteLiveData = repository.getNotes()
    }

}