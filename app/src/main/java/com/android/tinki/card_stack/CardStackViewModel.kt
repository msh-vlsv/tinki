package com.android.tinki.card_stack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardStackViewModel : ViewModel() {

    private val stream = MutableLiveData<CardsModel>()

    val modelStream: LiveData<CardsModel>
        get() = stream

    private val data = arrayListOf(
            Card("card 1 front", "card 1 back"),
            Card("card 2 front", "card 2 back"),
            Card("card 3 front", "card 3 back"),
            Card("card 4 front", "card 4 back"),
            Card("card 5 front", "card 5 back"),
            Card("card 6 front", "card 6 back"),
            Card("card 7 front", "card 7 back"),
            Card("card 8 front", "card 8 back"),
            Card("card 9 front", "card 9 back"),
            Card("card 10 front", "card 10 back"),
            Card("card 11 front", "card 11 back"),
            Card("card 12 front", "card 12 back"),
            Card("card 13 front", "card 13 back"),
            Card("card 14 front", "card 14 back"),
            Card("card 15 front", "card 15 back"),
            Card("card 16 front", "card 16 back"),
            Card("card 17 front", "card 17 back"),
            Card("card 18 front", "card 18 back"),
            Card("card 19 front", "card 19 back"),
            Card("card 20 front", "card 20 back")
    )

    var currentIndex = 0

    private val topCard
        get() = data[currentIndex % data.size]
    private val bottomCard
        get() = data[(currentIndex + 1) % data.size]

    init {
        updateCards()
    }

    fun swipe() {
        currentIndex += 1
        updateCards()
    }

    private fun updateCards() {
        stream.value = CardsModel(
            cardTop = topCard,
            cardBottom = bottomCard
        )
    }

}