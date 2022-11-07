package com.finance.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.finance.android.R
import java.text.DecimalFormat

@Composable
fun AccountCardComp(
    modifier: Modifier,
    acName: String, // 계좌 이름
    cpName: String, // 기업 이름
    acNo: String, // 계좌번호
    balance: Int, // 잔액
    onClickButton: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(18.dp)
    ) {
        Text(text = acName,
            color = MaterialTheme.colorScheme.surface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "$cpName $acNo",
            color = MaterialTheme.colorScheme.surface,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Row(
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.padding_medium),
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = DecimalFormat("#,###원").format(balance),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.surface
            )
            Spacer(modifier = Modifier.weight(1.0f))
            TextButton(
                onClick = { onClickButton() },
                text = "이체",
                buttonType = ButtonType.CIRCULAR,
                buttonColor = ButtonColor.WHITE
            )
        }
    }
}