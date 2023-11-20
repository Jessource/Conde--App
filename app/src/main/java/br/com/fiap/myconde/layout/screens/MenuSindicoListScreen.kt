package br.com.fiap.myconde.layout.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.myconde.layout.components.MenuSindicoCard

import br.com.fiap.myconde.model.Sindico
import br.com.fiap.myconde.sampledata.sampleSindicos
import br.com.fiap.myconde.ui.theme.MyCondeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuSindicoListScreen(
    modifier: Modifier = Modifier,
    title: String = "Sindicos",
    sindicos: List<Sindico> = emptyList(),
    onNavigateToCheckout: () -> Unit = {},
    onNavigateToDetails: (Sindico) -> Unit = {}
) {
    Column(modifier = Modifier.padding(12.dp)) {
        OutlinedTextField(
            value = "",
            onValueChange ={},
            modifier = Modifier.fillMaxWidth(),
            label ={
                Text(text = "Nome do Sindico ou Cidade")
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription =""
                    )

                }
            }


            )
    }
    Spacer(modifier = Modifier.height(100.dp))
    Column(
        modifier
            .fillMaxSize()
    ) {
//        Surface {
//            Text(
//                text = title,
//                Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp),
////                fontFamily = caveatFont,
//                fontSize = 25.sp,
//                textAlign = TextAlign.Center
//            )
//        }
        Spacer(modifier = Modifier.height(90.dp))
        LazyColumn(
            modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sindicos) { s ->
                MenuSindicoCard(
                    sindico = s,
                    Modifier.clickable {
                        onNavigateToDetails(s)
                    },
                    onOrderClick = onNavigateToCheckout
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuSindicoListScreenPreview() {
    MyCondeTheme {
        Surface {
            MenuSindicoListScreen(
                sindicos = sampleSindicos,
                title = "Destaques do dia"
            )
        }
    }
}