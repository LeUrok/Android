package com.example.androidproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.data.model.NumberItem
import com.example.androidproject.presentation.screen.xml.NumberAdapter
import com.example.androidproject.presentation.screen.NumberViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var button: android.widget.Button
//    lateinit var button: FloatingActionButton
    private val adapter: NumberAdapter = NumberAdapter()
    private val viewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_number_list)

        recyclerView = findViewById(R.id.recyclerView)
        button = findViewById(R.id.button)

        setupRecyclerView()

        adapter.update(ArrayList(viewModel.numbers))

        recyclerView.adapter = adapter

        button.setOnClickListener {
            viewModel.addNumberItem()
            adapter.update(ArrayList(viewModel.numbers))
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