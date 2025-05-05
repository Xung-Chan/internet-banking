package com.example.internetbanking.ui.customer

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.internetbanking.viewmodels.CustomerViewModel

@Composable
fun TransferScreen(
    customerViewModel: CustomerViewModel,
    navController: NavHostController
) {

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TransferScreenPreview(){
    val fakeViewModel: CustomerViewModel = viewModel()
    val fakeNavController: NavHostController = rememberNavController()

    TransferScreen(fakeViewModel, fakeNavController)
}