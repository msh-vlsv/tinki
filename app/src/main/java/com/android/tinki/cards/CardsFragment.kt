package com.android.tinki.cards

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.android.tinki.R
import com.android.tinki.databinding.FragmentCardsBinding
import com.android.tinki.ui.cards.CardsAdapter
import com.android.tinki.ui.cards.CardsViewModel

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
            findNavController().navigate(R.id.action_CardsFragment_to_cardStackFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_cards, menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}
