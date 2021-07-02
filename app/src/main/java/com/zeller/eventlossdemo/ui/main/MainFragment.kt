package com.zeller.eventlossdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.zeller.eventlossdemo.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    val textView:TextView? by lazy {
        view?.findViewById(R.id.message)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.findViewById<Button>(R.id.button)?.setOnClickListener {
            viewModel.trigger()
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.events.observe(viewLifecycleOwner) {
            textView?.append("$it")
        }
    }

}