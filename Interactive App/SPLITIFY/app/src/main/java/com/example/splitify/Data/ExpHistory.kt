package com.example.splitify.Data

import androidx.annotation.StringRes
import com.example.splitify.R

data class ExpHistory(
    @StringRes val item: Int,
    val price: Int,
    @StringRes val paidBy :Int
)

val ExpHistoryInfo = listOf(
    ExpHistory(R.string.Onion,45,R.string.Mike),
    ExpHistory(R.string.Eggs,42,R.string.John),
    ExpHistory(R.string.sugar,45,R.string.Mike),
    ExpHistory(R.string.list1,45,R.string.Alice)
)

