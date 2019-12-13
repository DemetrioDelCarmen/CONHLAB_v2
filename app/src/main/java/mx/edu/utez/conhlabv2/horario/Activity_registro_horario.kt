package mx.edu.utez.conhlabv2.horario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registro_horario.*
import mx.edu.utez.conhlabv2.R

class Activity_registro_horario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_horario)


        btn_registrar_dias.setOnClickListener {
            registrarDias()

        }




    }


    fun registrarDias(){
        var arregloDias = arrayListOf<String>()
        if(cb_lunes.isChecked){
            arregloDias.add(resources.getString(R.string.lunes))
        }
        if(cb_martes.isChecked){
            arregloDias.add(resources.getString(R.string.martes))
        }
        if(cb_miercoles.isChecked){
            arregloDias.add(resources.getString(R.string.miercoles))
        }
        if(cb_jueves.isChecked){
            arregloDias.add(resources.getString(R.string.jueves))
        }
        if(cb_viernes.isChecked){
            arregloDias.add(resources.getString(R.string.viernes))
        }
        if(cb_sabado.isChecked){
            arregloDias.add(resources.getString(R.string.sabado))
        }



        val intent = Intent(this@Activity_registro_horario, Activity_horarios_para_registrar::class.java)
        intent.putStringArrayListExtra("arregloDias", arregloDias)
        startActivity(intent)

    }




}
