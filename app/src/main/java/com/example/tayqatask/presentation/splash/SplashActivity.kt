package com.example.tayqatask.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.example.tayqatask.R
import com.example.tayqatask.di.base.BaseActivity
import com.example.tayqatask.di.factory.ViewModelProviderFactory
import com.example.tayqatask.network.database.ApplicationDatabase
import com.example.tayqatask.network.model.GoalModel
import com.example.tayqatask.presentation.home.HomeActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =
            ViewModelProvider(this, factory)[SplashViewModel::class.java]
        viewModel.inputs.insertGoals()
        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 5000)
    }
}
