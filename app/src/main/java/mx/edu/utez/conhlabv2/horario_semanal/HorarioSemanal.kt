package mx.edu.utez.conhlabv2.horario_semanal

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class HorarioSemanal(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idHorarioSemanal")
    val idHorarioSemanal: Int,
    @ColumnInfo(name = "dia")
    val dia: String,
    @ColumnInfo(name = "entrada")
    val entrada: String,
    @ColumnInfo(name = "salida")
    val salida: String

)