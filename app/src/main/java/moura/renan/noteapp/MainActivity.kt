package moura.renan.noteapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import moura.renan.noteapp.data.Note
import moura.renan.noteapp.view.NoteAdapter
import moura.renan.noteapp.view.NoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : NoteViewModel
    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        setUpRecyclerView()
        setUpFabClickItem()
    }

    override fun onResume() {
        super.onResume()
        viewModel.noteLiveData.observe(this, Observer { it ->
            populateAdapter(it)
        })

    }

    private fun setUpFabClickItem() {
        fab.setOnClickListener {

        }
    }

    private fun setUpRecyclerView() {
        notesList.run {
            layoutManager  = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }

    }
    private fun populateAdapter(noteList : List<Note>?) {
        if(noteList != null){
            noteAdapter.addItems(noteList)
        }

    }


}
