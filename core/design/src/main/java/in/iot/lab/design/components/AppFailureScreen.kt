package `in`.iot.lab.design.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import `in`.iot.lab.design.R
import `in`.iot.lab.design.theme.ScavengerHuntTheme


// Default Preview Function
@Preview(
    "Light",
    showBackground = true
)
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ScavengerHuntTheme {
        AppScreen {
            ErrorDialog(
                onCancel = {},
                onTryAgain = {}
            )
        }
    }
}


/**
 * This composable function is used to show the Error Screen to the User when there is a Internet
 * Issues or error during the Backend API Calls
 *
 *
 * @param modifier This is to pass modifications from the Parent Composable to the Child
 * @param title This is the Heading of the issue/error which would be shown as a Heading below
 * the Image
 * @param text This is the description of the Issue/Error which would be shown as a
 * description below the [title]
 * @param imageId This is the Image Id which would be shown in the Dialog
 * @param onTryAgain This function would be executed when the retry button would be clicked
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorDialog(
    modifier: Modifier = Modifier,
    title: String = "Whoops !!",
    text: String = "No Internet connection was found. Check your connection or try again.",
    imageId: Int = R.drawable.error_image,
    onCancel: () -> Unit,
    onTryAgain: () -> Unit
) {

    // This variable says if the dialog is Visible or not
    var isDialogVisible by remember { mutableStateOf(true) }

    // We are animating the entry and Exit of the Dialog Bars
    AnimatedVisibility(isDialogVisible) {
        AlertDialog(
            onDismissRequest = {
                isDialogVisible = false
                onCancel()
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            OutlinedCard(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.outlinedCardColors(
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                border = BorderStroke(
                    width = 2.5.dp,
                    color = MaterialTheme.colorScheme.primary
                )
            ) {
                // Dialog Contents which would be shown inside the Dialog
                DialogContent(
                    modifier = modifier,
                    imageId = imageId,
                    title = title,
                    text = text,
                    onTryAgain = onTryAgain
                ) {
                    isDialogVisible = false
                    onCancel()
                }
            }

        }
    }
}


/**
 * This function provides the Contents inside the [ErrorDialog] Composable
 *
 * @param modifier This is for the parent function to pass modifications to the child
 * @param title This is the Heading of the issue/error which would be shown as a Heading below
 * the Image
 * @param text This is the description of the Issue/Error which would be shown as a
 * description below the [title]
 * @param imageId This is the Image Id which would be shown in the Dialog
 * @param onTryAgain This function would be executed when the retry button would be clicked
 * @param onDismiss This function would be called when the user hits the dismiss Button and it would
 * remove the Dialog from the Screen
 */
@Composable
private fun DialogContent(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    @DrawableRes imageId: Int,
    onTryAgain: () -> Unit,
    onDismiss: () -> Unit
) {

    Column(
        modifier = modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Local Image
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 64.dp)
                .height(180.dp)
                .fillMaxWidth()
        )


        // Issues Heading Text
        Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )


        // Issues Description Text
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
        )


        // Row containing Cancel and Try Again Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Cancel Button
            SecondaryButton(
                onClick = onDismiss,
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = "Cancel",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }


            PrimaryButton(
                onClick = onTryAgain,
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = "Try Again",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}