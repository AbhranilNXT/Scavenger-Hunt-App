package `in`.iot.lab.dashboard.ui.screen.team.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import `in`.iot.lab.dashboard.R
import `in`.iot.lab.design.components.AppScreen
import `in`.iot.lab.design.components.AppTopBar


/**
 * This function is the custom scaffold used in the Team Screen of the dashboard.
 *
 * @param headerText This is the text that would be shown as the main title of the screen
 * @param onNavigateToTeamDetails This is the function that would be invoked if the user taps on the
 * next button.
 * @param point These are the points that are shown in the UI.
 * @param body This is the body composable which would be shown in the body of this scaffold
 */
@Composable
fun TeamScreenScaffoldUI(
    headerText: String,
    onNavigateToTeamDetails: () -> Unit,
    point: String,
    onNavigateToPlay: () -> Unit,
    body: @Composable BoxScope.() -> Unit
) {

    // Scaffold
    AppScreen(

        // Top App Bar UI
        topBar = {
            AppTopBar(
                headerText = headerText,
                onNextButtonClick = onNavigateToTeamDetails,
                pointDisplay = point
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 40.dp),
                onClick = onNavigateToPlay,
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(50)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_qr),
                    contentDescription = "Map Icon",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(32.dp),
                )
            }
        },
        contentAlignment = Alignment.TopCenter,
        body = body
    )
}