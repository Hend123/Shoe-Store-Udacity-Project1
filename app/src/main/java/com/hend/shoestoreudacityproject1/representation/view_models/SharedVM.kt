package com.hend.shoestoreudacityproject1.representation.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hend.shoestoreudacityproject1.models.Shoe

class SharedVM : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: MutableLiveData<MutableList<Shoe>> get() = _shoeList
    val shoe = MutableLiveData(Shoe())
    fun setShoe() {
        Log.d("testvm"," shoe = $shoe.toString()")
             _shoeList.value?.add(Shoe(shoe.value!!.name,shoe.value!!.size,
                 shoe.value!!.company,
                 shoe.value!!.description))

        Log.d("testvm", this.shoeList.value.toString())
    }

}