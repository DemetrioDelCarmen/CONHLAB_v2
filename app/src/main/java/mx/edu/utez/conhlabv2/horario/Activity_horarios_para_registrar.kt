package mx.edu.utez.conhlabv2.horario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_horarios_para_registrar.*
import mx.edu.utez.conhlabv2.R

class Activity_horarios_para_registrar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios_para_registrar)

        val arregloDias = intent.getStringArrayListExtra("arregloDias")
                as ArrayList<String>



        val customAdapter = CustomAdapterHorario(this,arregloDias)
        lv_registro_dias_horas.adapter = customAdapter

    }
}
