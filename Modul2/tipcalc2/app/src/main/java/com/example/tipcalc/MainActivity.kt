package com.example.tipcalc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val costOfServiceEditText: EditText = findViewById(R.id.cost_of_service)
        val tipOptions: RadioGroup = findViewById(R.id.tip_options)
        val roundUpSwitch: Switch = findViewById(R.id.round_up_switch)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val tipResultTextView: TextView = findViewById(R.id.tip_result)

        tipResultTextView.visibility = TextView.GONE
        calculateButton.setOnClickListener {
            val cost = costOfServiceEditText.text.toString().toDoubleOrNull()
            if (cost == null) {
                tipResultTextView.text = getString(R.string.tip_amount, 0.0)
                return@setOnClickListener
            }

            val tipPercentage = when (tipOptions.checkedRadioButtonId) {
                R.id.option_twenty_percent -> 0.20
                R.id.option_eighteen_percent -> 0.18
                R.id.option_fifteen_percent -> 0.15
                else -> 0.0
            }

            var tip = cost * tipPercentage
            if (roundUpSwitch.isChecked) {
                tip = BigDecimal(tip).setScale(0, RoundingMode.UP).toDouble()
            }

            tipResultTextView.text = getString(R.string.tip_amount, tip)
            tipResultTextView.visibility = TextView.VISIBLE
        }
    }
}
