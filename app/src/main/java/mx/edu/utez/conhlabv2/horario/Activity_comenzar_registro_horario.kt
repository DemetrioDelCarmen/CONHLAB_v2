package mx.edu.utez.conhlabv2.horario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.vista_comenzar_registro_horario.*
import mx.edu.utez.conhlabv2.R

class Activity_comenzar_registro_horario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_comenzar_registro_horario)



        btn_go_to_register_horario.setOnClickListener{

            goToRegister()
        }


    }


    fun goToRegister(){

        btn_go_to_register_horario.setOnClickListener{
            val intent = Intent(this@Activity_comenzar_registro_horario,Activity_registro_horario::class.java)
            startActivity(intent)

        }

    }
}
