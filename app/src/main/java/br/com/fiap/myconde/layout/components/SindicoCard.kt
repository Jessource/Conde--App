package br.com.fiap.myconde.layout.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.myconde.model.Sindico
//import br.com.fiap.myconde.sampledata.sampleSindicoWithImage
//import br.com.fiap.myconde.sampledata.sampleSindicoWithoutImage
import br.com.fiap.myconde.ui.theme.MyCondeTheme

@Composable
fun SindicoCard(
    sindico: Sindico,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .width(158.dp)
            .heightIn(
                min = 100.dp
            ),
        shape = RoundedCornerShape(12.dp)
    ) {
//        product.image?.let { image ->
//            AsyncImage(
//                model = image,
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp),
//                contentScale = ContentScale.Crop
//            )
//        }
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
//            Text(
//                text = sindico.nome,
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
//            )

        }
    }
}

//@Preview
//@Composable
//private fun SindicoCardPreview() {
//    MyCondeTheme {
//        SindicoCard(
//            sindico = sampleSindicoWithoutImage
//        )
//    }
//}
//
//@Preview
//@Composable
//private fun SindicoCardWithImagePreview() {
//    MyCondeTheme {
//        SindicoCard(
//            sindico = sampleSindicoWithImage
//        )
//    }
//}