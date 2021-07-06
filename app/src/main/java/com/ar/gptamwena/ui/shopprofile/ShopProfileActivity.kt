package com.ar.gptamwena.ui.shopprofile

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.ActivityShopProfileBinding
import com.ar.gptamwena.models.CustomerModel
import com.ar.gptamwena.models.SellerModel
import com.ar.gptamwena.ui.SharedViewModel
import com.ar.gptamwena.ui.SharedViewModelProvider
import com.ar.gptamwena.ui.fragments.AboutUsFragment
import com.ar.gptamwena.ui.fragments.ContactUsFragment
import com.ar.gptamwena.ui.fragments.RateUS
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout

class ShopProfileActivity : AppCompatActivity() {
    lateinit var sellerObject:SellerModel
    lateinit var viewModel : SharedViewModel
    lateinit var binding : ActivityShopProfileBinding
    lateinit var customerModel: CustomerModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        setupViewPager(viewPager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        sellerObject = intent?.getSerializableExtra("seller_object") as SellerModel
        customerModel = intent?.getSerializableExtra("customerObject") as CustomerModel
        binding.txtCstShopProfileName.text = sellerObject.marketName
        Glide.with(this).load(sellerObject.image).centerCrop()
            .into(binding.shopIv)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(AboutUsFragment(), "البيانات")
        adapter.addFragment(ProductsFragment(), "المنتجات")
        adapter.addFragment(RateUS(), "تقييم")
        adapter.addFragment(ContactUsFragment(), "ارسل رساله")


        viewPager.adapter = adapter
        viewPager.currentItem=3
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[3-position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[3-position]
        }
    }
    private fun initViewModel(){
        var loginViewModelProvider = SharedViewModelProvider()
        viewModel = ViewModelProvider(this,loginViewModelProvider).get(SharedViewModel::class.java)
    }
}
