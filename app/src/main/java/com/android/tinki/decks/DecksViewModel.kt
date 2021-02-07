package com.android.tinki.decks

import androidx.lifecycle.ViewModel

class DecksViewModel : ViewModel() {

    val decks = arrayListOf<String>()

    init {
        getDecks()
    }

    fun getDecks() {
        for (i in 1..10) {
            decks.add("deck $i")
        }
    }
}