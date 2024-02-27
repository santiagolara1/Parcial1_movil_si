package com.example.parcial1.states

import com.example.parcial1.models.Estudiantes_entidad

data class Estudiantes_estados(
    val lista_estudiantes: List<Estudiantes_entidad> = emptyList()
)
