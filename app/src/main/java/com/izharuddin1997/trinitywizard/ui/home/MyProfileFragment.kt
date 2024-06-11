package com.izharuddin1997.trinitywizard.ui.home

import com.izharuddin1997.trinitywizard.core.base.BaseFragment
import com.izharuddin1997.trinitywizard.databinding.FragmentMyprofileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyProfileFragment :
    BaseFragment<FragmentMyprofileBinding>(FragmentMyprofileBinding::inflate) {

    override fun onCreated() {
        initComponent()
        observer()
    }

    private fun initComponent() {

    }

    private fun observer() {

    }
}