package br.com.fiap.myconde.layout.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myconde.R
import br.com.fiap.myconde.layout.components.CardAvaliacao
import br.com.fiap.myconde.layout.components.MenuSindicoCard
import br.com.fiap.myconde.model.Avaliacao
import br.com.fiap.myconde.model.Sindico
import br.com.fiap.myconde.sampledata.sampleAvaliacao
import br.com.fiap.myconde.sampledata.sampleSindicos
import br.com.fiap.myconde.ui.theme.MyCondeTheme

@Composable
fun SindicoDetailsScreen(
    sindico: Sindico,
    avaliacoes: List<Avaliacao> = emptyList(),
    modifier: Modifier = Modifier,
    onNavigateToCheckout: () -> Unit = {}
) {

    Column(
        modifier
            .fillMaxWidth()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .height(500.dp)
    ) {
//        product.image?.let {
//            AsyncImage(
//                model = product.image,
//                contentDescription = null,
//                modifier = Modifier
//                    .height(200.dp)
//                    .fillMaxWidth(),
//                placeholder = painterResource(id = R.drawable.placeholder),
//                contentScale = ContentScale.Crop
//            )

       Row {
           Column(
               Modifier
                   .padding(top = 50.dp)
                   .size(90.dp)) {

               Image(painter = painterResource(id = R.drawable.perfil), contentDescription ="Perfil" )


           }
           Column(
               Modifier
                   .padding(top = 90.dp))

           {
               Text(sindico.nome, fontSize = 24.sp)


           }
           Column(
               Modifier
                   .padding(top = 90.dp)
                   .padding(horizontal = 5.dp)) {
               Text(text = sindico.classificacao, fontSize = 20.sp)

           }
           Column(modifier = Modifier
               .padding(top = 90.dp)
               .size(20.dp)) {
               Image(painter = painterResource(id = R.drawable.estrela), contentDescription ="estrela" )
           }
       }
        Row {
            Column(
                Modifier
                    .padding(horizontal = 50.dp)
                    .padding(top = 15.dp)) {
                Text(sindico.cidade)


            }
            Column {
                Button(
                    onClick = { onNavigateToCheckout() },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "Adicionar Avaliação")
                }
            }


        }
        Spacer(Modifier.height(10.dp))

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


                    Column(
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(text = "Resumo", fontSize = 20.sp)
                        Text(
                            text = sindico.resumo,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )




                    }

                }


            }
        }
        Spacer(Modifier.height(10.dp))

        Card(
            modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(width  = 1.dp, color = Color.Black)

        ) {
            Spacer(Modifier.height(10.dp))
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


                    Column(
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(text = "Experiência", fontSize = 20.sp)
                        Text(
                            text = sindico.historicoProfissional,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )




                    }

                }


            }
        }
        Spacer(Modifier.height(10.dp))

        Card(
            modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(width  = 1.dp, color = Color.Black)

        ) {
            Spacer(Modifier.height(10.dp))
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


                    Column(
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(text = "Educação", fontSize = 20.sp)
                        Text(
                            text = sindico.historicoeducacao,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )




                    }

                }


            }
        }
        Spacer(Modifier.height(10.dp))

        Card(
            modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(width  = 1.dp, color = Color.Black)

        ) {
            Spacer(Modifier.height(10.dp))
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


                    Column(
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(text = "Processos jurídicos", fontSize = 20.sp)
                        Text(
                            text = sindico.processos,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )




                    }

                }


            }
        }
        Spacer(Modifier.height(10.dp))

        Card(
            modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(width  = 1.dp, color = Color.Black)

        ) {
            Spacer(Modifier.height(10.dp))
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


                    Column(
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(text = "Redes e Contatos", fontSize = 20.sp)
                        Text(
                            text = sindico.contatos,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )




                    }

                }


            }
        }
        Spacer(Modifier.height(10.dp))
        Column {
            Text(text = "Avaliações", fontSize = 24.sp)


        }
        Column {
            Text(text = "Avaliações", fontSize = 24.sp)
            MenuAvaliacaoListScreenPreview()

        }





    }


}








@Preview
@Composable
fun SindicoDetailsScreenPreview() {
    MyCondeTheme {
        Surface {
            SindicoDetailsScreen(
                sindico = sampleSindicos.random()

            )


        }

    }
}