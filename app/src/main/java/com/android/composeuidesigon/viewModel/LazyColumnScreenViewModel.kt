package com.android.composeuidesigon.viewModel

import androidx.lifecycle.ViewModel
import com.android.composeuidesigon.data.PersonInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LazyColumnScreenViewModel : ViewModel() {


    private val _PersonInfoData = MutableStateFlow<List<PersonInfo>>(emptyList())

    val personInfoData: StateFlow<List<PersonInfo>> get() = _PersonInfoData

     fun loadData() {

        val data = listOf(
            PersonInfo("John", 124556, "john@gmail.com"),
            PersonInfo("Adams", 124556, "Adams@gmail.com"),
            PersonInfo("msd", 124556, "msd@gmail.com"),
            PersonInfo("sachin", 124556, "sachin@gmail.com"),
            PersonInfo("Kolhi", 124556, "Kolhi@gmail.com"),
            PersonInfo("rohit", 124556, "rohit@gmail.com"),
            PersonInfo("pant", 124556, "pant@gmail.com"),
            PersonInfo("benstokes", 124556, "benstokes@gmail.com")
        )
        _PersonInfoData.tryEmit(data)


    }


}