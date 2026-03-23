package com.aulasandroid.gestoestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.aulasandroid.gestoestado.juros.JurosScreen
import com.aulasandroid.gestoestado.juros.JurosScreenViewModel
import com.aulasandroid.gestoestado.ui.theme.GestãoEstadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestãoEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    JurosScreen(
                        modifier = Modifier.padding(innerPadding),
                        jurosScreenViewModel = JurosScreenViewModel()
                    )
                }
            }
        }
    }
}


