package com.example.tayqatask.presentation.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.tayqatask.R
import com.example.tayqatask.di.base.BaseActivity
import com.example.tayqatask.di.factory.ViewModelProviderFactory
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: HomeViewModel
    lateinit var adapter: HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel =
            ViewModelProvider(this, factory)[HomeViewModel::class.java]
        attachManager()
        setOutputListeners()
        setInputListeners()
    }

    private fun setInputListeners() {
        //We have not any input operation from HomeActivity yet
    }

    private fun attachManager() {
        recyclerView.layoutManager = viewModel.getLinearLayoutManager(this)
    }
    private fun setOutputListeners() {
        viewModel.outputs.onGoals().subscribe {
            recyclerView.adapter = viewModel.homeAdapter
        }.addTo(subscriptions)
    }

    override fun onDestroy() {
        super.onDestroy()
        val list = viewModel.goalList
    }
}
