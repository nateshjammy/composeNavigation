package com.android.composeuidesigon.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PersonInfo(
    val name: String,
    val phone: Long,
    val email: String
) : Parcelable
