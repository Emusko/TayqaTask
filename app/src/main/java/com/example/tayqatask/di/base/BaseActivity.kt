package com.example.tayqatask.di.base

import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable

open class BaseActivity: DaggerAppCompatActivity(){
    val subscriptions = CompositeDisposable()
}