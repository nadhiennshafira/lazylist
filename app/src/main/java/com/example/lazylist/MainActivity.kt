package com.example.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyListApp()
                }
            }
        }
    }
}

data class Benang(
    val nama: String,
    val deskripsi: String,
    val gambar: Int
)

@Composable
fun LazyListApp() {
    val daftarBenang = listOf(
        Benang(
            "Benang Alpaca",
            "Benang berbahan serat alpaca yang lembut, hangat, dan ringan.",
            R.drawable.alpaca
        ),
        Benang(
            "Benang Chenile",
            "Benang bertekstur lembut dan berbulu, cocok untuk boneka dan kerajinan.",
            R.drawable.chenile
        ),
        Benang(
            "Benang Cotton",
            "Benang berbahan katun yang nyaman dan cocok untuk berbagai kerajinan.",
            R.drawable.cotton
        ),
        Benang(
            "Benang Mohair",
            "Benang dari serat kambing angora yang ringan, halus, dan berbulu.",
            R.drawable.mohair
        ),
        Benang(
            "Benang Towel",
            "Benang bertekstur seperti handuk yang cocok untuk berbagai kreasi rajut.",
            R.drawable.towel
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "NIM: 245150401111041",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Nama: Nadhien Shafira",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Daftar Jenis Benang",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(daftarBenang) { benang ->
                BenangCard(benang)
            }
        }
    }
}

@Composable
fun BenangCard(benang: Benang) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = benang.gambar),
                contentDescription = benang.nama,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = benang.nama,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = benang.deskripsi,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}