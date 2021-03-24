package raim.zarin.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity alllows the user to roll a dice and
 * view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a roll when app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create new dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val imageView: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }

        // Update the screen with the dice roll
        imageView.setImageResource(drawableResource)

        // Update the content description
        imageView.contentDescription = diceRoll.toString()
    }
}

/**
 * This class represents a dice with specified number of sides
 */
class Dice(private val numSides: Int = 6) {
    // Return random number within range of 1 to total sides number
    fun roll(): Int {
        return (1..numSides).random()
    }
}