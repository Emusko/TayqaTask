package com.example.tayqatask.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass
//ViewModelKey annotation for viewModelFactory
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)