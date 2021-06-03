package com.ar.gptamwena.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ar.gptamwena.R
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel

class SearchForMarketFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(),"gallery",Toast.LENGTH_SHORT).show()
        val root = inflater.inflate(R.layout.fragment_near_shops, container, false)
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = (activity as DrawerActivity).viewModel

    }
}