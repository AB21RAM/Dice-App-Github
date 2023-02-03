package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButten1: Button = findViewById(R.id.button1)
        rollButten1.setOnClickListener {
            rollDice1()
        }
        rollDice1()
    }

    private fun rollDice1() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage : ImageView = findViewById(R.id.imageView)
        val imageResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imageResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(val numSides : Int){
    fun roll() : Int {
        return (1 .. numSides).random()
    }
}

