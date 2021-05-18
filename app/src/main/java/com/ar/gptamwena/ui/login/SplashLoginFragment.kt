package com.ar.gptamwena.ui.login
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ar.gptamwena.R
import com.ar.gptamwena.ui.DrawerActivity

class SplashLoginFragment : Fragment() {
    var confirmType: Button? = null
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_splash_login, container, false)
        confirmType = view.findViewById(R.id.btn_login)
        confirmType?.setOnClickListener(View.OnClickListener { view ->
            startActivity(
                Intent(
                    view.context,
                    DrawerActivity::class.java
                )
            )
        })
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SignActivity).loginViewModel

    }
}