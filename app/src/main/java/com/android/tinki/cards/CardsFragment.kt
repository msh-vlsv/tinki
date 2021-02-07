package com.android.tinki.cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.tinki.R
import com.android.tinki.databinding.FragmentCardsBinding
import com.android.tinki.databinding.FragmentDecksBinding
import com.android.tinki.decks.DeckAdapter
import com.android.tinki.decks.DecksViewModel
import com.android.tinki.ui.cards.CardsAdapter
import com.android.tinki.ui.cards.CardsViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CardsFragment : Fragment() {

    private lateinit var cardsViewModel: CardsViewModel
    private var _binding: FragmentCardsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        cardsViewModel =
            ViewModelProvider(this).get(CardsViewModel::class.java)
        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        binding.cardsRecyclerView.layoutManager = GridLayoutManager(this.context, 3)
        binding.cardsRecyclerView.adapter = CardsAdapter(cardsViewModel.cards)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            Snackbar.make(view, "Start review", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}