package br.com.fiap.myconde

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.fiap.myconde.layout.components.BottomAppBarItem
import br.com.fiap.myconde.layout.components.CondeBottomAppBar
import br.com.fiap.myconde.layout.screens.CheckoutScreen

import br.com.fiap.myconde.layout.screens.MenuListScreen
import br.com.fiap.myconde.layout.screens.MenuSindicoListScreen
import br.com.fiap.myconde.layout.screens.SindicoDetailsScreen
import br.com.fiap.myconde.layout.screens.SindicoListScreen
import br.com.fiap.myconde.navigation.AppDestination
import br.com.fiap.myconde.navigation.bottomAppBarItems
import br.com.fiap.myconde.sampledata.sampleSindicos
import br.com.fiap.myconde.ui.theme.MyCondeTheme
import kotlinx.coroutines.flow.map

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LaunchedEffect(Unit) {
                navController.addOnDestinationChangedListener { _, _, _ ->
                    val routes = navController.currentBackStackEntryFlow.map {
                        it.destination.route
                    }
                    Log.i("MainActivity", "onCreate: back stack - $routes")
                }
            }
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination
            MyCondeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val selectedItem by remember(currentDestination) {
                        val item = currentDestination?.let { destination ->
                            bottomAppBarItems.find {
                                it.destination.route == destination.route
                            }
                        } ?: bottomAppBarItems.first()
                        mutableStateOf(item)
                    }
                    val containsInBottomAppBarItems = currentDestination?.let { destination ->
                        bottomAppBarItems.find {
                            it.destination.route == destination.route
                        }
                    } != null
                    val isShowFab = when (currentDestination?.route) {
                        AppDestination.Menu.route,
                        AppDestination.Avaliacoes.route -> true
                        else -> false
                    }
                    CondeApp(
                        bottomAppBarItemSelected = selectedItem,
                        onBottomAppBarItemSelectedChange = {
                            val route = it.destination.route
                            navController.navigate(route) {
                                launchSingleTop = true
                                popUpToRoute

                            }
                        },
                        onFabClick = {
                            navController.navigate(AppDestination.Checkout.route)
                        },
                        isShowTopBar = containsInBottomAppBarItems,
                        isShowBottomBar = containsInBottomAppBarItems,
                        isShowFab = isShowFab
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = AppDestination.Highlight.route
                        ) {
                            composable(AppDestination.Highlight.route) {
                                MenuSindicoListScreen(
                                    sindicos = sampleSindicos,
                                    onNavigateToDetails = { sindico ->
                                        navController.navigate(
                                            "${AppDestination.SindicoDetails.route}/${sindico.id}"
                                        )
                                    },
                                    onNavigateToCheckout = {
                                        navController.navigate(AppDestination.Checkout.route)
                                    },
                                )
                            }
                            composable(AppDestination.Menu.route) {
                                MenuListScreen(
                                    sindicos = sampleSindicos,
                                    onNavigateToDetails = { sindico ->
                                        navController.navigate(
                                            "${AppDestination.SindicoDetails.route}/${sindico.id}"
                                        )
                                    },
                                )
                            }
                            composable(AppDestination.Avaliacoes.route) {
                                SindicoListScreen(
                                    sindicos = sampleSindicos,
                                    onNavigateToDetails = { sindico ->
                                        navController.navigate(
                                            "${AppDestination.SindicoDetails.route}/${sindico.id}"
                                        )
                                    },
                                )
                            }
                            composable(
                                "${AppDestination.SindicoDetails.route}/{sindicoId}"
                            ) { backStackEntry ->
                                val id = backStackEntry.arguments?.getString("sindicoId")
                                sampleSindicos.find {
                                    it.id == id
                                }?.let { sindico ->
                                    SindicoDetailsScreen(
                                        sindico = sindico,
                                        onNavigateToCheckout = {
                                            navController.navigate(AppDestination.Checkout.route)
                                        },
                                    )
                                } ?: LaunchedEffect(Unit) {
                                    navController.navigateUp()
                                }
                            }
                            composable(AppDestination.Checkout.route) {
                                CheckoutScreen(
                                    sindicos = sampleSindicos,
                                    onPopBackStack = {
                                        navController.navigateUp()
                                    },
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CondeApp(
    bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    onFabClick: () -> Unit = {},
    isShowTopBar: Boolean = false,
    isShowBottomBar: Boolean = false,
    isShowFab: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (isShowTopBar) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Conde App")
                    },
                )
            }
        },
        bottomBar = {
            if (isShowBottomBar) {
                CondeBottomAppBar(
                    item = bottomAppBarItemSelected,
                    items = bottomAppBarItems,
                    onItemChange = onBottomAppBarItemSelectedChange,
                )
            }
        },
        floatingActionButton = {
            if (isShowFab) {
                FloatingActionButton(
                    onClick = onFabClick
                ) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun CondeAppPreview() {
    MyCondeTheme {
        Surface {
            CondeApp {}
        }
    }
}