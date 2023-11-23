package br.com.fiap.myconde.model

import java.util.UUID
data class Estado (
    val uf: String
)
data class Cidade (
    val nome: String,
    val estado: Estado
)
data class Processo (
    val id: Long,
    val comentario: String
)
data class Profissional (
    val id: Long,
    val condominio: String,
    val duracao: String
)
data class Educacao (
    val id: Long,
    val curso: String,
    val instituicao: String,
    val duracao: String,
)
data class Contato (
    val linkedin: String,
    val instagram: String,
    val gmail: String,
    val telefone: String
)

data class Sindico (
    val id: Long,
    val nomeCompleto: String,
    val resumo: String,
    val classificacao: Float,
    val cidade: Cidade?,

    val profissional: List<Profissional>?,
    val educacao: List<Educacao>?,
    val contatos: Contato?,
    val processo: List<Processo>?,
    val avaliacao: List<Avaliacao>?
 )