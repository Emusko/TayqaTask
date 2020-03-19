package com.example.tayqatask.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.tayqatask.R
import com.example.tayqatask.di.base.BaseApplication
import com.example.tayqatask.di.factory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =
            ViewModelProvider(this, factory)[MainViewModel::class.java]
        Log.i("ViewModelMessage", viewModel.getTest())
    }
}
