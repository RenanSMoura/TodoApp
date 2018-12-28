package moura.renan.noteapp.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import moura.renan.noteapp.R
import moura.renan.noteapp.data.Note

class NoteAdapter(val noteList: MutableList<Note> = mutableListOf()) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = noteList.size

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        if (noteList.isNotEmpty()){
            viewHolder.bind(noteList[position])
        }
    }

    fun addItems(listNote : List<Note>) {
        listNote.map {
            noteList.add(it)
        }
        notifyDataSetChanged()
    }

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(note: Note) {
            view.findViewById<TextView>(R.id.noteTitle).text = note.title
            view.findViewById<TextView>(R.id.noteDescription).text = note.description
            view.findViewById<TextView>(R.id.notePriority).text = note.priority.toString()
        }
    }
}