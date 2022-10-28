package com.finance.backend.bank.response

import com.fasterxml.jackson.annotation.JsonProperty

class BankAccountRes(
        acNo : String,
        balance : Int,
        acName : String,
        cpName: String,
        cpLogo: String

) {

        @JsonProperty("ac_no")
        val acNo: String = acNo

        val balance: Int = balance

        @JsonProperty("ac_name")
        val acName: String = acName

        @JsonProperty("cp_name")
        val cpName: String = cpName

        @JsonProperty("cp_logo")
        val cpLogo: String = cpLogo
}
