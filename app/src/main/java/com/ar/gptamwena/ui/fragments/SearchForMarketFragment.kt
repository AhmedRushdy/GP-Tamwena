package com.ar.gptamwena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.graduationproject.paginationtest.ui.MainActivity2
import com.graduationproject.paginationtest.ui.SharedViewModel

class SearchForMarketFragment : Fragment() {
    lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(),"gallery",Toast.LENGTH_SHORT).show()
        val root = inflater.inflate(R.layout.fragment_searching_for_market, container, false)
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity2).viewModel

    }
}