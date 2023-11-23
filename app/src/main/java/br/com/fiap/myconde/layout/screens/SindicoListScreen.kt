package br.com.fiap.myconde.layout.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myconde.layout.components.CheckoutItemCard
import br.com.fiap.myconde.layout.components.SindicoCard
import br.com.fiap.myconde.model.Sindico
//import br.com.fiap.myconde.sampledata.sampleSindicos
import br.com.fiap.myconde.ui.theme.MyCondeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SindicoListScreen(
    modifier: Modifier = Modifier,
    title: String = "Sindicos",
    sindicos: List<Sindico> = emptyList(),
    columns: Int = 2,
    onNavigateToDetails: (Sindico) -> Unit = {}
) {
    Column(
        modifier
            .fillMaxSize()
    ) {
        Surface {
            Text(
                text = title,
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
//                fontFamily = caveatFont,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(columns),
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sindicos) { s ->
                SindicoCard(
                    sindico = s,
                    Modifier.clickable {
                        onNavigateToDetails(s)
                    }
                )
            }




        }
    }
}

//@Preview
//@Composable
//fun DrinksListScreenPreview() {
//    MyCondeTheme {
//        Surface {
//            SindicoListScreen(
//                sindicos = sampleSindicos,
//                title = "Sindicos"
//            )
//        }
//    }
//}