package edu.us.ischool.dlangner.lifecounter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.support.annotation.AttrRes
import android.widget.Button
import android.widget.TextView

class PlayerCompoundControl: ConstraintLayout {

    var playerNameLabel: TextView = findViewById(R.id.player_text)
    var scoreLabel: TextView = findViewById(R.id.score_text)
    var minusFiveButton: Button = findViewById(R.id.minus_five)
    var minusOneButton: Button = findViewById(R.id.minus_one)
    var plusOneButton: Button = findViewById(R.id.plus_one)
    var plusFiveButton: Button = findViewById(R.id.plus_one)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?,
                @AttrRes defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}