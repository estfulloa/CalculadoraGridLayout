package com.example.calculadoragridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var txtResult: TextView
   // <!-- Aqui se define la bandera --!>
    lateinit var ultimoNumero: TextView
    var resultado: Boolean = true
    var suma: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult = findViewById(R.id.txt_result)
        ultimoNumero = findViewById(R.id.txt_result)
    }
    fun presionoBoton(v: View){

        val boton = v as TextView
      //  Log.e("CALAPP", "Presiono numero: ${boton.text}")
        txtResult.text = boton.text
        if (boton.equals(suma))
            


    }

    fun  presionoOperacion(v:View){
        val boton = v as TextView
       // Log.e("CALAPP", "Presiono operacion: ${boton.text}")
        txtResult.text= boton.text


    }
}