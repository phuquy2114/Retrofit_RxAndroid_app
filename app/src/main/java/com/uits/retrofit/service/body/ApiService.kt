package com.uits.retrofit.service.body

import com.uits.retrofit.service.body.response.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * ApiService
 * Copyright © 2020 UITS CO.,LTD
 * Created PHUQUY on 10/4/20.
 **/
interface ApiService {

    @GET("weather")
    fun getWeather() : Observable<WeatherResponse>
}