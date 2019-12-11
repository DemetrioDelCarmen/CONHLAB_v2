package mx.edu.utez.conhlabv2.horario

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Spinner
import android.widget.TextView
import mx.edu.utez.conhlabv2.R

class CustomAdapterHorario(val context: Context, val contenido: ArrayList<String>) : BaseAdapter() {


    val arreglo = arrayListOf<String>("1", "2", "3")

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

            convertView.tag = holder


        } else {


            holder = convertView.tag as ViewHolder


        }


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