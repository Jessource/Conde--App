package br.com.fiap.myconde.layout.components

import android.icu.text.ListFormatter.Width
import android.view.Menu
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myconde.R
import br.com.fiap.myconde.model.Sindico
import br.com.fiap.myconde.navigation.AppDestination
import br.com.fiap.myconde.sampledata.sampleSindicoWithImage
import br.com.fiap.myconde.sampledata.sampleSindicoWithoutImage
import br.com.fiap.myconde.ui.theme.MyCondeTheme

@Composable
fun MenuSindicoCard(
    sindico: Sindico,
    modifier: Modifier = Modifier,
    onOrderClick: () -> Unit = {}
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
//            product.image?.let { image ->
//                AsyncImage(
//                    image,
//                    contentDescription = null,
//                    Modifier
//                        .fillMaxWidth()
//                        .height(116.dp),
//                    placeholder = painterResource(id = R.drawable.placeholder),
//                    contentScale = ContentScale.Crop,
//                )
//            }
            Row {
                Column(Modifier.height(70.dp)) {

                    Image(painter = painterResource(id = R.drawable.perfil), contentDescription ="Perfil" )



                }

                Column(
                    Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .padding(horizontal = 30.dp)
                ) {
                    Text(text = sindico.nome, fontSize = 20.sp)
                    Text(
                        text = sindico.resumo,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = sindico.cidade,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis
                    )



                }

            }
            Row {
                Column( Modifier.padding(1.dp).padding(bottom = 10.dp)) {
                    Text(text = sindico.classificacao, fontSize = 20.sp)

                }
                Column(modifier = Modifier.padding(1.dp).height(20.dp)) {
                    Image(painter = painterResource(id = R.drawable.estrela), contentDescription ="estrela" )
                }

            }



//            Text(text = sindico.classificacao)
//            Spacer(Modifier.height(16.dp))
//




        }
    }
}

@Preview
@Composable
private fun MenuSindicoPreview() {
    MyCondeTheme {
        MenuSindicoCard(
            sindico = sampleSindicoWithoutImage
        )
    }
}

@Preview
@Composable
private fun MenuSindicoCardWithImagePreview() {
    MyCondeTheme {
        MenuSindicoCard(
            sindico = sampleSindicoWithImage
        )
    }
}