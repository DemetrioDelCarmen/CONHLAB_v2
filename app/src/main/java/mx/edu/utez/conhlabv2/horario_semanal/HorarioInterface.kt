package mx.edu.utez.conhlabv2.horario_semanal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HorarioInterface {

    @Query("SELECT * FROM horarioSemanal")
    fun obtener(): List<HorarioSemanal>

    @Insert
    fun registrar(horarioSemanal: HorarioSemanal)


}