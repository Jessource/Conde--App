package br.com.fiap.myconde.model

import java.util.UUID

data class Sindico (
    val id: String = UUID.randomUUID().toString(),
    val nome: String,
    val resumo: String,
    val cidade: String,
    val classificacao: String,
    val historicoProfissional: String,
    val historicoeducacao: String,
    val contatos: String,
    val processos:String,
    val image: String? = null


 )