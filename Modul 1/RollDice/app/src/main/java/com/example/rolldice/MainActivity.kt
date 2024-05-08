package com.example.rolldice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceImage01: ImageView = findViewById(R.id.imageView)
        diceImage01.setImageResource(R.drawable.dice_0)

        val diceImage02: ImageView = findViewById(R.id.imageView2)
        diceImage02.setImageResource(R.drawable.dice_0)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val firstDice = Dice(6)
        val firstRoll = firstDice.roll()

        val diceImagef: ImageView = findViewById(R.id.imageView)
        when (firstRoll) {
            1 -> diceImagef.setImageResource(R.drawable.dice_1)
            2 -> diceImagef.setImageResource(R.drawable.dice_2)
            3 -> diceImagef.setImageResource(R.drawable.dice_3)
            4 -> diceImagef.setImageResource(R.drawable.dice_4)
            5 -> diceImagef.setImageResource(R.drawable.dice_5)
            6 -> diceImagef.setImageResource(R.drawable.dice_6)
        }

        val secDice = Dice(6)
        val secRoll = secDice.roll()

        val diceImages: ImageView = findViewById(R.id.imageView2)
        when (secRoll) {
            1 -> diceImages.setImageResource(R.drawable.dice_1)
            2 -> diceImages.setImageResource(R.drawable.dice_2)
            3 -> diceImages.setImageResource(R.drawable.dice_3)
            4 -> diceImages.setImageResource(R.drawable.dice_4)
            5 -> diceImages.setImageResource(R.drawable.dice_5)
            6 -> diceImages.setImageResource(R.drawable.dice_6)
        }

        if (firstRoll == secRoll){
            val toast = Toast.makeText(this, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(this, "Anda belum beruntung!", Toast.LENGTH_SHORT)
            toast.show() }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}