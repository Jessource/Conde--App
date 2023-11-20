package br.com.fiap.myconde.model

import java.util.UUID

data class Avaliacao (
    val id: String = UUID.randomUUID().toString(),
    val titulo: String,
    val comentario: String,
    val classificacao: String,

    )