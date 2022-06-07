package com.example.ktorwithjetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ktorwithjetpack.model.Data
import com.example.ktorwithjetpack.ui.theme.Purple200
import com.example.ktorwithjetpack.ui.theme.Purple500
import com.example.ktorwithjetpack.viewmodel.KtorViewModel

@Composable
fun KtorScreen() {
    val viewModel: KtorViewModel = viewModel()
    val productData = viewModel.productFlow.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple500)
                .padding(15.dp)
        ) {
            Text(
                text = "Ktor Client",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Column {
            productData.value?.let {
                LazyColumn {
                    item {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Total Count: ${it.per_page}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    items(it.data.size) { index ->
                        ProductItem(data = it.data[index])
                    }
                }
            }
        }
    }
}

@Composable
fun ProductItem(
    data: Data
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp, 10.dp, 5.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(android.graphics.Color.parseColor(data.color)))
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Name: ${data.name}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Name: ${data.id}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Name: ${data.year}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}