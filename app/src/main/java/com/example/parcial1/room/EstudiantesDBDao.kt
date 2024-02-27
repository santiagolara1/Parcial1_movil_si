package com.example.parcial1.room


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.parcial1.models.Estudiantes_entidad
import kotlin.collections.List
import kotlinx.coroutines.flow.Flow

@Dao
interface EstudiantesDBDao {

    @Query("SELECT * FROM estudiantes")
    fun obtenerEstudiantes(): Flow<List<Estudiantes_entidad>>

    @Query("SELECT * FROM estudiantes WHERE id = :id")
    fun obtenerestudiante(id: Int): Flow<Estudiantes_entidad>

    @Insert
    suspend fun agregarestudiante(estudiante: Estudiantes_entidad)

    @Update
    suspend fun actualizarestudiante(estudiante: Estudiantes_entidad)

    @Delete
    suspend fun eliminarestudiante(estudiante: Estudiantes_entidad)


}