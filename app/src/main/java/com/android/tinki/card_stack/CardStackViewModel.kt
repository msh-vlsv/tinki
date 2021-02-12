package com.android.tinki.card_stack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardStackViewModel : ViewModel() {

    private val stream = MutableLiveData<CardsModel>()

    val modelStream: LiveData<CardsModel>
        get() = stream

    private val data = arrayListOf(
            Card("card 1"),
            Card("card 2"),
            Card("card 3"),
            Card("card 4"),
            Card("card 5"),
            Card("card 6"),
            Card("card 7"),
            Card("card 8"),
            Card("card 9"),
            Card("card 10"),
            Card("card 11"),
            Card("card 12"),
            Card("card 13"),
            Card("card 14"),
            Card("card 15"),
            Card("card 16"),
            Card("card 17"),
            Card("card 18"),
            Card("card 19"),
            Card("card 20")
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