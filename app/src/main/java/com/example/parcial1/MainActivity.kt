package com.example.parcial1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.parcial1.navigation.Nav_manager
import com.example.parcial1.room.EstudiantesDB
import com.example.parcial1.ui.theme.Parcial1Theme
import com.example.parcial1.viewmodels.Estudiantes_viewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, EstudiantesDB::class.java,"db_estudiantes").build()
                    val dao = database.EstudiantesDBDao()

                    val viewmodel = Estudiantes_viewmodel(dao)

                    Nav_Manager(viewModel = viewmodel)
                }
            }
        }
    }
}

