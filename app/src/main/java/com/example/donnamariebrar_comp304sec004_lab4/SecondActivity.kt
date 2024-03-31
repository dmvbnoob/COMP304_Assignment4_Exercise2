package com.example.donnamariebrar_comp304sec004_lab4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donnamariebrar_comp304sec004_lab4.ui.theme.DonnaMarieBrar_COMP304Sec004_Lab4Theme
import androidx.compose.material3.Button

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val selectedProg = intent.getStringExtra("selectedProg") ?: ""
        setContent {
            DonnaMarieBrar_COMP304Sec004_Lab4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SLayout(selectedProg)
                }
            }
        }
    }
}

//Layout
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SLayout(selectedProg: String) {
    FlowColumn(modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp))
    {
        Text(
            text = "Semester 4 Courses",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 1.sp,
            lineHeight = 36.sp,
        )
        CourseList(selectedProg)
    }
}

//List
@Composable
fun CourseList(selectedProg: String) {
    val context = LocalContext.current
    val courses = when (selectedProg) {
        "Computer Science" -> context.resources.getStringArray(R.array.csCourses)
        "Software Engineering" -> context.resources.getStringArray(R.array.seCourses)
        "Information Technology" -> context.resources.getStringArray(R.array.itCourses)
        else -> emptyArray()
    }.toList() // Convert the array to a list here

    var selectedCourseIndex by remember { mutableStateOf(-1) }
    var selectedCourse by remember { mutableStateOf("") }

    val courseDetails = mapOf(
        "CNET212 - Virtualization and Cloud Technology" to
                "This course covers the full stack virtualization architecture that combines virtual machines, virtual networking, and storage and how the virtualization technologies support cloud computing.",
        "CNET222 - Network Services" to
                "This course provides a broad understanding of services offered on a server operating system from installation and configuration, to management and monitoring.",
        "CNET304 - Wireless Technology" to
                "This course introduces the learner to technology of the modern wireless communication systems and their application to transmit voice, data and images.",
        "CNET307 - IT Project Management" to
                "Students are taught the concepts and basic functions of Project Management, and the integration of these concepts and functions into a coherent project management system.",
        "COMP216 - Networking for Software Developers" to
                "Learners in this course will gain hands-on experience by applying knowledge of network protocols and components to the development and maintenance of software applications.",
        "COMP308 - Emerging Technologies" to
                "This course will examine various emerging app development technologies in the rapidly changing world of software.",
        "NET211 - Unix/Linux Operating Systems" to
                "This course builds upon topics discussed in Windows Server Operating System. It explores the advanced aspects of the theory, design and application of both single-user and multi-user networks using two competing operating systems: Unix and Linux to support small to large businesses.",
        "NET220 - Computer and Network Security" to
                "In this course, students are given a clear overview of computer security concepts, including access control, malicious software, cryptography, biometrics as well as government regulations and standards.",
        "NET221 - Wireless Communication Systems" to
                "This course builds the theoretical foundation for the course sequence NET320 Wireless Networks and the elective sequence, NET902 Cellular Networks and NET903 Wireless Broadband, which examine various wireless networks.",
    )

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp),verticalArrangement = Arrangement.spacedBy(16.dp)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(courses) { index, course ->
                Text(
                    text = course,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedCourseIndex = index
                            selectedCourse = courseDetails[course] ?: ""
                        }
                        .background(if (index == selectedCourseIndex) Color.LightGray else Color.White)
                        .padding(16.dp)
                )
            }
        }

        Text(
            text = selectedCourse,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        )

        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SLayoutPreview() {
    DonnaMarieBrar_COMP304Sec004_Lab4Theme {
        SLayout("Computer Science")
    }
}