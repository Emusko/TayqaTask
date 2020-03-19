package com.example.tayqatask.di.base

import androidx.lifecycle.ViewModel
import io.reactivex.Observable

interface BaseViewModelInputs {
}

interface BaseViewModelOutputs {
}

open class BaseViewModel : ViewModel(), BaseViewModelInputs, BaseViewModelOutputs{
    open val inputs: BaseViewModelInputs
        get() = this

    open val outputs: BaseViewModelOutputs
        get() = this

}