package mx.edu.utez.conhlab.ui.informacion_personal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty
import mx.edu.utez.conhlabv2.R
import java.lang.Exception

class FragmentInformacionPersonal: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_informacion_personal,container,false)


        val btn_go_info = root.findViewById<Button>(R.id.go_to_modify_information)


        btn_go_info.setOnClickListener{


                try{




                    Toasty.success(requireContext(),"Modify information", Toast.LENGTH_LONG).show()


                }catch (e:Exception){
                    Toasty.error(requireContext(),"Error ${e.message}", Toast.LENGTH_LONG).show()
                }

        }




        return root

    }


}