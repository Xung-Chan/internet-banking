package com.example.internetbanking.ui.officer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.internetbanking.R
import com.example.internetbanking.ui.shared.GradientBackground
import com.example.internetbanking.ui.theme.GradientColors
import com.example.internetbanking.ui.theme.custom_light_green2
import com.example.internetbanking.ui.theme.custom_mint_green
import com.example.internetbanking.viewmodels.OfficerViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfficerHome(
    officerViewModel: OfficerViewModel,
    navController: NavHostController,
) {
    val officerUiState by officerViewModel.uiState.collectAsState()

    Scaffold(
        containerColor = custom_mint_green,
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(R.drawable.logo_2),
                        contentDescription = "LB Digital",
                        modifier = Modifier.width(100.dp)
                    )
                },
                actions = {
                    IconButton(
                        onClick = { //TODO: LogOut

                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = "Logout",
                            tint = custom_light_green2
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .background(
                        brush = GradientColors.GreenRipple
                    )
            )
        },
        modifier = Modifier.systemBarsPadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxSize()
        ) {
            GradientBackground(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight(0.1f)
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Officer:",
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.width(60.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun OfficerHomePreview(){
    val fakeViewModel: OfficerViewModel = viewModel()
    val fakeNavController: NavHostController = rememberNavController()

    OfficerHome(fakeViewModel, fakeNavController)
}