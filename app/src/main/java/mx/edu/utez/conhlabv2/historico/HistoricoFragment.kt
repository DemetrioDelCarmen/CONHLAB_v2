package mx.edu.utez.conhlab.ui.historico

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_historico_cuatrimestral.*
import mx.edu.utez.conhlabv2.R

class HistoricoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var spinner = view!!.findViewById<Spinner>(R.id.spinner_tipo_busqueda)

        var consultas = arrayOf<String>("Semanal", "Mensual")


        val arrayAdapterConsultas =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, consultas)
        spinner!!.adapter = arrayAdapterConsultas


        /*

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toasty.success(requireContext(), "Item ${consultas[position]}", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }

            val view = inflater.inflate(R.layout.fragment_historico_cuatrimestral, container, false)


        }

         */

        return view
    }

}