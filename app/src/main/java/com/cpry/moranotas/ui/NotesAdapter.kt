package com.cpry.moranotas.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cpry.moranotas.R
import com.cpry.moranotas.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(private val notes:List<Note>,
                   private val context: Context,
                   private val deleteFunction: (Int) -> Unit) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.item_note_title!!
        var description = itemView.item_note_description!!
        var delete = itemView.item_note_delete!!

        fun bindView(note: Note) {
            title.text = note.title
            description.text = note.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.bindView(note)
        holder.delete.setOnClickListener {
            deleteFunction.invoke(note.id)
        }
    }
}

