package sanchez.juan.asignacion04_calculadora_imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entradaEstatura :EditText = findViewById(R.id.etEstatura)
        val entradaPeso :EditText = findViewById(R.id.etPeso)
        val calcular : Button = findViewById(R.id.btnCalcular)
        val resultado : TextView = findViewById(R.id.tvResultado)
        val rango : TextView = findViewById(R.id.tvRango)

        calcular.setOnClickListener()
        {


            val estatura = entradaEstatura.text.toString()
            val peso = entradaPeso.text.toString()

            val valorEstatura = estatura.toDoubleOrNull()
            val valorPeso = peso.toDoubleOrNull()



            if(valorEstatura!=null && valorPeso!=null)
            {
                val imc = calcularIMC(valorEstatura,valorPeso)
                resultado.text =  "Tu IMC es: %.2f".format(imc)
                rango.text = calcularRango(imc)
            }

        }

    }

    private fun calcularIMC(estatura: Double, peso: Double): Double
    {
        return peso / (estatura * estatura)
    }

    private fun calcularRango(imc: Double) : String
    {
        return when  {
            imc in 0.0..18.5 -> "Bajo peso"
            imc in 18.6..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidad Grado 01"
            imc in 35.0..39.9 -> "Obesidad Grado 02"
            else -> "Entrada inválida"
        }
    }



}
