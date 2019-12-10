package mx.edu.utez.conhlab.utility

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SQLiteUtility(context:Context, database: String,version:Int):
    SQLiteOpenHelper(context,database,null,version){


    val create_table_entrada_semanal = "CREATE TABLE entrada_semana(ES_Id INTEGER NOT NULL PRIMARY KEY, ES_Dia TEXT, ES_Hora_entrada TEXT,ES_Hora_salida TEXT) "

    val drop_entrada_semanal = "DROP TABLE IF EXISTS entrada_semana"
    /*

    val create_table_dia ="CREATE TABLE `dia` (`DIA_Id` INTEGER NOT NULL PRIMARY KEY,  `DIA_Dia` TEXT NOT NULL)"

    val create_table_dia_horario= "CREATE TABLE `diahorario` (`DH_Id` INTEGER NOT NULL PRIMARY KEY,`DH_HRA_Entrada` INTEGER NOT NULL,`DH_DIA_Id` INTEGER NOT NULL,`DH_HRA_Salida` INTEGER NOT NULL,`DH_HR_Id` INTEGER NOT NULL)"


    val create_table_dias_festivos=  "CREATE TABLE `diasfestivos`(`DF_Id` INTEGER NOT NULL PRIMARY KEY,`DF_Dia` date NOT NULL)"
    val create_table_dias_docente ="CREATE TABLE `docente` (`DC_Id` INTEGER NOT NULL PRIMARY KEY,`DC_Nombre` TEXT NOT NULL,`DC_Apellido` TEXT NOT NULL,`DC_Correo` TEXT NOT NULL)"

    val creare_table_hora = "CREATE TABLE `hora` (`HRA_Id` INTEGER NOT NULL PRIMARY KEY,`HRA_Hora` datetime NOT NULL)"

    val create_table_horario = "CREATE TABLE `horario` (`HR_Id` INTEGER NOT NULL PRIMARY KEY,`HR_DC_Id` INTEGER NOT NULL,`HR_PR_Id` INTEGER NOT NULL)"


    val create_table_periodo = "CREATE TABLE `periodo` (`PR_Id` INTEGER NOT NULL PRIMARY KEY,`PR_Periodo` TEXT NOT NULL)"



     */

    override fun onCreate(db: SQLiteDatabase?) {
       /*
        db!!.execSQL(create_table_dia)
        db!!.execSQL(create_table_dia_horario)
        db!!.execSQL(create_table_dias_festivos)
        db!!.execSQL(create_table_dias_docente)
        db!!.execSQL(creare_table_hora)
        db!!.execSQL(create_table_horario)
        db!!.execSQL(create_table_periodo)

        */
        db!!.execSQL(create_table_entrada_semanal)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(drop_entrada_semanal)
        onCreate(db)
    }

}