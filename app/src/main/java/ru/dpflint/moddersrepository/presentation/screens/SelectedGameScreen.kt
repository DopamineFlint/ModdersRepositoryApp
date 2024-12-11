package ru.dpflint.moddersrepository.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.dpflint.moddersrepository.presentation.components.CustomBottomAppBar

@Composable
fun SelectedGameScreen(
    navController: NavController
) {
    val dataArray by remember { mutableStateOf(listOf(
        "Option One",
        "Option Two",
        "Option Three",
        "Option Four",
        "Option Five",
        "Option Seven",
        "Option Eight",
        "Option Nine",
        "Option Ten",
        "Option Eleven",
        "Option Twelve",
        "Option Thirteen",
        "Option Fourteen",
        "Option Fifteen",
    )) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.onPrimary,
        bottomBar = {
            CustomBottomAppBar(
                navController = navController
            ) {
                println("lol")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(20.dp)
        ) {
            items(
                count = dataArray.size,
                key = { item -> dataArray[item] }
            ) { i ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clickable { //TODO
                            //navController.navigate()
                        },
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = dataArray[i],
                            fontSize = 26.sp,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}