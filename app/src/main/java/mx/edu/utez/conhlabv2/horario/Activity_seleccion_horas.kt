package mx.edu.utez.conhlabv2.horario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_seleccion_horas.*
import mx.edu.utez.conhlabv2.R

class Activity_seleccion_horas : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_horas)


        val arregloDias = intent.getStringArrayListExtra("arregloDias")
                as ArrayList<String>


    }


}
