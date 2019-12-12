package mx.edu.utez.conhlabv2.horario

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import mx.edu.utez.conhlabv2.R

class CustomAdapterHorario(val context: Context, val contenido: ArrayList<String>) : BaseAdapter() {


    val arreglo = arrayListOf<String>("1", "2", "3")


    var sharedPreferences = context.getSharedPreferences("archivo", Context.MODE_PRIVATE)

    inner class ViewHolder {
        var sp_horas_entrada: Spinner? = null
        var sp_horas_salida: Spinner? = null
        var tv_dia: TextView? = null
    }





    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            val inflate =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflate.inflate(R.layout.plantilla_lista_dias_horas, null, true)
            holder.sp_horas_entrada = convertView!!.findViewById(R.id.sp_horas_entrada) as Spinner


            holder.sp_horas_salida = convertView!!.findViewById(R.id.sp_horas_salida) as Spinner

            holder.tv_dia = convertView!!.findViewById(R.id.tv_dia) as TextView



            holder.sp_horas_entrada!!.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position2: Int,
                        id: Long
                    ) {

                        with(sharedPreferences.edit()) {
                            putString(contenido[position]+"_E", arreglo[position2])
                            putInt(contenido[position]+"_I_E", position2)
                            commit()
                        }

                    }

                }


            holder.sp_horas_salida!!.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position2: Int,
                        id: Long
                    ) {

                        with(sharedPreferences.edit()) {
                            putString(contenido[position]+"_S", arreglo[position2])
                            commit()
                        }



                    }

                }


            convertView.tag = holder


        } else {


            holder = convertView.tag as ViewHolder
        }
        holder!!.sp_horas_entrada!!.setSelection(
            (sharedPreferences
                .getInt(contenido[position]+"_I_E", 2))
        )

        holder.tv_dia!!.text = contenido[position]
        holder.sp_horas_entrada!!.adapter =
            ArrayAdapter(context, android.R.layout.simple_spinner_item, arreglo)
        holder.sp_horas_salida!!.adapter =
            ArrayAdapter(context, android.R.layout.simple_spinner_item, arreglo)

        return convertView


    }

    override fun getItem(position: Int): Any {

        return contenido[position]

    }

    override fun getItemId(p0: Int): Long {

        return 0

    }

    override fun getCount(): Int {
        return contenido.size
    }


}