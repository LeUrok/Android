package com.example.androidproject.presentation.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidproject.data.model.NumberItem

@Composable
fun CardWithNumber(
    number: NumberItem,
    modifier: Modifier
){
    val bgColor = if (number.isEven)
            Color.Red
        else
            Color.Blue

    Box(
        modifier = modifier
            .background(bgColor),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = number.id.toString(),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NumberCardPreview() {
    CardWithNumber(
        number = NumberItem(id = 1, isEven = true),
        modifier = Modifier.size(100.dp)
    )

}