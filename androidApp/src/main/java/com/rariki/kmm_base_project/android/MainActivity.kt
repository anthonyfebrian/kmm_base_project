package com.rariki.kmm_base_project.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rariki.kmm_base_project.Greeting
import com.rariki.kmm_base_project.core.network.sample.RocketLaunch
import com.rariki.kmm_base_project.core.network.sample.SampleApi
import com.rariki.kmm_base_project.ui.MyTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val sampleApi = koinInject<SampleApi>()
                    var list by remember { mutableStateOf<List<RocketLaunch>>(listOf()) }
                    if(list.isEmpty()) {
                        Text(text = "Empty")
                    }

                    LazyColumn {
                        items(list) {
                            Text(text = it.missionName)
                        }
                    }

                    LaunchedEffect(true) {
                        list = sampleApi.getAllLaunches()
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyTheme {
        GreetingView("Hello, Android!")
    }
}
