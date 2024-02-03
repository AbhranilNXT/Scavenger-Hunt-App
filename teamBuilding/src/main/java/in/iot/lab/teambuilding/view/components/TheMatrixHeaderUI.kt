package `in`.iot.lab.teambuilding.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import `in`.iot.lab.teambuilding.R

/**
 * This function is the Header UI which would contain the App name
 */
@Composable
fun TheMatrixHeaderUI() {

    // Scavenger Hunt Text Image
    Image(
        painter = painterResource(id = R.drawable.matrix),
        contentDescription = "Matrix text"
    )

    // Divider Red Line
    Divider(
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth(),
        thickness = 3.dp,
        color = Color(0xFFCC2936)
    )

    // Scavenger Hunt Text Image
    Image(
        painter = painterResource(id = R.drawable.scavenger_hunt),
        contentDescription = "Scavenger Hunt text",
    )
}