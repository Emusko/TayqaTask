package com.example.tayqatask.presentation.splash

import android.content.Context
import android.util.Log
import com.example.tayqatask.di.base.BaseViewModel
import com.example.tayqatask.di.base.BaseViewModelInputs
import com.example.tayqatask.di.base.BaseViewModelOutputs
import com.example.tayqatask.network.model.GoalModel
import com.example.tayqatask.usecase.InsertGoalUseCase
import com.google.gson.Gson
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

interface SplashViewModelInputs : BaseViewModelInputs {
    fun insertGoals()
}

interface SplashViewModelOutputs : BaseViewModelOutputs {

}

class SplashViewModel @Inject constructor(
    private val insertGoalUseCase: InsertGoalUseCase,
    private val context: Context,
    private val gson: Gson
) : BaseViewModel(), SplashViewModelInputs, SplashViewModelOutputs {
    override val inputs: SplashViewModelInputs = this
    override val outputs: SplashViewModelOutputs = this
    override fun insertGoals() {
        val inputStream: InputStream = context.assets.open("data.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val goals= gson.fromJson(String(buffer, Charsets.UTF_8), Array<GoalModel>::class.java).toCollection(ArrayList())
        insertGoalUseCase.execute(goals)
    }
}