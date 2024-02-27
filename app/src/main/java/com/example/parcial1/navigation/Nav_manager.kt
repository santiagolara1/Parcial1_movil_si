package com.example.parcial1.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.parcial1.view.Agregar_view
import com.example.parcial1.view.Editar_view
import com.example.parcial1.view.Inicio_view
import com.example.parcial1.viewmodels.Estudiantes_viewmodel

@Composable
fun Nav_manager(viewModel: Estudiantes_viewmodel){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio" ){
        composable("inicio"){
            Inicio_view(navController,viewModel)
        }
        composable("agregar"){
            Agregar_view(navController,viewModel)
        }
        composable("editar/{id}/{nombre}/{telefono}/{email}/{Promedio}/{semestre}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
            navArgument("nombre"){type = NavType.StringType},
            navArgument("telefono"){type = NavType.StringType},
            navArgument("email"){type = NavType.StringType},
            navArgument("Promedio"){type = NavType.FloatType},
            navArgument("semestre"){type = NavType.IntType},
        )){
            Editar_view(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("nombre").toString(),
                it.arguments?.getString("telefono").toString(),
                it.arguments?.getString("email").toString(),
                it.arguments?.getFloat("Promedio")!!.toFloat(),
                it.arguments?.getInt("semestre")!!.toInt(),
                )
        }
        ///composable("ver_informacion/{id}"){
            //verinformacion_view(navController,viewModel)
        //}
    }
}