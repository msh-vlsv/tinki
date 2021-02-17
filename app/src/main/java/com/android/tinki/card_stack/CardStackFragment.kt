package com.android.tinki.card_stack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.tinki.R
import com.android.tinki.databinding.FragmentCardStackBinding

class CardStackFragment : Fragment() {

    private lateinit var cardStackViewModel: CardStackViewModel
    private var _binding: FragmentCardStackBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        cardStackViewModel = ViewModelProvider(this).get(CardStackViewModel::class.java)
        _binding = FragmentCardStackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        cardStackViewModel
            .modelStream
            .observe(viewLifecycleOwner, Observer {
                bindCards(it)
            })
        binding.motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                motionLayout?.post {
                    when (currentId) {
                        R.id.easy, R.id.good, R.id.hard, R.id.again -> {
                            motionLayout?.progress = 0f
                            binding.textSeparator.visibility = View.INVISIBLE
                            binding.cardOneBackText.visibility = View.INVISIBLE
                            motionLayout?.transitionToState(R.id.start)
                            cardStackViewModel.swipe()
                        }
                        R.id.flip -> {
                            binding.cardOne.isClickable = false
                        }
                    }
                }
            }
        })

        binding.againButton.setOnClickListener {
            binding.motionLayout.transitionToState(R.id.again)
        }

        binding.hardButton.setOnClickListener {
            binding.motionLayout.transitionToState(R.id.hard)
        }

        binding.goodButton.setOnClickListener {
            binding.motionLayout.transitionToState(R.id.good)
        }

        binding.easyButton.setOnClickListener {
            binding.motionLayout.transitionToState(R.id.easy)
        }
    }

    private fun bindCards(model: CardsModel) {
        binding.cardOneFrontText.text = model.cardTop.front
        binding.cardOneBackText.text = model.cardTop.back
        binding.cardTwoFrontText.text = model.cardBottom.front
    }

}