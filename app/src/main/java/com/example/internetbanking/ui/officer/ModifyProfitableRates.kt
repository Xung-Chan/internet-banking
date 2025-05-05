package com.example.internetbanking.ui.officer

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.internetbanking.viewmodels.OfficerViewModel

@Composable
fun ModifyProfitableRatesScreen(
    officerViewModel: OfficerViewModel,
    navController: NavHostController
) {

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ModifyProfitableRatesPreview(){
    val fakeViewModel: OfficerViewModel = viewModel()
    val fakeNavController: NavHostController = rememberNavController()

    ModifyProfitableRatesScreen(fakeViewModel, fakeNavController)
}