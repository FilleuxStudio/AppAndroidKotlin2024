package com.filleuxstudio.myapplicationkotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filleuxstudio.myapplicationkotlin.screen.ListScreen
import com.filleuxstudio.myapplicationkotlin.screen.MainScreen
import com.filleuxstudio.myapplicationkotlin.screen.OpenF1Screen
import com.filleuxstudio.myapplicationkotlin.screen.QuoteScreen


object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
    const val QUOTE_SCREEN = "quote_screen"
    const val OPENF_SCREEN = "openf1_screen"
}


fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit,
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            },
            onButton2Click = {
                onButton2Click()
            },
            onButton3Click = {
                onButton3Click()
            }
        )
    }
}


fun NavGraphBuilder.addListScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.LIST_SCREEN,
    ) {
        ListScreen(navController)
    }
}

fun NavGraphBuilder.addQuoteScreenNavigation() {
    composable(
        route = NavigationPath.QUOTE_SCREEN,
    ) {
        QuoteScreen()
    }
}

fun NavGraphBuilder.addOpenF1ScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.OPENF_SCREEN,
    ) {
        OpenF1Screen(navController)
    }
}


@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNav(
            onButtonClick = {
                navController.navigate(NavigationPath.LIST_SCREEN)
            },
            onButton2Click = { navController.navigate(NavigationPath.QUOTE_SCREEN) },
            onButton3Click = { navController.navigate(NavigationPath.OPENF_SCREEN) }
        )
        addListScreenNavigation(navController = navController)
        addQuoteScreenNavigation()
        addOpenF1ScreenNavigation(navController = navController)
    }
}

