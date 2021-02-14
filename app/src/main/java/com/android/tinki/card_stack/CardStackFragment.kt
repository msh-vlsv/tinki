package com.android.tinki.card_stack

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import com.android.tinki.R
import com.google.android.material.button.MaterialButton

class CardStackFragment : Fragment() {

    companion object {
        fun newInstance() = CardStackFragment()
    }

    private lateinit var viewModel: CardStackViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.card_stack_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CardStackViewModel::class.java)
        viewModel
            .modelStream
            .observe(viewLifecycleOwner, Observer {
                bindCard(it)
            })

        view?.findViewById<MotionLayout>(R.id.motionLayout)?.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                motionLayout?.post {
                    when (currentId) {
                        R.id.easy, R.id.good, R.id.hard, R.id.again -> {
                            motionLayout?.progress = 0f
                            viewModel.swipe()
                        }
                    }
                }
            }
        })
    }

    private fun bindCard(model: CardsModel) {
        view?.findViewById<TextView>(R.id.cardOneName)?.text = model.cardTop.name
        view?.findViewById<TextView>(R.id.cardTwoName)?.text = model.cardBottom.name
    }

}