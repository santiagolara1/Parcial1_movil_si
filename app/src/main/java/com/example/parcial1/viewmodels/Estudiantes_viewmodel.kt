package com.example.parcial1.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial1.models.Estudiantes_entidad
import com.example.parcial1.states.Estudiantes_estados
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class Estudiantes_viewmodel(
    private val Dao: Any
): ViewModel() {

    var estado by mutableStateOf(Estudiantes_estados())
        private set

    init {
        viewModelScope.launch {
            Dao.obtenerEstudiantes().collectLatest {
                estado = estado.copy(
                    lista_estudiantes = it
                )
            }
        }
    }

    fun agregarestudiante( estudiante: Estudiantes_entidad) = viewModelScope.launch {
        Dao.agregarestudiante(estudiante = estudiante)
    }

    fun actualizarestudiante( estudiante: Estudiantes_entidad) = viewModelScope.launch {
        Dao.actualizarestudiante(estudiante = estudiante)
    }

    fun eliminarestudiante( estudiante: Estudiantes_entidad) = viewModelScope.launch {
        Dao.eliminarestudiante(estudiante = estudiante)
    }
}

