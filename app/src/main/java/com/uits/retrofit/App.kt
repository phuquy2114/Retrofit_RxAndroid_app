package com.uits.retrofit

import android.app.Application
import com.uits.retrofit.service.body.APIClient

/**
 * TODO : Object
 * Copyright © 2020 UITS CO.,LTD
 * Created PHUQUY on 10/4/20.
 **/
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        APIClient().init()
    }
}