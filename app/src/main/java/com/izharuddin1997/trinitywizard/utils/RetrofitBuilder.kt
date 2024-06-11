package com.izharuddin1997.trinitywizard.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.GsonBuilder
import com.izharuddin1997.trinitywizard.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

object RetrofitBuilder {
    fun <T> build(
        context: Context,
        type: Class<T>,
    ): T {
        val chuckInterceptor = ChuckerInterceptor.Builder(context).build()

        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor())
            .addInterceptor(chuckInterceptor)
            .addInterceptor(networkInterceptor(context))

        val client = clientBuilder.build()

        val gsonFactory = GsonConverterFactory.create(
            GsonBuilder().serializeNulls().create()
        )
        val retrofit = Retrofit.Builder()
            .baseUrl("https://steraco.my.id/bebasinasa/")
            .addConverterFactory(gsonFactory)
            .client(client)
            .build()
        return retrofit.create(type)
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun showMessageAndLogout(context: Context) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(
                context,
                R.string.message_unauthorized,
                Toast.LENGTH_LONG
            ).show()
            context.restartApp()
        }
    }

    private fun networkInterceptor(context: Context): Interceptor {
        val networkMonitor = ConnectionObserver(context)
        return Interceptor { chain ->
            if (networkMonitor.isConnected) {
                return@Interceptor chain.proceed(chain.request())
            } else {
                throw NoNetworkException()
            }
        }
    }

}