package com.izharuddin1997.trinitywizard.data.repository.interfaces

import com.izharuddin1997.trinitywizard.data.domain.MyContactResponse
import com.izharuddin1997.trinitywizard.data.source.remote.service.Result
import kotlinx.coroutines.flow.Flow

interface MyContactRepository {

    fun getContact(): Flow<Result<List<MyContactResponse>>>
}
