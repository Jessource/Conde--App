package br.com.fiap.myconde.layout.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown

import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.myconde.R
import br.com.fiap.myconde.model.Sindico
//import br.com.fiap.myconde.sampledata.sampleSindicoWithImage
//import br.com.fiap.myconde.sampledata.sampleSindicoWithoutImage
//import br.com.fiap.myconde.sampledata.sampleSindicos
import br.com.fiap.myconde.ui.theme.CheckoutCircleButton
import br.com.fiap.myconde.ui.theme.MyCondeTheme


@Composable
fun CheckoutItemCard(
    sindico: Sindico,
    modifier: Modifier = Modifier
) {
//    Card(
//        modifier
//            .height(80.dp),
//        shape = RoundedCornerShape(12.dp)
//    ) {
//        Row(
//            Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//        ) {
//            Row(
//                Modifier
//                    .weight(9f)
//                    .fillMaxHeight()
//            ) {
////                sindico.image?.let { image ->
////                    AsyncImage(
////                        model = image,
////                        contentDescription = null,
////                        Modifier.width(80.dp),
////                        placeholder = painterResource(
////                            id = R.drawable.placeholder
////                        ),
////                        contentScale = ContentScale.Crop
////                    )
////                }
//                Column(
//                    Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth()
//                ) {
//                    Text(
//                        text = sindico.nome,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = sindico.cidade,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                    Text(
//                        text = sindico.classificacao,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                    Text(
//                        text = sindico.resumo,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                }
//            }
//            Column(
//                Modifier
//                    .weight(1f)
//                    .fillMaxHeight(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                var quantity by remember {
//                    mutableStateOf(1)
//                }
//                val circleButtonModifier = Modifier
//                    .size(20.dp)
//                    .background(
//                        CheckoutCircleButton,
//                        shape = CircleShape
//                    )
//                    .clip(CircleShape)
//                Box(
//                    circleButtonModifier
//                        .clickable { quantity++ }
//                ) {
//                    Icon(
//                        Icons.Filled.KeyboardArrowUp,
//                        contentDescription = null
//                    )
//                }
//                Text(text = "$quantity")
//                Box(
//                    circleButtonModifier
//                        .clickable {
//                            if (quantity > 1) {
//                                quantity--
//                            }
//                        }
//                ) {
//                    Icon(
//                        Icons.Filled.ArrowDropDown,
//                        contentDescription = null
//                    )
//                }
//            }
//        }
//    }
}

//@Preview
//@Composable
//private fun CheckoutItemCardPreview() {
//    MyCondeTheme {
//        CheckoutItemCard(
//           sindico = sampleSindicoWithoutImage
//        )
//    }
//}
//
//@Preview
//@Composable
//private fun CheckoutItemCardWithImagePreview() {
//    MyCondeTheme {
//        CheckoutItemCard(
//            sindico = sampleSindicoWithImage
//        )
//    }
//}
