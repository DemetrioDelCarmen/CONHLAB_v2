package mx.edu.utez.conhlabv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*
import mx.edu.utez.conhlab.ui.historico.HistoricoFragment
import mx.edu.utez.conhlab.ui.home.HomeFragment
import mx.edu.utez.conhlab.ui.informacion_personal.FragmentInformacionPersonal
import mx.edu.utez.conhlab.utility.SQLiteUtility
import mx.edu.utez.conhlabv2.horario.Activity_comenzar_registro_horario

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.nav_dashboard ->{
                replaceFragment(HomeFragment())

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_professors ->{
                println("Agregar presionado")
                replaceFragment(HistoricoFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_personal_info ->{
                println("Buscar presionado")
                replaceFragment(FragmentInformacionPersonal())
                return@OnNavigationItemSelectedListener true
            }

            else ->
                return@OnNavigationItemSelectedListener false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mostrar, fragment).addToBackStack(null)
        fragmentTransaction.commit()

        verifyHorarios()
    }



    fun verifyHorarios(){

        var conexion = SQLiteUtility(this, "entrada_semanal", 1)


        var listaDias = ArrayList<String>()

        val db = conexion.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM entrada_semana", null)

        if (cursor.moveToFirst()) {
            do {

                listaDias.add(cursor.getString(1))

            } while (cursor.moveToNext())
        }

        if(listaDias.size==0){


            goToStartRegister()
        }else{

            Toasty.success(this,"Si hay data",Toasty.LENGTH_LONG).show()
        }
    }



    fun goToStartRegister(){


        val intent = Intent(this, Activity_comenzar_registro_horario::class.java)

        startActivity(intent)

    }
}
