package com.example.renta.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.renta.LoadingResult
import com.example.renta.domain.entites.User
import com.example.renta.domain.uc.GetUsersListUseCase
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getUserListUseCase: GetUsersListUseCase) :
    ViewModel() {


    fun getUserList(): Observable<LoadingResult<List<User>>> {
        return getUserListUseCase.getUserList()
    }

}


@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory @Inject constructor(private val getUserListUseCase: GetUsersListUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetUsersListUseCase::class.java)
            .newInstance(getUserListUseCase)
    }
}
