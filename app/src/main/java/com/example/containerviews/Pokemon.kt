package com.example.containerviews

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon (var name : String,
                    var type : String,
                    var signatureMove : String) :Parcelable