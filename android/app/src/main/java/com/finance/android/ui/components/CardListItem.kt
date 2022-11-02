package com.finance.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.finance.android.R
import com.finance.android.ui.theme.Disabled

@Preview
@Composable
fun CardListItem() {
    PreviewCardListItem_Arrow()
}

@Composable
private fun Draw(
    modifier: Modifier,
    cardName: String,
    cardImgPath: String,
    trailing: (@Composable () -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(R.dimen.padding_small),
                bottom = dimensionResource(R.dimen.padding_small)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(cardImgPath)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = modifier
                .size(40.dp)
                .padding(end = dimensionResource(R.dimen.padding_small))
        )
        Text(text = cardName)
        Spacer(modifier = modifier.weight(1.0f))
        trailing?.invoke()
    }
}

@Composable
fun CardListItem_Arrow(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    cardName: String,
    cardImgPath: String,
    onClickItem: () -> Unit
) {
    Draw(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClickItem() }
            .padding(contentPadding),
        cardName = cardName,
        cardImgPath = cardImgPath,
        trailing = {
            Icon(
                painter = painterResource(R.drawable.arrow_forward_ios),
                contentDescription = "forwardArrow",
            )
        }
    )
}

@Composable
fun CardListItem_Check(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    cardName: String,
    cardImgPath: String,
    checked: Boolean,
    onClickItem: () -> Unit
) {
    Draw(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClickItem() }
            .padding(contentPadding),
        cardName = cardName,
        cardImgPath = cardImgPath,
        trailing = {
            Icon(
                Icons.Filled.CheckCircle,
                contentDescription = "check",
                tint = if (checked) MaterialTheme.colorScheme.primary else Disabled
            )
        }
    )
}

@Preview
@Composable
fun PreviewCardListItem_Arrow() {
    CardListItem_Arrow(
        cardName = "신한카드",
        cardImgPath = "https://www.shinhancard.com/pconts/company/images/contents/shc_symbol_ci.png",
        onClickItem = {}
    )
}

@Preview
@Composable
fun PreviewCardListItem_Check() {
    CardListItem_Check(
        cardName = "신한카드",
        cardImgPath = "https://www.shinhancard.com/pconts/company/images/contents/shc_symbol_ci.png",
        checked = true,
        onClickItem = {}
    )
}