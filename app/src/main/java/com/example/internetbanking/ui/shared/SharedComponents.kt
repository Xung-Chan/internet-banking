package com.example.internetbanking.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internetbanking.ui.theme.custom_dark_green

@Composable
fun BalanceInformation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = custom_dark_green, shape = RoundedCornerShape(
                    topStart = CornerSize(40),
                    bottomEnd = CornerSize(40),
                    topEnd = CornerSize(20),
                    bottomStart = CornerSize(20)
                )
            )
            .border(
                2.dp, color = Color.Gray, shape = RoundedCornerShape(
                    topStart = CornerSize(40),
                    bottomEnd = CornerSize(40),
                    topEnd = CornerSize(20),
                    bottomStart = CornerSize(20)
                )
            )
            .padding(all = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("Tài khoản nguồn", color = Color.White)
            Spacer(Modifier.height(15.dp))
            Text("Số dư", color = Color.White)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "023456000000",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(
                        color = Color.Green, shape = RoundedCornerShape(corner = CornerSize(50))
                    )
                    .padding(all = 7.dp)
            )
            Spacer(Modifier.height(5.dp))
            Row {
                Text("120,000", color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(10.dp))
                Text("VND", color = Color.Gray, fontSize = 10.sp)
            }
        }
    }
}

@Composable
fun InformationLine(label: String,placeholder: String, suffix: @Composable () -> Unit = {}) {
    var expaned by remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .border(
                1.dp,
                Color.Gray,
                shape = RoundedCornerShape(corner = CornerSize(20))
            )
            .padding(all = 10.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clickable(onClick = {
                expaned=true
            })
    ) {
        Column {
            Text(label, fontWeight = FontWeight.Bold)
            TextButton(
                onClick = { expaned = true }
            ) {
                Text(placeholder, color = Color.Gray)
            }
            DropdownMenu(
                expanded = expaned,
                onDismissRequest = {
                    expaned = false
                }, modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                DropdownMenuItem(
                    text =
                        { Text("Vietcombank") },
                    onClick = { expaned = false }
                )
                DropdownMenuItem(
                    text =
                        { Text("Sacombank") },
                    onClick = { expaned = false }
                )
                DropdownMenuItem(
                    text =
                        { Text("Techcombank") },
                    onClick = { expaned = false }
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(0.3f)
        ) {
            suffix()
        }
    }
}

@Composable
@Preview(
    showBackground = true
)
fun Preview() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        InformationLine(label = "Ngân hàng nhận", placeholder = "Chọn ngân hàng nhận", suffix = {
            VerticalDivider(modifier = Modifier.fillMaxHeight(0.8f), color = Color.Gray)
            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
        })
    }
}