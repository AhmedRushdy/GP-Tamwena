package com.ar.gptamwena.ui.sign
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.FragmentSplashPlaceBinding

class SplashPlaceFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel
    lateinit var binding: FragmentSplashPlaceBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashPlaceBinding.inflate(layoutInflater,container,false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SignActivity).loginViewModel

        binding.checkPlaceGps.setOnClickListener(View.OnClickListener {
           findNavController().navigate(R.id.action_splashPlaceFragment_to_splashRegistrationFragment)

//            SignActivity.fragment = SplashRegistrationFragment()
//            assert(fragmentManager != null)
//            val transaction = requireFragmentManager().beginTransaction()
//                .setCustomAnimations(
//                    R.anim.left_to_right,
//                    R.anim.exit_left_to_right,
//                    R.anim.right_to_left,
//                    R.anim.exit_right_to_left
//                )
//            transaction.replace(R.id.fragment_frame, SignActivity.fragment!!)
//            transaction.addToBackStack(null)
//            transaction.commit()
        })

    }
}