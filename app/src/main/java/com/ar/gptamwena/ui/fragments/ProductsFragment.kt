package com.ar.gptamwena.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ar.gptamwena.adapters.ProductsAdapter
import com.ar.gptamwena.databinding.FragmentProductBinding
import com.ar.gptamwena.models.ProductModel
import com.ar.gptamwena.models.SellerModel
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ProductsFragment : Fragment() {

    lateinit var binding: FragmentProductBinding


    private val args: ProductsFragmentArgs by navArgs()

    private lateinit var seller: SellerModel

    lateinit var oilAdapter: ProductsAdapter
    lateinit var sugarAdapter: ProductsAdapter
    lateinit var riceAdapter: ProductsAdapter
    lateinit var pastaAdapter: ProductsAdapter
    lateinit var otherAdapter: ProductsAdapter

    lateinit var viewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(layoutInflater, container, false)

        // productsFragmentRV?.adapter = ParentAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seller = args.sellerObject
        viewModel = (activity as DrawerActivity).viewModel

        viewModel.getProducts(seller.licenceNumber, "oil")
        viewModel.getProducts(seller.licenceNumber, "sugar")
        viewModel.getProducts(seller.licenceNumber, "rice")
        viewModel.getProducts(seller.licenceNumber, "pasta")
        initRV()
        var job: Job? = null

        job?.cancel()
        job = MainScope().launch {
            delay(1500)

            oilAdapter.differ.submitList(viewModel.oilList)
            sugarAdapter.differ.submitList(viewModel.sugarList)
            riceAdapter.differ.submitList(viewModel.riceList)
            pastaAdapter.differ.submitList(viewModel.pastaList)
        }

}

private fun initRV() {
    oilAdapter = ProductsAdapter()
    sugarAdapter = ProductsAdapter()
    pastaAdapter = ProductsAdapter()
    riceAdapter = ProductsAdapter()
//        otherAdapter = ProductsAdapter()

    binding.apply {
        recyclerViewOilCategory.adapter = oilAdapter
        //recyclerViewOtherCategory.adapter = otherAdapter
        recyclerViewPastaCategory.adapter = pastaAdapter
        recyclerViewRiceCategory.adapter = riceAdapter
        recyclerViewSugarCategory.adapter = sugarAdapter

        recyclerViewOilCategory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
        recyclerViewOtherCategory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
        recyclerViewPastaCategory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
        recyclerViewRiceCategory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
        recyclerViewSugarCategory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)


    }

}

}

