package mx.edu.utez.conhlabv2.horario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_registro_horario.*
import kotlinx.android.synthetic.main.vista_comenzar_registro_horario.*
import mx.edu.utez.conhlabv2.R

class Activity_registro_horario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_horario)



        btn_registrar_dias.setOnClickListener{

        }


    }




    fun registrarDias(){

        Toasty.success(this,"Registrar días", Toasty.LENGTH_SHORT).show()
    }



}
