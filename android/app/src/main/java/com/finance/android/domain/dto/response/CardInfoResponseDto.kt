package com.finance.android.domain.dto.response

import com.google.gson.annotations.SerializedName

data class CardInfoResponseDto(
    @SerializedName("cd_img") // 카드 이미지
    val cardImgPath: String,
    @SerializedName("cd_name") // 카드 이름
    val cardName: String,
    @SerializedName("cd_reg") // 카드 앱에 등록 여부
    val cardReg: Boolean,
    @SerializedName("cd_no")
    val cardNumber: String
)
