package com.ar.gptamwena.ui.sign
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ar.gptamwena.R

class SplashPlaceFragment : Fragment() {
    var checkGps: Button? = null
    var chackManual: TextView? = null
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_splash_place, container, false)
        checkGps = view.findViewById(R.id.check_place_gps)
        chackManual = view.findViewById(R.id.check_place_manual)
        checkGps?.setOnClickListener(View.OnClickListener {
            SignActivity.fragment = SplashRegistrationFragment()
            assert(fragmentManager != null)
            val transaction = requireFragmentManager().beginTransaction()
                .setCustomAnimations(
                    R.anim.left_to_right,
                    R.anim.exit_left_to_right,
                    R.anim.right_to_left,
                    R.anim.exit_right_to_left
                )
            transaction.replace(R.id.splash_frame, SignActivity.fragment!!)
            transaction.addToBackStack(null)
            transaction.commit()
        })
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SignActivity).loginViewModel

    }
}