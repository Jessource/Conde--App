package br.com.fiap.myconde.layout.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myconde.R
import br.com.fiap.myconde.layout.components.CardAvaliacao
import br.com.fiap.myconde.layout.components.MenuSindicoCard
import br.com.fiap.myconde.model.Avaliacao
import br.com.fiap.myconde.model.Sindico
import br.com.fiap.myconde.service.RetrofitFactory
//import br.com.fiap.myconde.sampledata.sampleAvaliacao
//import br.com.fiap.myconde.sampledata.sampleSindicos
import br.com.fiap.myconde.ui.theme.MyCondeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SindicoDetailsScreen(
    sindicoId: String?,
) {
    var id = sindicoId!!
    var sindicoState by remember { mutableStateOf(Sindico(
        id = 0, nomeCompleto = "", classificacao = 0.0f,
        cidade = null, contatos = null, educacao = null,
        profissional = null, processo = null, resumo = "", avaliacao = null)) }
    val call = RetrofitFactory().getSindicoService().getSindicoPorId(id);
    var isLoading by remember { mutableStateOf(true) }

    call.enqueue(object: Callback<Sindico> {
        override fun onResponse(call: Call<Sindico>, response: Response<Sindico>) {
            sindicoState = response.body()!!;
            isLoading = false
        }
        override fun onFailure(call: Call<Sindico>, t: Throwable) {
            System.out.println("Error no byId: ${t.message}")
        }
    })
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (isLoading) {
            Column (
                Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadingIndicator(true)
            }
        } else {
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
                    Text(sindicoState.nomeCompleto, fontSize = 24.sp)
                }
                Column(
                    Modifier
                        .padding(top = 90.dp)
                        .padding(horizontal = 5.dp)) {
                    Text(text = sindicoState.classificacao.toString(), fontSize = 20.sp)

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
                        .padding(top = 15.dp))
                {
                    sindicoState.cidade?.nome?.let { Text(it) }
                }
            }
            Spacer(Modifier.height(10.dp))
            LazyColumn (Modifier.padding(16.dp)) {
                item() {
                    Card(
                        Modifier
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
                                    Text(text = "Resumo", fontSize = 20.sp)
                                    Text(
                                        text = sindicoState.resumo,
                                        maxLines = 5,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Card(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(4.dp),
                        border = BorderStroke(width  = 1.dp, color = Color.Black)

                    ) {
                        Spacer(Modifier.height(10.dp))
                        Column(Modifier.fillMaxWidth()) {
                            Row {
                                Column(
                                    Modifier
                                        .padding(top = 10.dp, bottom = 10.dp)
                                        .padding(horizontal = 30.dp)
                                ) {
                                    Text(text = "Experiência", fontSize = 20.sp)
                                    sindicoState.profissional?.let {
                                        it.forEach {
                                                prof ->
                                            Text(
                                                text = prof.condominio + " " + prof.duracao,
                                                overflow = TextOverflow.Ellipsis,
                                                modifier = Modifier
                                                    .padding(bottom = 8.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Card(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(4.dp),
                        border = BorderStroke(width  = 1.dp, color = Color.Black)

                    ) {
                        Spacer(Modifier.height(10.dp))
                        Column(Modifier.fillMaxWidth()) {
                            Row {
                                Column(
                                    Modifier
                                        .padding(top = 10.dp, bottom = 10.dp)
                                        .padding(horizontal = 30.dp)
                                ) {
                                    Text(text = "Educação", fontSize = 20.sp)
                                    sindicoState.educacao?.let {
                                        it.forEach {
                                                educ ->
                                            Text(
                                                text = educ.curso + " - " + educ.instituicao + " " + educ.duracao,
                                                overflow = TextOverflow.Ellipsis,
                                                modifier = Modifier
                                                    .padding(bottom = 8.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Card(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(4.dp),
                        border = BorderStroke(width  = 1.dp, color = Color.Black)

                    ) {
                        Spacer(Modifier.height(10.dp))
                        Column(Modifier.fillMaxWidth()) {
                            Row {
                                Column(
                                    Modifier
                                        .padding(top = 10.dp, bottom = 10.dp)
                                        .padding(horizontal = 30.dp)
                                ) {
                                    Text(text = "Processos jurídicos", fontSize = 20.sp)
                                    sindicoState.processo?.let {
                                        it.forEach {
                                                proce ->
                                            Text(
                                                text = proce.comentario,
                                                overflow = TextOverflow.Ellipsis,
                                                modifier = Modifier
                                                    .padding(bottom = 8.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Card(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(4.dp),
                        border = BorderStroke(width  = 1.dp, color = Color.Black)

                    ) {
                        Spacer(Modifier.height(10.dp))
                        Column(Modifier.fillMaxWidth()) {
                            Row {
                                Column(
                                    Modifier
                                        .padding(top = 10.dp, bottom = 10.dp)
                                        .padding(horizontal = 30.dp)
                                ) {
                                    Text(text = "Redes e Contatos", fontSize = 20.sp)
                                    sindicoState.contatos?.linkedin?.let {
                                        Text(
                                            text = it,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier
                                                .padding(bottom = 8.dp)
                                        )
                                    }
                                    sindicoState.contatos?.gmail?.let {
                                        Text(
                                            text = it,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier
                                                .padding(bottom = 8.dp)
                                        )
                                    }
                                    sindicoState.contatos?.telefone?.let {
                                        Text(
                                            text = it,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier
                                                .padding(bottom = 8.dp)
                                        )
                                    }
                                    sindicoState.contatos?.instagram?.let {
                                        Text(
                                            text = it,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier
                                                .padding(bottom = 8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Avaliações",  fontSize = 20.sp)
                    Spacer(Modifier.height(10.dp))
                }

                sindicoState.avaliacao?.let {
                    items(it) { av ->
                        CardAvaliacao(
                            avalicao = Avaliacao(
                                classificacao = av.classificacao,
                                comentario = av.comentario,
                                titulo = av.titulo
                            ),
                            Modifier.clickable {}
                        )
                        Spacer(Modifier.height(10.dp))
                    }
                }

            }
        }
    }
}