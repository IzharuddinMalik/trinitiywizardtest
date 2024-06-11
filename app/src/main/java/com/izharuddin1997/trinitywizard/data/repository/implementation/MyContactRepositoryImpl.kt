package com.izharuddin1997.trinitywizard.data.repository.implementation

import com.izharuddin1997.trinitywizard.data.domain.MyContactResponse
import com.izharuddin1997.trinitywizard.data.repository.interfaces.MyContactRepository
import com.izharuddin1997.trinitywizard.data.source.remote.service.MyContactService
import com.izharuddin1997.trinitywizard.data.source.remote.service.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MyContactRepositoryImpl(
    private val authService: MyContactService,
) : MyContactRepository {
    override fun getContact(): Flow<Result<List<MyContactResponse>>> = flow {
        val response = authService.getContact()
        emit(Result.createSuccess(data = response))
    }.catch { error ->
        emit(
            Result.createError(
                label = "getContact",
                error = error
            )
        )
    }
}