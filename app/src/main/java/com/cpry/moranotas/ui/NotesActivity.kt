package com.cpry.moranotas.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.cpry.moranotas.R
import com.cpry.moranotas.model.Note
import kotlinx.android.synthetic.main.activity_notes.*
import java.util.*

class NotesActivity : AppCompatActivity() {

    private lateinit var adapter: NotesAdapter
    private lateinit var layoutManager: StaggeredGridLayoutManager
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        configure()
    }

    companion object {
        var notes = ArrayList<Note>()

        fun addNote(note: Note) {
            notes.add(note)
        }
    }

    private fun configure() {
        getNotes()
        setViewElements()
        setEvents()
    }

    private fun setViewElements() {
        recyclerView = recyclerViewNotes
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        setAdapter(recyclerView)
    }

    private fun getNotes() {
        Note(1, Date(),"TItulo da nota", "LOREMIPSUM", Date(),"")

        var notes2 = listOf(
            Note(1, Date(),"TItulo da nota", "LOREMIPSUM", Date(),""),
            Note(2, Date(),"TItulo da nota", "LOREMIPSUMLOREMIPSUM", Date(),"")
        )
        notes.addAll(notes2)
    }

    fun setAdapter(recycler: RecyclerView) {
        adapter = NotesAdapter(notes, this) {deleteNote(it)}
        recycler.adapter = adapter
    }

    fun setEvents() {
        button2.setOnClickListener{
            //goAddNotesActivity()
            NotesActivity.addNote(Note(1, Date(),"TItulo da nota", "LOREMIPSUM", Date(),""))
            adapter.notifyItemInserted(notes.size -1)
        }
    }

    fun addNotes() {
        //devera ir para a activity de adicionar notas
        notes.add(Note(1, Date(),"TItulo da nota", "LOREMIPSUM", Date(),""))

    }

    private fun deleteNote(noteId: Int) {
        println(noteId)
        // ("falta implementar o banco")
    }

    fun goAddNotesActivity() {
        val i = Intent(this, AddNotesActivity::class.java)
        startActivity(i)
    }
}