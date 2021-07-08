package com.ar.gptamwena.ui.fragments

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CustomerMainProductsAdapter
import com.ar.gptamwena.adapters.CustomerMainShopsAdapter
import com.ar.gptamwena.adapters.ProductsAdapter
import com.ar.gptamwena.databinding.FragmentHomeBinding
import com.ar.gptamwena.models.CustomerModel
import com.ar.gptamwena.models.ProductModel
import com.ar.gptamwena.models.SellerModel
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel
import com.ar.gptamwena.ui.shopprofile.ShopProfileActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    lateinit var binding: FragmentHomeBinding
    lateinit var sellerAdapter: CustomerMainShopsAdapter
    lateinit var sellerList: MutableList<SellerModel>
    lateinit var customerModel: CustomerModel
    lateinit var sugList: MutableList<ProductModel>
    lateinit var adapter: ProductsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = (activity as DrawerActivity).viewModel
        initRecyclerView()

        val imageUri = "drawable://"
        sugList = mutableListOf()
        sugList.add(ProductModel("10", "زيت عافية", "https://www.alaseel.nl/image/cache/catalog/products/afia%202l-500x500.png", "21", "20"))
        sugList.add(ProductModel("14", "سكر الاسرة", "https://images.yaoota.com/Ll5r9Zutas-vVgY8sq9BrUHcy4M=/trim/yaootaweb-production/media/crawledproductimages/02fcab0ee8b04e1ee6afb3a0032ff707a8cef5d2.jpg", "18", "20"))
        sugList.add(ProductModel("17", "شاى العروسة", "https://www.elsupplier.com/productThumbnailImage/southsinai18.gif", "5", "20"))
        sugList.add(ProductModel("13", "رز الضحى", "https://cf1.s3.souqcdn.com/item/2017/01/05/12/12/46/17/item_L_12124617_18307440.jpg", "16", "20"))
        adapter.differ.submitList(sugList)
        binding.btnCstMainShowAll.setOnClickListener(
            View.OnClickListener {
                findNavController().navigate(R.id.action_nav_home_to_near_shops)

            })
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        binding.txtCstMainDate.text = currentDate

        sellerAdapter.setOnItemClickListener {
            val i = Intent(requireActivity(), ShopProfileActivity::class.java)
            i.putExtra("seller_object", it)
            i.putExtra("customerObject", (activity as DrawerActivity).customerObject)
            startActivity(i)
        }
        var job: Job? = null

        job?.cancel()
        job = MainScope().launch {
            delay(1500)
            sellerAdapter.differ.submitList(sharedViewModel.sellerList)

        }


    }

    private fun initRecyclerView() {
        adapter = ProductsAdapter()
        sellerAdapter = CustomerMainShopsAdapter()
        binding.rvCstMainCategories.adapter = adapter
        binding.rvCstMainCategories.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.rvCstMainShops.adapter = sellerAdapter

        binding.rvCstMainShops.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvCstMainBought.adapter = CustomerMainProductsAdapter()
        binding.rvCstMainBought.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

    }
}