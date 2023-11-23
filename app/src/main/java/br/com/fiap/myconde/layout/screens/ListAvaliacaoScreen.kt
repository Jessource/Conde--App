package br.com.fiap.myconde.layout.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.myconde.layout.components.CardAvaliacao
import br.com.fiap.myconde.model.Avaliacao
//import br.com.fiap.myconde.sampledata.sampleAvaliacao
import br.com.fiap.myconde.ui.theme.MyCondeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvaliacaoListScreen(
    modifier: Modifier = Modifier,
    avaliacoes: List<Avaliacao> = emptyList(),
    onNavigateToCheckout: () -> Unit = {},
    onNavigateToDetails: (Avaliacao) -> Unit = {}
) {

    Spacer(modifier = Modifier.height(100.dp))
    Column(
        modifier
            .fillMaxSize()

    ) {
//
        Spacer(modifier = Modifier.height(90.dp))
        LazyColumn(
            modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(avaliacoes) { a ->
                CardAvaliacao(
                    avalicao = a,
                    Modifier.clickable {
                            onNavigateToDetails(a)
                    }
                )
            }
        }
    }

}
//@Preview
//@Composable
//fun MenuAvaliacaoListScreenPreview() {
//    MyCondeTheme {
//       Surface {
//           AvaliacaoListScreen(
//               avaliacoes = sampleAvaliacao
//
//           )
//       }
//    }
//}
