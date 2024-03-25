package com.example.assignmentmargh.Data

import androidx.annotation.DrawableRes
import com.example.assignmentmargh.R

data class Page(
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(R.drawable.screenshot_2024_0313_140611),
    Page(R.drawable.screenshot_2024_0313_140632),
    Page(R.drawable.screenshot_2024_0313_140644_1_),
    Page(R.drawable.screenshot_2024_0313_140757),
    Page(R.drawable.screenshot_2024_0313_140805)
)