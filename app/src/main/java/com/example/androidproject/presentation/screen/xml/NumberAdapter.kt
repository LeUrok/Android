package com.example.androidproject.presentation.screen.xml

import android.view.View
import android.widget.TextView
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.data.model.NumberItem

class NumberAdapter(): RecyclerView.Adapter<NumberViewHolder>() {
    val items = ArrayList<NumberItem>()

    fun update(newItems: List<NumberItem>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumberViewHolder {
        return NumberViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_number, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: NumberViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class NumberViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val numberText = view.findViewById<TextView>(R.id.numberText)

    fun bind(number: NumberItem){
        numberText.text = number.id.toString()
        val bgColor = if (number.isEven) Color.RED else Color.BLUE
        numberText.setBackgroundColor(bgColor)
    }
}