package com.example.tmkotlin.fragments
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.ar.gptamwena.R

class CustomerRegistrationFragment : Fragment() {
    var name: EditText? = null
    var card: EditText? = null
    var pass: EditText? = null
    var confirmPass: EditText? = null
    var buttonSave: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_customer_registration, container, false)
        buttonSave = view.findViewById(R.id.confirm_registration)
        name = view.findViewById(R.id.full_name)
        card = view.findViewById(R.id.card_number)
        pass = view.findViewById(R.id.password)
        confirmPass = view.findViewById(R.id.password_confirm)
        buttonSave?.setOnClickListener(View.OnClickListener { view ->
//            startActivity(
//                Intent(
//                    view.context,
//                    CustomerMainActivity::class.java
//                )
//            )
        })
        return view
    }
}