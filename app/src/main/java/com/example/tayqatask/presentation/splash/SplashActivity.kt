package com.example.tayqatask.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.example.tayqatask.R
import com.example.tayqatask.di.base.BaseActivity
import com.example.tayqatask.di.factory.ViewModelProviderFactory
import com.example.tayqatask.presentation.home.HomeActivity
import io.reactivex.rxkotlin.addTo
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
        setOutputListeners()
        setInputListeners()

    }

    private fun setInputListeners() {
        //Assume fetch goals from server as we did it in viewModel
        viewModel.inputs.insertGoals()
    }

    private fun setOutputListeners() {
        //Listen to fetching data. If completed open HomeActivity
        viewModel.outputs.onFetchCompleted().subscribe {
            Handler().postDelayed({
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }, 5000)
        }.addTo(subscriptions)
    }
}
