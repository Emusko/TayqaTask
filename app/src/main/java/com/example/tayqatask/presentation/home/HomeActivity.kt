package com.example.tayqatask.presentation.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tayqatask.R
import com.example.tayqatask.di.base.BaseActivity
import com.example.tayqatask.di.factory.ViewModelProviderFactory
import com.example.tayqatask.network.database.ApplicationDatabase
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: HomeViewModel
    lateinit var linearLayoutManager : LinearLayoutManager
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

    private fun attachManager() {
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = linearLayoutManager
    }

    private fun setInputListeners() {
        viewModel.inputs.getGoals()
    }

    private fun setOutputListeners() {
        viewModel.outputs.onGoals().subscribe {
            adapter = HomeAdapter(it.toMutableList()){ position ->
                adapter.swapItems(position)
            }
            recyclerView.adapter = adapter
        }.addTo(subscriptions)
    }
}
