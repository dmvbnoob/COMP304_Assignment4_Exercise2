package com.example.donnamariebrar_comp304sec004_lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donnamariebrar_comp304sec004_lab4.ui.theme.DonnaMarieBrar_COMP304Sec004_Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DonnaMarieBrar_COMP304Sec004_Lab4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Layout()
                }
            }
        }
    }
}

//Layout
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Layout() {
    FlowColumn(modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp))
    {
        Text(
            text = "Please select a program",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 1.sp,
            lineHeight = 36.sp,
        )
        ProgList()
    }
}

//List
@Composable
fun ProgList() {
    val context = LocalContext.current
    val programs = context.resources.getStringArray(R.array.swProgs).toList()
    var selectedItemIndex by remember { mutableStateOf(-1) }

    LazyColumn(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        itemsIndexed(programs) { index, program ->
            Text(
                text = program,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedItemIndex = index }
                    .background(if (index == selectedItemIndex) Color.LightGray else Color.White)
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutPreview() {
    DonnaMarieBrar_COMP304Sec004_Lab4Theme {
        Layout()
    }
}