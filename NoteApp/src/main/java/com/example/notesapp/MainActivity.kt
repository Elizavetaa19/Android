package com.example.notesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var notesAdapter: NotesAdapter? = null
    private var notesList: MutableList<Note>? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        notesList = ArrayList()

        // Добавим несколько заметок для тестирования
        notesList.add(Note("Заметка 1", "Содержимое заметки 1"))
        notesList.add(Note("Заметка 2", "Содержимое заметки 2"))
        notesList.add(Note("Заметка 3", "Содержимое заметки 3"))

        notesAdapter = NotesAdapter(notesList)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = notesAdapter
    }
}