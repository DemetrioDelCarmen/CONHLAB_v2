package mx.edu.utez.conhlab.ui.home

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_home.*
import mx.edu.utez.conhlab.utility.SQLiteUtility
import mx.edu.utez.conhlabv2.R
import mx.edu.utez.conhlabv2.horario.Activity_comenzar_registro_horario

class HomeFragment : Fragment() {
    var flagChequeo = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)




        val btnChecar = root.findViewById<Button>(R.id.btn_checar)
        btnChecar.setOnClickListener {


            val alertDialog: AlertDialog? = activity?.let {
                val builder = AlertDialog.Builder(it)

                builder.apply {
                    setPositiveButton(
                        R.string.txt_aceptar,

                        DialogInterface.OnClickListener { dialog, id ->


                            Toasty.success(
                                context,
                                R.string.txt_confirmacion_chequeo,
                                Toast.LENGTH_LONG,
                                true
                            ).show()

                            btnChecar.setText(R.string.checar_salida)
                            flagChequeo.plus(1)


                            btn_dia_no_laboral.isEnabled = false
                            btn_dia_no_laboral.isLongClickable = false
                        })
                    setNegativeButton(
                        R.string.txt_cancelar,
                        DialogInterface.OnClickListener { dialog, id ->
                            Toasty.warning(
                                context, R.string.txt_negacion_chequeo,
                                Toast.LENGTH_LONG, true
                            ).show()
                        })
                    setTitle(R.string.title_confirmar_chequeo)
                    setMessage(R.string.message_confirmar_chequeo)
                }
                builder.create()
            }
            alertDialog?.show()


        }

        val btn_dia_no_laboral = root.findViewById<Button>(R.id.btn_dia_no_laboral)


        btn_dia_no_laboral.setOnLongClickListener {


            if (flagChequeo == 0) {

                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply {
                        setPositiveButton(
                            R.string.txt_aceptar,
                            DialogInterface.OnClickListener { dialog, id ->
                                Toasty.success(
                                    context,
                                    R.string.confirmacion_chequeo_no_laboral,
                                    Toast.LENGTH_LONG,
                                    true
                                ).show()
                                btnChecar.isEnabled = false
                                btnChecar.isClickable = false
                            })
                        setNegativeButton(
                            R.string.txt_cancelar,
                            DialogInterface.OnClickListener { dialog, id ->
                                Toasty.warning(
                                    context, R.string.cancelacion_no_laboral,
                                    Toast.LENGTH_LONG, true
                                ).show()
                            })
                        setTitle(R.string.message_confirmar_chequeo_no_laboral)
                        setMessage(R.string.message_confirmar_no_laboral)
                    }
                    builder.create()
                }
                alertDialog?.show()

            } else {
                Toasty.error(
                    requireContext(), R.string.negacion_doble_chequeo_laboral,
                    Toast.LENGTH_LONG, true
                ).show()
            }

            true

        }




        return root
    }





}