package com.example.androidproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.screen.xml.NumberAdapter
import com.example.androidproject.data.model.NumberItem

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var addButton: android.widget.Button
    private val adapter: NumberAdapter = NumberAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_number_list)

        recyclerView = findViewById(R.id.recyclerView)
        addButton = findViewById(R.id.addButton)

        setupRecyclerView()

        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            adapter.update(ArrayList<NumberItem>(adapter.items).apply {
                val newId = this.size
                this.add(NumberItem(newId, newId % 2 == 0))
            })
        }
    }

    private fun setupRecyclerView() {
        val spanCount = if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
            4
        } else {
            3
        }

        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
    }
}