package com.android.composeuidesigon.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PersonInfo(
    val name: String? = null,
    val phone: Long? = null,
    val email: String? = null
) : Parcelable
