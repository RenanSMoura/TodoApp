package moura.renan.noteapp.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import moura.renan.noteapp.data.Note
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class NoteRepository {

    fun getNotes(): LiveData<List<Note>> {
        val data = MutableLiveData<List<Note>>()
        data.value = createFakeListForNow()
        return data
    }

    private fun createFakeListForNow(): List<Note> {
        return createRandomList(5)
    }


    private fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    private fun randomInt() = ThreadLocalRandom.current().nextInt(0,1000 + 1)
    private fun createRandomList(number: Int): List<Note> {
        val list = mutableListOf<Note>()
        repeat(number) {
            list.add(Note(randomInt(), randomUuid(), randomUuid(), randomInt()))
        }
        return list
    }

}