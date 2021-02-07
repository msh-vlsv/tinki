package com.android.tinki.decks

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.tinki.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}