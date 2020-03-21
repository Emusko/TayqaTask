package com.example.tayqatask.di.base

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

interface BaseViewModelInputs {
}

interface BaseViewModelOutputs {
}
//Every viewModel in this application should extend Base and implement inputs, outputs
//This will give the developer right navigation to see project life cycle
open class BaseViewModel : ViewModel(), BaseViewModelInputs, BaseViewModelOutputs{
    open val inputs: BaseViewModelInputs
        get() = this

    open val outputs: BaseViewModelOutputs
        get() = this
    protected val subscriptions = CompositeDisposable()
}