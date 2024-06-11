package com.izharuddin1997.trinitywizard.ui.home

import androidx.lifecycle.viewModelScope
import com.izharuddin1997.trinitywizard.core.base.BaseViewModel
import com.izharuddin1997.trinitywizard.data.domain.MyContactResponse
import com.izharuddin1997.trinitywizard.data.repository.interfaces.MyContactRepository
import com.izharuddin1997.trinitywizard.data.source.remote.service.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyContactViewModel @Inject constructor(
    private val myContactRepository: MyContactRepository
): BaseViewModel() {

    private val _listContactResp = MutableStateFlow<List<MyContactResponse>?>(emptyList())
    var listContactResp: StateFlow<List<MyContactResponse>?> = _listContactResp

    private val _error = MutableStateFlow("")
    var error: StateFlow<String> = _error

    fun getContactList() {
        viewModelScope.launch {
            myContactRepository.getContact()
                .onStart { showTransparentLoading() }
                .onCompletion { dismissTransparentLoading() }
                .collect{ result ->
                    when(result) {
                        is Result.Success -> {
                            _listContactResp.value = result.data
                        }

                        is Result.Error -> {
                            _error.value = result.getErrorMessage.orEmpty()
                        }
                    }
                }
        }
    }
}