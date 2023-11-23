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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.myconde.layout.components.MenuSindicoCard
import br.com.fiap.myconde.model.Sindico
import br.com.fiap.myconde.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuSindicoListScreen(
    onNavigateToDetails: (Sindico) -> Unit = {}
) {
    var listaSindicosState by remember { mutableStateOf(listOf<Sindico>()) }
    var isLoading by remember{ mutableStateOf(true) }
    var filter by remember { mutableStateOf("") }
    var executouChamada by remember { mutableStateOf(false)  }

    fun findSindico(nome: String?) {
        isLoading = true
        val call = RetrofitFactory().getSindicoService().getAllSindicos(nome);
        call.enqueue(object : Callback<List<Sindico>> {
            override fun onFailure(call: Call<List<Sindico>>, t: Throwable) {
                System.out.println("ERROR REQUEST: " + t.message)
            }
            override fun onResponse(call: Call<List<Sindico>>, response: Response<List<Sindico>>) {
                System.out.println("OnResponse")
                listaSindicosState = response.body()!!;
                isLoading = false
                executouChamada = true
            }
        })
    }

    if (!executouChamada) {
        findSindico(null)
    }


    Column(modifier = Modifier.padding(12.dp)) {
        OutlinedTextField(
            value = filter,
            onValueChange = {
                filter = it
                if (it == "") {
                    findSindico("")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            label ={
                Text(text = "Nome do Sindico ou Cidade")
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        findSindico(filter)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription =""
                    )
                }
            },
            singleLine = true,
        )
    }
    Spacer(modifier = Modifier.height(100.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(90.dp))
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (isLoading) {
                item() {
                    Column (
                        Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoadingIndicator(true)
                    }
                }
            } else {
                items(listaSindicosState) { s ->
                    MenuSindicoCard(
                        sindico = s,
                        Modifier.clickable {
                            onNavigateToDetails(s)
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingIndicator(isLoading: Boolean) {
    if (isLoading) {
        CircularProgressIndicator(
//            modifier = Modifier.fillMaxWidth()
        )
    }
}