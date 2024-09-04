package com.example.iotdatamanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.iotdatamanagement.ui.theme.IoTDataManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IoTDataManagementTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        MyTopBar()
                    },
                    bottomBar = {
                        MyBottomBar()
                    })
                { innerPadding ->
                    MyContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text(text = "IoT Data Management") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search Button"
                )
            }
            var expanded by remember { mutableStateOf(false) }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More options")
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    text = { Text(text = "Menu item 1") },
                    onClick = { expanded = false }
                )
                DropdownMenuItem(
                    text = { Text(text = "Menu item 2") },
                    onClick = { expanded = false }
                )
            }
        }
    )
}

@Composable
fun MyBottomBar() {
    BottomAppBar(
        actions = {},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    )
}

@Composable
fun MyContent(modifier: Modifier = Modifier) {
    Column(modifier) {

    }
}









@Preview(showBackground = true)
@Composable
fun MyContentPreview() {
    MyContent()
}

@Preview(showBackground = true)
@Composable
fun MyTopBarPreview() {
    MyTopBar()
}

@Preview(showBackground = true)
@Composable
fun MyBottomBarPreview() {
    MyBottomBar()
}