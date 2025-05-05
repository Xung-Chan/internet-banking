package com.example.internetbanking.ui.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.internetbanking.ui.theme.custom_mint_green
import com.example.internetbanking.viewmodels.LoginViewModel

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navController: NavHostController
) {
    var idInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var isPasswordShowing by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = custom_mint_green
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LoginTextField(
                value = idInput,
                onValueChange = { idInput = it },
                label = "Your Account ID",
                leadingIcon = Icons.Filled.Person,
                contentDesc = "User's ID",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
        }
    }
}

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    contentDesc: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    isHidden: Boolean = false,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = contentDesc
            )
        },
        visualTransformation = if (isHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(

        ),
        singleLine = true,
        modifier = modifier
            .fillMaxWidth(0.7f)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ScreenPreview(){
    val fakeViewModel: LoginViewModel = viewModel()
    val fakeNavController: NavHostController = rememberNavController()

    LoginScreen(fakeViewModel, fakeNavController)
}