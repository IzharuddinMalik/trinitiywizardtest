package com.izharuddin1997.trinitywizard.data.source.remote.service

import com.izharuddin1997.trinitywizard.data.domain.MyContactResponse
import retrofit2.http.POST

interface MyContactService {

    @POST("auth/login")
    suspend fun getContact(): List<MyContactResponse>

}
