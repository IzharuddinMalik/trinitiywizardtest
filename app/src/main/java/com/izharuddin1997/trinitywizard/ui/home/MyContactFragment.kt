package com.izharuddin1997.trinitywizard.ui.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.izharuddin1997.trinitywizard.core.base.BaseFragment
import com.izharuddin1997.trinitywizard.databinding.FragmentMycontactBinding
import com.izharuddin1997.trinitywizard.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyContactFragment :
    BaseFragment<FragmentMycontactBinding>(FragmentMycontactBinding::inflate) {

    private val viewModel: MyContactViewModel by viewModels()

    override fun onCreated() {
        viewModel.getContactList()
        initComponent()
        observer()
    }

    private fun initComponent() {

    }

    private fun observer() {
        observe(viewModel.listContactResp) {
            binding.rvListMyContact.apply {
                this.layoutManager = LinearLayoutManager(requireActivity())
                this.adapter
            }
        }
    }
}
