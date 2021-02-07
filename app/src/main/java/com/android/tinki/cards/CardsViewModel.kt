package com.android.tinki.ui.cards

import androidx.lifecycle.ViewModel

class CardsViewModel : ViewModel() {

    val cards = arrayListOf<String>()

    init {
        getCards()
    }

    fun getCards() {
        for (i in 1..30) {
            cards.add("card $i")
        }
    }
}