package com.example.lab6.model


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lab6.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_add.*

/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<FloatingActionButton>(R.id.cancel_button).setOnClickListener(this)
        view.findViewById<FloatingActionButton>(R.id.save_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.cancel_button -> {
                if(!TextUtils.isEmpty(question_input.text.toString())){
                    val bundle = bundleOf("question" to question_input.text.toString())
                    navController.navigate(R.id.action_addFragment_to_mainFragment2, bundle)
                }
                else{
                    Toast.makeText(activity, "Ingrese una pregunta", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.save_button -> activity!!.onBackPressed()
        }
    }


}
