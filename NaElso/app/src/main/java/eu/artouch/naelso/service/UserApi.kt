package eu.artouch.naelso.service

import eu.artouch.naelso.model.UserWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi{
    @GET("api/")
    fun getUsers(@Query("results") count : Int): Observable<UserWrapper>
}