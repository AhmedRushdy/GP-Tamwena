package com.example.tmkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ar.gptamwena.R

class CustomerRegistrationCardFragment : Fragment() {
    var num: EditText? = null
    var button: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.fragment_customer_registration_card, container, false)
        button = view.findViewById(R.id.card_conf)
        num = view.findViewById(R.id.card_number)
        button?.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_customerRegistrationCardFragment_to_customerRegistrationFragment)
        })
        return view
    }
}