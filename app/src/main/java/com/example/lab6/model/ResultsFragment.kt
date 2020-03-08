package com.example.lab6.model


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.lab6.R

/**
 * A simple [Fragment] subclass.
 */
class ResultsFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var question: String
    private lateinit var answer: String
    private lateinit var stars: String
    private lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        question = arguments!!.getString("question")!!
        answer = arguments!!.getString("answer")!!
        stars = "5"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.new_survey_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.get_answers).setOnClickListener(this)

        message = "Pregunta: $question \nRespuesta: $answer"
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.new_survey_button -> {
                navController.navigate(R.id.action_resultsFragment_to_mainFragment)
            }
            R.id.get_answers -> {
                navController.navigate(R.id.action_resultsFragment_to_listView)
            }
        }
    }


}
