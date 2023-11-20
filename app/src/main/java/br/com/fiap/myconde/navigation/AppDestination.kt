package br.com.fiap.myconde.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import br.com.fiap.myconde.layout.components.BottomAppBarItem

sealed class AppDestination(val route: String) {
    object Highlight : AppDestination("highlight")
    object Menu : AppDestination("menu")
    object Avaliacoes : AppDestination("avaliacoes")
    object SindicoDetails : AppDestination("sindicotDetails")
    object Checkout : AppDestination("checkout")
}

val bottomAppBarItems = listOf(
    BottomAppBarItem(
        label = "Menu",
        icon = Icons.Filled.Home,
        destination = AppDestination.Highlight
    ),


)