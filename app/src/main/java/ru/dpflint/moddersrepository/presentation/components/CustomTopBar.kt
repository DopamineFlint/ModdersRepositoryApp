package ru.dpflint.moddersrepository.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String,
    enableDoneButton: Boolean,
    enableSearchButton: Boolean,
    onClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red
        ),
        title = {
            Text(
                text = title,
                color = Color.Black
            )
        },
        actions = {
            if (enableDoneButton) {
                IconButton({
                    onClick()
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Done"
                    )
                }
            }

            if (enableSearchButton) {
                IconButton({
                    onClick()
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            }
        }
    )
}