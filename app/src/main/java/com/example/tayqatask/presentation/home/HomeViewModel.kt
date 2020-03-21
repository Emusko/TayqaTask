package com.example.tayqatask.presentation.home

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tayqatask.di.base.BaseViewModel
import com.example.tayqatask.di.base.BaseViewModelInputs
import com.example.tayqatask.di.base.BaseViewModelOutputs
import com.example.tayqatask.data.model.GoalModel
import com.example.tayqatask.usecase.GetGoalsUseCase
import com.example.tayqatask.usecase.UpdateGoalUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.CompletableSubject
import javax.inject.Inject

interface HomeViewModelInputs: BaseViewModelInputs{
}
interface HomeViewModelOutputs: BaseViewModelOutputs{
    fun onGoals(): CompletableSubject
}
class HomeViewModel @Inject constructor(
    private val getGoalsUseCase: GetGoalsUseCase,
    private val updateGoalUseCase: UpdateGoalUseCase
): BaseViewModel(), HomeViewModelInputs, HomeViewModelOutputs{
    override val inputs: HomeViewModelInputs = this

    override val outputs: HomeViewModelOutputs = this
    private val goals = CompletableSubject.create()
    val goalList = mutableListOf<GoalModel>()
    val homeAdapter: HomeAdapter = HomeAdapter(goalList){
        updateGoal(it)
    }
    init {

        getGoalsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                goals.onComplete()
                goalList.addAll(it.toMutableList())
            }, {

            }).addTo(subscriptions)
    }

    private fun updateGoal(goal: GoalModel) {
        updateGoalUseCase.execute(goal)
    }
    fun getLinearLayoutManager(context: Context): LinearLayoutManager{
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        return linearLayoutManager
    }

    override fun onGoals() = goals
}