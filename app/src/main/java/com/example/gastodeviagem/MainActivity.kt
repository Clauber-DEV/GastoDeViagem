package com.example.gastodeviagem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculate()
        }
    }


    private fun calculate() {
        if (validationOk()) {

            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                textTotalvalue.text = "R$ ${"%.2f"}".format(totalValue)
            } catch (nfe: NullPointerException) {
                Toast.makeText(
                    this,
                    getString(R.string.Por_favor_informe_um_valor_valido),
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {

            Toast.makeText(this, getString(R.string.Preencha_todos_os_campos), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validationOk(): Boolean = (editDistance.text.toString() != ""
            && editPrice.text.toString() != ""
            && editAutonomy.text.toString() != "")
}