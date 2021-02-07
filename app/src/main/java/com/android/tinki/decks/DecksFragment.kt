package com.android.tinki.decks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.tinki.databinding.FragmentDecksBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DecksFragment : Fragment() {

    private lateinit var decksViewModel: DecksViewModel
    private var _binding: FragmentDecksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        decksViewModel =
            ViewModelProvider(this).get(DecksViewModel::class.java)
        _binding = FragmentDecksBinding.inflate(inflater, container, false)
        binding.decksRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.decksRecyclerView.adapter = DeckAdapter(decksViewModel.decks)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}