package com.example.androidproject

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.screen.NumberViewModel
import com.example.androidproject.presentation.screen.xml.NumberAdapter
import kotlinx.coroutines.newSingleThreadContext
import kotlin.getValue

class NewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_content)

        val numId = intent.getIntExtra("num_id", -1)
        val isEven = intent.getBooleanExtra("num_is_even", false)

        val bgClr = if (isEven) Color.RED else Color.BLUE

        val numTextView = findViewById<TextView>(R.id.newTextContent)
        numTextView.text = numId.toString()
        numTextView.setBackgroundColor(bgClr)
    }
}