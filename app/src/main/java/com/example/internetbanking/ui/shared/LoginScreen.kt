package com.example.internetbanking.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.HideSource
import androidx.compose.material.icons.filled.LockPerson
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.internetbanking.ui.theme.custom_dark_green
import com.example.internetbanking.ui.theme.custom_light_green
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
        containerColor = custom_dark_green
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = custom_mint_green,
                        shape = RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .padding(top = 20.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        text = "WELCOME TO SACOBANK",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = custom_light_green
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    LoginTextField(
                        value = idInput,
                        onValueChange = { idInput = it },
                        label = "Account ID",
                        leadingIcon = Icons.Filled.Person,
                        onTrailingIconClick = { idInput = "" },
                        contentDesc = "User's ID",
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    LoginTextField(
                        value = passwordInput,
                        onValueChange = { passwordInput = it },
                        label = "Password",
                        leadingIcon = Icons.Filled.LockPerson,
                        onTrailingIconClick = { passwordInput = "" },
                        onShowPasswordIconClick = { isPasswordShowing = !isPasswordShowing },
                        contentDesc = "User's Password",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        isContentShowing = isPasswordShowing
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(
                        onClick = {

                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = custom_dark_green
                        ),
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(0.9f)
                    ) {
                        Text(
                            text = "Sign In",
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    onTrailingIconClick: () -> Unit,
    contentDesc: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    isContentShowing: Boolean = false,
    onShowPasswordIconClick: () -> Unit = {}
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
                contentDescription = contentDesc,
                tint = custom_dark_green
            )
        },
        trailingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                if (contentDesc == "User's Password") {
                    IconButton(
                        onClick = onShowPasswordIconClick
                    ) {
                        if (isContentShowing) {
                            Icon(
                                imageVector = Icons.Filled.RemoveRedEye,
                                contentDescription = "Show Password",
                                tint = Color.Gray,
                                modifier = Modifier.padding(0.dp)
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.HideSource,
                                contentDescription = "Show Password",
                                tint = Color.Gray
                            )
                        }
                    }
                }
                IconButton(
                    onClick = onTrailingIconClick
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Clear text field",
                        tint = Color.Gray
                    )
                }
            }
        },
        visualTransformation = if (!isContentShowing) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            unfocusedTextColor = Color.Black,
            focusedTextColor = Color.Black,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray
        ),
        singleLine = true,
        modifier = modifier
            .fillMaxWidth(0.9f)
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