package com.example.parcial1.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.parcial1.models.Estudiantes_entidad

@Database(
    entities = [Estudiantes_entidad::class],
    version = 1,
)
abstract class EstudiantesDB: RoomDatabase() {
    abstract fun EstudiantesDBDao(): Any

    abstract val dao : EstudiantesDBDao
}