package com.zeller.eventlossdemo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var events = MutableLiveData<Int>()

    fun triggerPostValue() {
        repeat(10) {
            events.postValue(it)
        }
    }

    fun triggerSetValue() {
        repeat(10) {
            events.value = it
        }
    }

}