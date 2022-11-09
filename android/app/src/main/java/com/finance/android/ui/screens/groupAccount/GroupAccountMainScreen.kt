package com.finance.android.ui.screens.groupAccount


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.finance.android.R
import com.finance.android.ui.components.AnimatedLoading
import com.finance.android.ui.components.ButtonType
import com.finance.android.ui.components.GroupAccountListItem
import com.finance.android.utils.Const
import com.finance.android.utils.Response
import com.finance.android.utils.ext.withBottomButton
import com.finance.android.viewmodels.GroupAccountViewModel

@Composable
fun GroupAccountMainScreen(
    navController: NavController,
    groupAccountViewModel: GroupAccountViewModel
) {
    fun launch() {
        groupAccountViewModel.getGroupAccountData()
    }

    LaunchedEffect(Unit) {
        launch()
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_medium))
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10)
            )
            .padding(dimensionResource(R.dimen.padding_medium))
            .defaultMinSize(minHeight = 100.dp)
            .verticalScroll(rememberScrollState())
    ) {
        when (val response = groupAccountViewModel.groupAccountData.value) {
            is Response.Failure -> Text(text = "실패")
            is Response.Loading -> AnimatedLoading()
            is Response.Success -> {
                response.data.forEach {
                    GroupAccountListItem(paName = it.paName, amount = it.amount)
                }
            }
        }


    }

    com.finance.android.ui.components.TextButton(
        onClick = { navController.navigate(Const.GROUP_ACCOUNT_MAKE_SCREEN) },
        modifier = Modifier.withBottomButton().padding(end = 5.dp),
        text = "모임 통장 만들러 가기",
        buttonType = ButtonType.ROUNDED
    )


}