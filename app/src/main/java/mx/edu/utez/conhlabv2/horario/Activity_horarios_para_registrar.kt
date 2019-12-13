package mx.edu.utez.conhlabv2.horario

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_horarios_para_registrar.*
import mx.edu.utez.conhlab.ui.home.HomeFragment
import mx.edu.utez.conhlabv2.MainActivity
import mx.edu.utez.conhlabv2.R
import mx.edu.utez.conhlabv2.horario_semanal.HorarioSemanal
import mx.edu.utez.conhlabv2.utility.AppDatabase

class Activity_horarios_para_registrar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios_para_registrar)

        val arregloDias = intent.getStringArrayListExtra("arregloDias")
                as ArrayList<String>

        val customAdapter = CustomAdapterHorario(this, arregloDias)
        lv_registro_dias_horas.adapter = customAdapter

        btn_registrar_horario.setOnClickListener {

            val sharedPreferences = getSharedPreferences("archivo", Context.MODE_PRIVATE)
            val db = AppDatabase.getInstance(this)

            for (i in arregloDias) {
                val entrada = sharedPreferences.getString("${i}_E", "#")
                val salida = sharedPreferences.getString("${i}_S", "#")


                Thread {


                    val horario = HorarioSemanal(0, i, entrada.toString(), salida.toString())
                    db.horarioDao().registrar(horario)
                    val intent = Intent(this, MainActivity::class.java)

                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)

                }.start()



            }

            Toasty.success(this,"Horarios registrados",Toasty.LENGTH_SHORT).show()



        }



    }


}

