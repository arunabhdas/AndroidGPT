package ai.cloudcnctrai.cloudcnctrai

import ai.cloudcnctrai.cloudcnctrai.navigation.Navigator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import ai.cloudcnctrai.cloudcnctrai.theme.CloudCnctrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudCnctrTheme {
                // TODO-FIXME MainScreen()
                Navigator()
            }
        }
    }
}