package com.example.sesionesandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sesionesandroid.ui.navigation.NavGraph
import com.example.sesionesandroid.ui.theme.SesionesAndroidTheme
import com.example.sesionesandroid.ui.theme.AppTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val nav = rememberNavController()
                NavGraph(nav)
            }
        }
    }
}
