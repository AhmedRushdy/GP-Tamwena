package com.ar.gptamwena.ui.sign
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.FragmentSplashPlaceBinding
import com.ar.gptamwena.databinding.FragmentSplashRegistrationBinding
import com.ar.gptamwena.ui.DrawerActivity

class SplashRegistrationFragment : Fragment() {
    var signUp: Button? = null
    var login: Button? = null
    private lateinit var viewModel: LoginViewModel
    lateinit var binding: FragmentSplashRegistrationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_splash_registration, container, false)
        binding = FragmentSplashRegistrationBinding.inflate(layoutInflater,container,false)
        binding.splashLogin.setOnClickListener(View.OnClickListener {
           findNavController().navigate(R.id.action_splashRegistrationFragment_to_splashLoginFragment)

//            SignActivity.fragment = SplashLoginFragment()
//            assert(fragmentManager != null)
//            val transaction = requireFragmentManager().beginTransaction()
//            // transaction.setCustomAnimations(R.anim.left_to_right,R.anim.exit_left_to_right,R.anim.right_to_left,R.anim.exit_right_to_left);
//            transaction.replace(R.id.fragment_frame, SignActivity.fragment!!)
//            transaction.addToBackStack(null)
//            transaction.commit()
        })
        binding.splashSignup.setOnClickListener(View.OnClickListener { view ->
            startActivity(
                Intent(
                    view.context,
                    DrawerActivity::class.java
                )
            )
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SignActivity).loginViewModel

    }
}