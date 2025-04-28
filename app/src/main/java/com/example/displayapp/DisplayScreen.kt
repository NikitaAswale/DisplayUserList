package com.example.displayapp

import android.view.Display
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.ai.client.generativeai.type.content

@Composable
fun DisplayScreen() {
    val viewModel: MainViewModel = viewModel()
    val viewState = viewModel.postState.value
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text("ERROR OCCURRED")
            }

            else -> {
                //Display Categories
                DisplayList(categories = viewState.list)

            }
        }
    }
}
@Composable
fun DisplayList(categories: List<DataClassPost>) {
    Column (
            modifier = Modifier
                .fillMaxSize(),// Make the Column take up all available screen space vertically
    //.padding(8.dp)// Optional padding around the Column
    verticalArrangement = Arrangement.Center // Optional space between rows
    ) {
        Row(
            Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Title",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta
            )
        }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f).padding(8.dp),// Assign weight 1 (same as Row 1)
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                LazyColumn  {
                    content {
                        itemsIndexed(categories, itemContent = { index, item ->
                            DisplayItem(
                                item = categories[index]
                            )
                        }
                        )
                    }
                }
            }
        }
    }

@Composable
fun DisplayItem(item : DataClassPost){
    Row {
        Text(
            text = "Body = ",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        )

        Text(
            text = item.body,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        )

    }
    Spacer(modifier = Modifier.height(8.dp))
}