package com.android.tinki.card_stack

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.android.tinki.R
import com.android.tinki.databinding.CardStackFragmentBinding
import com.android.tinki.databinding.FragmentCardsBinding

class CardStackFragment : Fragment() {

    private lateinit var viewModel: CardStackViewModel
    private var _binding: CardStackFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardStackFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CardStackViewModel::class.java)
        // TODO: Use the ViewModel
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        menu.findItem(R.id.action_settings).setVisible(false)
//    }
}