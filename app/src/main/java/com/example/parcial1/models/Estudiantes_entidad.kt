package com.example.parcial1.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiantes")
data class Estudiantes_entidad(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("telefono")
    val telefono: String,
    @ColumnInfo("email")
    val email: String,
    @ColumnInfo("Promedio")
    val Promedio: Float = 0.0f,
    @ColumnInfo("semestre")
    val semestre: Int = 0,
)
