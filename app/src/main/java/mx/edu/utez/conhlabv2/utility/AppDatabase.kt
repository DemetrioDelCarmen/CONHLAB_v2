package mx.edu.utez.conhlabv2.utility

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.edu.utez.conhlabv2.horario_semanal.HorarioInterface
import mx.edu.utez.conhlabv2.horario_semanal.HorarioSemanal


    @Database(
        entities = arrayOf(HorarioSemanal::class),

        version = 1
    )

    abstract class AppDatabase : RoomDatabase() {
        abstract fun horarioDao(): HorarioInterface


        companion object {
            private var INSTANCE: AppDatabase? = null
            fun getInstance(context: Context): AppDatabase {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "conhlab"
                    )
                        .build()

                }
                return INSTANCE as AppDatabase
            }
        }
    }
