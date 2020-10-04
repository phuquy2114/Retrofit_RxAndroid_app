package com.uits.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.uits.retrofit.service.body.APIClient
import com.uits.retrofit.service.body.response.WeatherResponse
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    @SuppressLint("CheckResult")
    fun init() {
        var response: Observable<WeatherResponse> = APIClient.APIClient.mApiService.getWeather()
        response.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({response -> {
            onSuccess(response)
        }}, {t -> {
            onFail(t)
        } })
    }

    fun onSuccess(response: WeatherResponse) {
            print(response)
    }

    fun onFail(t: Throwable) {
        print(t.message)
    }
}