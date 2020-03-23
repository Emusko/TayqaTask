package com.example.tayqatask.presentation.splash

import android.content.Context
import com.example.tayqatask.di.base.BaseViewModel
import com.example.tayqatask.di.base.BaseViewModelInputs
import com.example.tayqatask.di.base.BaseViewModelOutputs
import com.example.tayqatask.data.model.GoalModel
import com.example.tayqatask.usecase.GetGoalsUseCase
import com.example.tayqatask.usecase.InsertGoalUseCase
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.CompletableSubject
import java.io.InputStream
import javax.inject.Inject

interface SplashViewModelInputs : BaseViewModelInputs {
    fun insertGoals()
}

interface SplashViewModelOutputs : BaseViewModelOutputs {
    fun onFetchCompleted(): CompletableSubject
}

class SplashViewModel @Inject constructor(
    private val insertGoalUseCase: InsertGoalUseCase,
    private val getGoalsUseCase: GetGoalsUseCase,
    private val context: Context,
    private val gson: Gson
) : BaseViewModel(), SplashViewModelInputs, SplashViewModelOutputs {
    override val inputs: SplashViewModelInputs = this
    override val outputs: SplashViewModelOutputs = this
    private val fetch = CompletableSubject.create()
    override fun insertGoals() {
        //Check local has data or not
        getGoalsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isEmpty()){
                    //Read json From file and parse to Array
                    val inputStream: InputStream = context.assets.open("data.json")
                    val size: Int = inputStream.available()
                    val buffer = ByteArray(size)
                    inputStream.read(buffer)
                    inputStream.close()
                    val goals= gson.fromJson(String(buffer, Charsets.UTF_8), Array<GoalModel>::class.java).toCollection(ArrayList())

                    //Insert goals to database with usecase
                    insertGoalUseCase.execute(goals)
                }
                fetch.onComplete()
            }, {

            }).addTo(subscriptions)

    }

    override fun onFetchCompleted() = fetch
}