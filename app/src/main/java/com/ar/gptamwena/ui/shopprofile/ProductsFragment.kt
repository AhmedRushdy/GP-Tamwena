package com.ar.gptamwena.ui.shopprofile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ar.gptamwena.adapters.ProductsAdapter
import com.ar.gptamwena.databinding.FragmentProductBinding
import com.ar.gptamwena.models.SellerModel
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ProductsFragment : Fragment() {

    lateinit var binding: FragmentProductBinding

    private lateinit var seller: SellerModel
    var totalPrice: Int = 0
    lateinit var oilAdapter: ProductsAdapter
    lateinit var sugarAdapter: ProductsAdapter
    lateinit var riceAdapter: ProductsAdapter
    lateinit var pastaAdapter: ProductsAdapter
    lateinit var otherAdapter: ProductsAdapter

    lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        seller = (activity as ShopProfileActivity).sellerObject
        viewModel = (activity as ShopProfileActivity).viewModel

        viewModel.getProducts(seller.licenceNumber, "oil")
        viewModel.getProducts(seller.licenceNumber, "sugar")
        viewModel.getProducts(seller.licenceNumber, "rice")
        viewModel.getProducts(seller.licenceNumber, "pasta")
        viewModel.getProducts(seller.licenceNumber, "others")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(layoutInflater, container, false)

        initRV()
        var job: Job? = null

        job?.cancel()
        job = MainScope().launch {
            delay(1500)

            oilAdapter.differ.submitList(viewModel.oilList)
            sugarAdapter.differ.submitList(viewModel.sugarList)
            riceAdapter.differ.submitList(viewModel.riceList)
            pastaAdapter.differ.submitList(viewModel.pastaList)
            otherAdapter.differ.submitList(viewModel.othersList)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oilAdapter.setOnItemClickListener {
            viewModel.addToCart(it)
            totalPrice += it.price.toInt()
            updateTV()
        }
        sugarAdapter.setOnItemClickListener {
            viewModel.addToCart(it)
            totalPrice += it.price.toInt()
            updateTV()
        }
        riceAdapter.setOnItemClickListener {
            viewModel.addToCart(it)
            totalPrice += it.price.toInt()
            updateTV()

        }
        pastaAdapter.setOnItemClickListener {
            viewModel.addToCart(it)
            totalPrice += it.price.toInt()
            updateTV()
        }

        binding.btnCstAddToCart.setOnClickListener {
            viewModel.writeProductList((activity as ShopProfileActivity).customerModel.cardNumber)
            val i = Intent(requireActivity(), BuyProcessActivity::class.java)
            i.putExtra("customerlic",(activity as ShopProfileActivity).customerModel)
            i.putExtra("seller",seller)
            startActivity(i)
        }

    }

    private fun updateTV() {
        binding.btnCstAddToCart.text = " اجمالى المشتريات ${totalPrice}"
    }

    private fun initRV() {
        oilAdapter = ProductsAdapter()
        sugarAdapter = ProductsAdapter()
        pastaAdapter = ProductsAdapter()
        riceAdapter = ProductsAdapter()
        otherAdapter = ProductsAdapter()

        binding.apply {
            recyclerViewOilCategory.adapter = oilAdapter
            //recyclerViewOtherCategory.adapter = otherAdapter
            recyclerViewPastaCategory.adapter = pastaAdapter
            recyclerViewRiceCategory.adapter = riceAdapter
            recyclerViewSugarCategory.adapter = sugarAdapter
            recyclerViewOtherCategory.adapter = otherAdapter

            recyclerViewOilCategory.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
//            recyclerViewOtherCategory.layoutManager =
//                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
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

