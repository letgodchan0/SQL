package com.finance.backend.bank.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.finance.backend.insurance.response.MyInsuranceInfoDetailRes
import com.finance.backend.insurance.response.MyInsuranceInfoRes

class AccountRegisteredRes(
        accountList: List<BankAccountRes>,
        insuranceList: List<MyInsuranceInfoDetailRes>,
        financeList: List<BankAccountRes>
) {
    @JsonProperty("account_list")
    val accountList = accountList

    @JsonProperty("insurance_list")
    val insuranceList = insuranceList

    @JsonProperty("finance_list")
    val financeList = financeList
}