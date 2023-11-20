package br.com.fiap.myconde.layout.screens

import android.content.ClipData.Item
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myconde.layout.components.CheckoutItemCard
import br.com.fiap.myconde.model.Sindico
import br.com.fiap.myconde.sampledata.sampleSindicos
import br.com.fiap.myconde.ui.theme.MyCondeTheme

@Composable
fun CheckoutScreen(
    modifier: Modifier = Modifier,
    sindicos: List<Sindico> = emptyList(),
    onPopBackStack: () -> Unit = {}
) {
    Box(
        modifier.fillMaxSize()
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 100.dp
            )
        ) {
            item {
                Text(
                    text = "Sindico",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(500)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(sindicos) { s ->
                CheckoutItemCard(sindico = s)
                Spacer(Modifier.height(16.dp))
            }
            item {
                Column {
                    Text(
                        text = "Pagamento",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(500)
                    )
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            Modifier.padding(vertical = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "VISA",
                                Modifier
                                    .background(
                                        MaterialTheme.colorScheme.primaryContainer,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(4.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(text = "VISA Classic")
                                Text(text = "****-0976")
                            }
                        }
                        Icon(
                            Icons.Outlined.AccountBox,
                            contentDescription = null
                        )
                    }
                }
            }
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Confirmar",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(500)
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Pedido")
                            Text(text = "9.0")
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Serviço (10%)")
                            Text(text = "9.0")
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Total")
                            Text(text = "9.0")
                        }
                    }
                }
            }
        }
        Button(
            onClick = { onPopBackStack() },
            Modifier
                .padding(
                    16.dp
                )
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                Icons.Outlined.Add,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Pedir",
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun CheckoutScreenPreview() {
    MyCondeTheme {
        Surface {
            CheckoutScreen(
                sindicos = sampleSindicos
            )
        }
    }
}

@Preview
@Composable
fun CheckoutScreenWithoutSindicosPreview() {
    MyCondeTheme{
        Surface {
            CheckoutScreen()
        }
    }
}