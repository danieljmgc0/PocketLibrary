package com.knighttech.pocketlibrary.android.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.knighttech.pocketlibrary.android.model.SampleData

@Composable
fun BookListScreen() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(SampleData.books) { book ->
            Card(elevation = 4.dp, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(12.dp)) {
                    Text("ISBN: ${book.isbn}")
                    Spacer(Modifier.height(4.dp))
                    Text("Título: ${book.title}")
                    Spacer(Modifier.height(4.dp))
                    Text("Autor: ${book.author}")
                }
            }
        }
    }
}
