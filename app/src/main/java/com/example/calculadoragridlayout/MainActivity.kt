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
  //  var pendingOperation = true;
    var operacionPendiente= false
    var suma = false
    var resta= false
    var numeroAnterior = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult = findViewById(R.id.txt_result)


    }
    fun presionoBoton(v: View){

      // son los click que tienen dados de alta todos los numeros
        val boton = v as TextView
        //hacer un arreglo para conocer la operacion
        if (txtResult.text.equals("0") || operacionPendiente) {
            txtResult.text= boton.text
            operacionPendiente=false
        }
        else
            txtResult.text= "${txtResult.text}${boton.text}"
    }

    fun ejecutarOperacion(){
        var numeroActual = txtResult.text.toString().toInt()
        var result=0
        if (suma)
            result= numeroActual + numeroAnterior
        else if(resta)
            result= numeroAnterior - numeroActual
        txtResult.text= result.toString()



    }
    fun  presionoOperacion(v:View){
        val boton = v as TextView
        if (suma || resta)
            ejecutarOperacion()
        operacionPendiente= true
      when(boton.text){
          "+"->{
              suma= true
              resta=false
              //para rescatar el numero anterior
              numeroAnterior= txtResult.text.toString().toInt()


          }
          "-"->{
              suma= false
              resta= true
              numeroAnterior= txtResult.text.toString().toInt()


          }
          "="->{
              suma=false
              resta=false
              operacionPendiente= true
              numeroAnterior=0
          }
          "C"->{
              suma=false
              resta=false
              txtResult.text="0"
              numeroAnterior=0
          }

      }

    }
}