package com.example.parcial1.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.parcial1.viewmodels.Estudiantes_viewmodel
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.parcial1.models.Estudiantes_entidad

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Editar_view(navController: NavController,viewModel: Estudiantes_viewmodel, id: Int, nombre : String, telefono : String, email : String, Promedio : Float, semestre : Int){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar Estudiante",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = "regresar",
                            tint = Color.White)
                    }
                }
            )
        }
    ) {
        ContentEditar_view(it, navController,viewModel,id, nombre, telefono, email, Promedio, semestre )
    }

}

@Composable
fun ContentEditar_view(it: PaddingValues, navController: NavController, viewModel: Estudiantes_viewmodel,id: Int, nombre : String, telefono : String, email : String, Promedio : Float, semestre : Int) {

    var nombre by remember { mutableStateOf(" ") }
    var Telefono by remember { mutableStateOf(" ") }
    var email by remember { mutableStateOf(" ") }
    var promedio by remember { mutableStateOf(" ") }
    var semestre by remember { mutableStateOf(" ") }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre ?:"",
            onValueChange = {nombre = it},
            label = { Text(text = "nombre")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = Telefono ?:"",
            onValueChange = {Telefono = it},
            label = { Text(text = "Telefono")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = email ?:"",
            onValueChange = {email = it},
            label = { Text(text = "email")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = promedio ?:"",
            onValueChange = {promedio = it},
            label = { Text(text = "promedio")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = semestre ?:"",
            onValueChange = {semestre = it},
            label = { Text(text = "semestre")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        Button(
            onClick = {
                val estudiante = Estudiantes_entidad(id = id,nombre = nombre!!, telefono = Telefono!!, email = email!!, Promedio = promedio.toFloat()!!, semestre = semestre.toInt()!!)
                viewModel.actualizarestudiante(estudiante)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}