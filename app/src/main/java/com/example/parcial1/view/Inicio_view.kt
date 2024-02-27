package com.example.parcial1.view

import android.R.color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.parcial1.viewmodels.Estudiantes_viewmodel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio_view(navController: NavController, viewModel: Estudiantes_viewmodel){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Lista Estudiantes",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold)
            },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("agregar") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) {
        Content_Inicioview(it, navController,viewModel)
    }

}

@Composable
fun  Content_Inicioview(it: PaddingValues, navController: NavController, viewModel: Estudiantes_viewmodel) {

    val estado = viewModel.estado

    Column(
        modifier = Modifier.padding(it)
    ) {
       LazyColumn{
           items(estado.lista_estudiantes){
               Box(
                   modifier = Modifier
                       .padding(8.dp)
                       .fillMaxWidth()
               ){
                   Column (
                       modifier = Modifier
                           .padding(12.dp)
                   ){
                       Text(text = "${it.id}")
                       Text(text = "${it.nombre}")
                       IconButton(
                           onClick = { navController.navigate("editar/${it.id}/${it.nombre}/${it.telefono}/${it.email}/${it.Promedio}/${it.semestre}") }
                       ) {
                            Icon(imageVector = Icons.Default.Edit, contentDescription = "editar")
                       }
                       IconButton(
                           onClick = {viewModel.eliminarestudiante(it)}
                       ) {
                           Icon(imageVector = Icons.Default.Delete, contentDescription = "borrar")
                       }
                   }
               }
           }
       }
    }
}
