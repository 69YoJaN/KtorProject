package com.example.ktorpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktorpractice.adapters.NotesAdapter
import com.example.ktorpractice.databinding.ActivityMainBinding
import com.example.ktorpractice.viewModel.NotesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : NotesViewModel
    private lateinit var notesAdapter : NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        setAdapter()
        getNotes()
        viewModel.getNotes()

        binding.refreshLayout.setOnRefreshListener {
            viewModel.getNotes()
            binding.refreshLayout.isRefreshing = false
        }

    }

    private fun getNotes() {
        viewModel.notes.observe(this) { notes ->
            if(notes.isNotEmpty()) {
                notesAdapter.setNotes(notes)
                binding.Loader.visibility = View.GONE
            }
        }
    }


    private fun setAdapter() {
        binding.notesRecyclerView.layoutManager = LinearLayoutManager(this)
        notesAdapter = NotesAdapter(emptyList())
        binding.notesRecyclerView.adapter = notesAdapter
    }
}