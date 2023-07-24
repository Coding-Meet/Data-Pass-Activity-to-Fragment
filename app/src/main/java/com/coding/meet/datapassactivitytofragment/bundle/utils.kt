package com.coding.meet.datapassactivitytofragment.bundle

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable


fun <T : Serializable> Bundle.getSerializableCompat(key:String, clazz: Class<T>): T{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getSerializable(key,clazz)!!
    }else{
        getSerializable(key)!! as T
    }
}

fun <T : Parcelable> Bundle.getParcelableCompat(key:String, clazz: Class<T>): T{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key,clazz)!!
    }else{
        getParcelable(key)!!
    }
}