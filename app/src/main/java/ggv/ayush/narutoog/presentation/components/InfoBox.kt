package ggv.ayush.narutoog.presentation.components


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ggv.ayush.narutoog.R
import ggv.ayush.narutoog.ui.theme.INFO_ICON_SIZE
import ggv.ayush.narutoog.ui.theme.SMALL_PADDING
import ggv.ayush.narutoog.ui.theme.titleColor


@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = icon,
            modifier = Modifier
                .padding(end = SMALL_PADDING)
                .size(INFO_ICON_SIZE),
            contentDescription = null,
            tint = iconColor,
        )
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = bigText,
                color = textColor,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = smallText,
                color = textColor,
                fontSize = MaterialTheme.typography.overline.fontSize,
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun InfoBoxPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.bolt),
        iconColor = MaterialTheme.colors.primary,
        bigText = "92",
        smallText = "Power",
        textColor = MaterialTheme.colors.titleColor
    )
}
@Preview( uiMode = UI_MODE_NIGHT_YES)
@Composable
fun InfoBoxDarkPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.bolt),
        iconColor = MaterialTheme.colors.primary,
        bigText = "92",
        smallText = "Power",
        textColor = MaterialTheme.colors.titleColor
    )
}