package com.example.tayqatask.main

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(

) : ViewModel(){
    fun getTest() = "TEST"
}