package edu.us.ischool.dlangner.lifecounter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.support.annotation.AttrRes
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView

class PlayerCompoundControl: ConstraintLayout {

    lateinit var delegate: MainActivity

    lateinit var playerNameLabel: TextView
    lateinit var scoreLabel: TextView
    lateinit var minusFiveButton: Button
    lateinit var minusOneButton: Button
    lateinit var plusOneButton: Button
    lateinit var plusFiveButton: Button

    constructor(context: Context) : super(context) {
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
    }
    constructor(context: Context, attrs: AttributeSet?,
                @AttrRes defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initializeViews(context)
    }

    private fun initializeViews(context:Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.player_compound_component, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        playerNameLabel = this.findViewById(R.id.player_text)
        scoreLabel = this.findViewById(R.id.score_text)

        minusFiveButton = this.findViewById(R.id.minus_five)
        minusFiveButton.setOnClickListener {
            val currScore = Integer.parseInt(scoreLabel.text.toString())

            if (currScore > 0) {
                if (currScore - 5 < 0) {
                    scoreLabel.text = "0"
                } else {
                    scoreLabel.text = (currScore - 5).toString()
                }
                checkForPlayerLoss()
            }
        }

        minusOneButton = this.findViewById(R.id.minus_one)
        minusOneButton.setOnClickListener {
            val currScore = Integer.parseInt(scoreLabel.text.toString())
            if (currScore > 0) {
                scoreLabel.text = (currScore - 1).toString()
                checkForPlayerLoss()
            }
        }

        plusOneButton = this.findViewById(R.id.plus_one)
        plusOneButton.setOnClickListener {
            val newScore = (Integer.parseInt(scoreLabel.text.toString()) + 1).toString()
            scoreLabel.text = newScore
        }

        plusFiveButton = this.findViewById(R.id.plus_five)
        plusFiveButton.setOnClickListener {
            val newScore = (Integer.parseInt(scoreLabel.text.toString()) + 5).toString()
            scoreLabel.text = newScore
        }
    }

    private fun checkForPlayerLoss() {
        if (Integer.parseInt(scoreLabel.text.toString())<= 0) {
            delegate.setLoserStatus(playerNameLabel.text.toString())
        }
    }
}
