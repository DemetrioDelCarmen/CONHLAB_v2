package mx.edu.utez.conhlabv2.horario

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import es.dmoral.toasty.Toasty
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




        btn_registrar_horario.setOnClickListener {

            val sharedPreferences = getSharedPreferences("archivo",Context.MODE_PRIVATE)


            for(i in arregloDias){
                val entrada = sharedPreferences.getString("${i}_E","#")
                val salida = sharedPreferences.getString("${i}_S","#")

                Toasty.success(this,"$i de $entrada a $salida",Toasty.LENGTH_LONG).show()
            }

        }


    }
}
