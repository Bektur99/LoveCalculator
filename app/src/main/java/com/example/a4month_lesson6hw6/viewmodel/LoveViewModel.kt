package com.example.a4month_lesson6hw6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a4month_lesson6hw6.remote.LoveModel
import com.example.a4month_lesson6hw6.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}