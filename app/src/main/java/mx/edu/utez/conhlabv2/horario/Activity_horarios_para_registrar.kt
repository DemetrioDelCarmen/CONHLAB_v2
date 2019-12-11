package mx.edu.utez.conhlabv2.horario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_horarios_para_registrar.*
import mx.edu.utez.conhlabv2.R

class Activity_horarios_para_registrar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios_para_registrar)

        val arregloDias = intent.getStringArrayListExtra("arregloDias")
                as ArrayList<String>


        val customAdapter = CustomAdapterHorario(this, arregloDias)
        lv_registro_dias_horas.adapter = customAdapter



        val sp_horas_entrada =  findViewById<Spinner>(R.id.sp_horas_entrada)
        btn_registrar_horario.setOnClickListener {


            for (e in arregloDias.iterator()) println(e)
            var it = arregloDias.iterator()
            while (it.hasNext()) {
                var e = it.next()
                println(sp_horas_entrada.)
            }

        }


    }
}
