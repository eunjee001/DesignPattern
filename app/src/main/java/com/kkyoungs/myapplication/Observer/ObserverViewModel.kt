package com.kkyoungs.myapplication.Observer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ObserverViewModel : ViewModel(){
    var liveData :MutableLiveData<String> = MutableLiveData<String>()
}