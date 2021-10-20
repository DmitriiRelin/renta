package com.example.renta.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.renta.domain.uc.GetUsersListUseCase
import javax.inject.Inject

class HomeViewModel(private val getUserListUseCase: GetUsersListUseCase) : ViewModel() {


}


@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory @Inject constructor(val getUserListUseCase: GetUsersListUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetUsersListUseCase::class.java)
            .newInstance(getUserListUseCase)
    }
}
