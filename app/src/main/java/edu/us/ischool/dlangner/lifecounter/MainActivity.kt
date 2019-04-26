package edu.us.ischool.dlangner.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var playerOne: PlayerCompoundControl
    lateinit var playerTwo: PlayerCompoundControl
    lateinit var playerThree: PlayerCompoundControl
    lateinit var playerFour: PlayerCompoundControl

    lateinit var loserText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerOne = findViewById(R.id.first_player)
        playerOne.playerNameLabel.text = "Player 1"
        playerOne.delegate = this

        playerTwo = findViewById(R.id.second_player)
        playerTwo.playerNameLabel.text = "Player 2"
        playerTwo.delegate = this

        playerThree = findViewById(R.id.third_player)
        playerThree.playerNameLabel.text = "Player 3"
        playerThree.delegate = this

        playerFour = findViewById(R.id.fourth_player)
        playerFour.playerNameLabel.text = "Player 4"
        playerFour.delegate = this

        loserText = findViewById(R.id.loser_text_view)
    }

    fun setLoserStatus(playerName: String) {
        loserText.text = playerName + " Loses!"
        loserText.visibility = View.VISIBLE
     }
}
