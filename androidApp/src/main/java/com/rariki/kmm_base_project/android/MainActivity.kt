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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rariki.kmm_base_project.core.network.ApiResponse
import com.rariki.kmm_base_project.core.network.sample.RocketLaunch
import com.rariki.kmm_base_project.core.network.sample.SampleApi
import com.rariki.kmm_base_project.ui.MyTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            val sampleApi = koinInject<SampleApi>()
                            var apiResponse:ApiResponse<List<RocketLaunch>>? by remember {
                                mutableStateOf(null)
                            }

                            ResultView(apiResponse = apiResponse)

                            LaunchedEffect(true) {
                                apiResponse = sampleApi.safeGetAllLaunches()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ResultView(apiResponse: ApiResponse<List<RocketLaunch>>?) {
    when(apiResponse) {
        is ApiResponse.Error.GenericError -> Text("Exception ${apiResponse.exception?.message}")
        is ApiResponse.Error.HttpError -> Text("Error HttpError ${apiResponse.errorMessage}")
        is ApiResponse.Error.SerializationError -> Text("Error Serial")
        is ApiResponse.Success -> {
            val list = apiResponse.body

            if (list.isEmpty()) {
                Text(text = "Empty")
            }
            LazyColumn {
                items(list) {
                    Text(text = it.missionName)
                }
            }
        }
        null -> Text("Loading")
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
