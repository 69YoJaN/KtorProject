package com.example.ktorpractice.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorpractice.model.Notes
import com.example.ktorpractice.repository.Repository
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {
    private val repository = Repository()

    private val _notes = MutableLiveData<List<Notes>>()
    val notes : LiveData<List<Notes>> get() = _notes

    private val _addNote = MutableLiveData<Result<String>>()
    val valNote : LiveData<Result<String>> get() = _addNote


    fun addNote(note: Notes) {
        viewModelScope.launch {
            _addNote.value = repository.addNote(note)
        }
    }

    fun getNotes() {
        viewModelScope.launch {
            try {
                _notes.value = repository.getNotes()
            } catch (e:Exception) {
                Log.e("getNotes","$e")
            }
        }
    }
}