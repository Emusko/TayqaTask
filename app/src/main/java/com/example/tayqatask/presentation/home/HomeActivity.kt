package com.example.tayqatask.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tayqatask.R
import com.example.tayqatask.di.base.BaseActivity
import com.example.tayqatask.di.factory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
