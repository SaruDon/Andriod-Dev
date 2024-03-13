package com.example.assignmentsplitify.Data

import androidx.annotation.StringRes
import com.example.assignmentsplitify.R


data class Person(
    @StringRes val key: Int,
    val value: Int
)

val keyValuePairs = listOf(
    Person(R.string.Alice, 803),
    Person(R.string.John, 695),
    Person(R.string.Mike, 610),
    Person(R.string.Person4, 123),
    Person(R.string.Person5, 456),
    // Add more entries as needed
    Person(R.string.Person6, 789),
    Person(R.string.Person7, 321),
    Person(R.string.Person8, 654),
    Person(R.string.Person9, 987),
    Person(R.string.Person10, 246),
    Person(R.string.Person11, 579),
    Person(R.string.Person12, 852),
    Person(R.string.Person13, 135),
    Person(R.string.Person14, 468),
    Person(R.string.Person15, 791),
    Person(R.string.Person16, 234),
    Person(R.string.Person17, 567),
    Person(R.string.Person18, 890),
    Person(R.string.Person19, 123),
    Person(R.string.Person20, 456)
)
