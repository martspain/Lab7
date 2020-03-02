package com.example.lab6.model


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.lab6.R
import kotlinx.android.synthetic.main.fragment_survey.*

/**
 * A simple [Fragment] subclass.
 */
class SurveyFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var question: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        question = arguments!!.getString("question")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_survey, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_button).setOnClickListener(this)
        val message = question
        view.findViewById<TextView>(R.id.survey_question).text = message
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.next_button -> {
                if(!TextUtils.isEmpty(answer_input.text.toString())){
                    val bundle = bundleOf("question" to question, "answer" to answer_input.text.toString())
                    navController.navigate(R.id.action_surveyFragment_to_ratingFragment, bundle)
                }
                else{
                    Toast.makeText(activity, "Ingrese una respuesta", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}
