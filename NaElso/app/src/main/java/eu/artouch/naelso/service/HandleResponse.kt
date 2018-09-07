package eu.artouch.naelso.service

interface HandleResponse<in T> {
    fun onResponse(response: T)
    fun onError(error: Throwable)
}