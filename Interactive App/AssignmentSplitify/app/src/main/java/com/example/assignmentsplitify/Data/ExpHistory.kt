package com.example.assignmentsplitify.Data

import androidx.annotation.StringRes
import com.example.assignmentsplitify.R

data class ExpHistory(
    @StringRes val item: Int,
    val price: Int,
    @StringRes val paidBy :Int,
    @StringRes val date :Int
)

val ExpHistoryInfo = listOf(
    ExpHistory(R.string.Onion,45,R.string.Mike,R.string.Date1),
    ExpHistory(R.string.Eggs,42,R.string.John,R.string.Date2),
    ExpHistory(R.string.sugar,45,R.string.Mike,R.string.Date3),
    ExpHistory(R.string.list1,45,R.string.Alice,R.string.Date3)
)


