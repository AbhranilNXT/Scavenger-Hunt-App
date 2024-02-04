package `in`.iot.lab.dashboard.ui.navigation

import androidx.annotation.DrawableRes
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import `in`.iot.lab.dashboard.R
import `in`.iot.lab.dashboard.ui.screen.DashboardScreen

const val DASHBOARD_ROOT = "dashboard_route"

sealed class DashboardRoutes(val route: String, @DrawableRes val icon: Int) {
    object Team : DashboardRoutes("team_route", R.drawable.team)
    object Play : DashboardRoutes("play_route", R.drawable.home)
    object Leaderboard : DashboardRoutes("leaderboard_route", R.drawable.leaderboard)
}

fun NavController.navigateToDashboard(navOptions: NavOptions) = navigate(DASHBOARD_ROOT, navOptions)

fun NavGraphBuilder.dashboardScreen() {
    composable(DASHBOARD_ROOT) {
        DashboardScreen()
    }
}