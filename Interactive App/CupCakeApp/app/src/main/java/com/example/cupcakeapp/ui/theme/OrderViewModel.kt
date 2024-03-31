package com.example.cupcakeapp.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class OrderViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiStatus(pickupOptions = pickupOptions()))

}