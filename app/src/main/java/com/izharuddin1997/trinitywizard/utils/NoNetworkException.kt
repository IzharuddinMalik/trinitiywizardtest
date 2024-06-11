package com.izharuddin1997.trinitywizard.utils

import java.io.IOException

class NoNetworkException : IOException() {
    override val message: String
        get() = "No Internet Connection"
}