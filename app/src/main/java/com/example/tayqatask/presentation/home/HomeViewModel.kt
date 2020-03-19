package com.example.tayqatask.presentation.home

import android.util.Log
import com.example.tayqatask.di.base.BaseViewModel
import com.example.tayqatask.di.base.BaseViewModelInputs
import com.example.tayqatask.di.base.BaseViewModelOutputs
import com.example.tayqatask.network.model.GoalModel
import com.example.tayqatask.usecase.GetGoalsUseCase
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

interface HomeViewModelInputs: BaseViewModelInputs{
    fun getGoals()
}
interface HomeViewModelOutputs: BaseViewModelOutputs{
    fun onGoals(): PublishSubject<List<GoalModel>>
}
class HomeViewModel @Inject constructor(
    private val getGoalsUseCase: GetGoalsUseCase
): BaseViewModel(), HomeViewModelInputs, HomeViewModelOutputs{
    override val inputs: HomeViewModelInputs = this

    override val outputs: HomeViewModelOutputs = this
    private val goals = PublishSubject.create<List<GoalModel>>()
    override fun getGoals() {
        getGoalsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                goals.onNext(it)
            }, {

            }).addTo(subscriptions)
    }

    override fun onGoals() = goals
}