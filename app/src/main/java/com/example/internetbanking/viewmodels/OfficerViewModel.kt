package com.example.internetbanking.viewmodels

import androidx.lifecycle.ViewModel
import com.example.internetbanking.data.OfficerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OfficerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OfficerUiState())
    val uiState: StateFlow<OfficerUiState> = _uiState.asStateFlow()


}