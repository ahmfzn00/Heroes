package com.codenesia.myheroes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPahlawan(
    val nama: String,
    val deskripsi: String
) : Parcelable
