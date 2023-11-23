package br.com.fiap.myconde.layout.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myconde.R
import br.com.fiap.myconde.model.Avaliacao
import br.com.fiap.myconde.model.Sindico
//import br.com.fiap.myconde.sampledata.sampleAvaliacaoWithImage
//import br.com.fiap.myconde.sampledata.sampleAvaliacaoWithoutImage
//import br.com.fiap.myconde.sampledata.sampleSindicoWithImage
//import br.com.fiap.myconde.sampledata.sampleSindicoWithoutImage
import br.com.fiap.myconde.ui.theme.MyCondeTheme

@Composable
fun CardAvaliacao(
    avalicao: Avaliacao,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(width  = 1.dp, color = Color.Black)

    ) {
        Column(Modifier.fillMaxWidth()) {
            Row {
                Column(
                    Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .padding(horizontal = 30.dp)
                ) {
                    Text(text = avalicao.titulo, fontSize = 20.sp)
                    Text(
                        text = avalicao.comentario,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Row {
                Column( Modifier.padding(1.dp).padding(bottom = 10.dp)) {
                    Text(text = avalicao.classificacao, fontSize = 20.sp)

                }
                Column(modifier = Modifier.padding(1.dp).height(20.dp)) {
                    Image(painter = painterResource(id = R.drawable.estrela), contentDescription ="estrela" )
                }

            }
        }
    }
}

//@Preview
//@Composable
//private fun MenuAvaliacaoPreview() {
//    MyCondeTheme {
//        CardAvaliacao(
//            avalicao = sampleAvaliacaoWithoutImage
//        )
//    }
//}
//
//@Preview
//@Composable
//private fun MenuAvaliacaoCardWithImagePreview() {
//    MyCondeTheme {
//        CardAvaliacao(
//            avalicao = sampleAvaliacaoWithImage
//        )
//    }
//}