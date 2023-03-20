package com.android.composeuidesigon.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.android.composeuidesigon.data.PersonInfo

class SharedViewModel : ViewModel() {

    /*
    *
    * Second approach viewModel  to send Parcelize data one screen to another
    * */
    var personInfo by mutableStateOf<PersonInfo?>(null)
        private set

    fun addPerson(newPersonInfo: PersonInfo) {
        personInfo = newPersonInfo
    }

}