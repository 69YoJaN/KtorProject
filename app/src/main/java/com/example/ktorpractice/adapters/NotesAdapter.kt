package com.example.ktorpractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ktorpractice.R
import com.example.ktorpractice.model.Notes

class NotesAdapter(private var notes : List<Notes>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val noteId : TextView = itemView.findViewById(R.id.NoteId)
        val noteTitle : TextView = itemView.findViewById(R.id.noteTitle)
        val noteContent : TextView = itemView.findViewById(R.id.noteContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_view,parent,false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val notesList = notes[position]
        holder.noteId.text = notesList.id.toString()
        holder.noteTitle.text = notesList.title
        holder.noteContent.text = notesList.content
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Notes>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}