package com.example.lab6.model


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.lab6.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<FloatingActionButton>(R.id.addQuestion_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.start_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.addQuestion_button -> navController.navigate(R.id.action_mainFragment_to_addFragment)
            R.id.start_button -> navController.navigate(R.id.action_mainFragment_to_surveyFragment)
        }
    }


}
