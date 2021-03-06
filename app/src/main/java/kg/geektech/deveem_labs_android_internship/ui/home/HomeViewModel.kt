package kg.geektech.deveem_labs_android_internship.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.geektech.deveem_labs_android_internship.Constants
import kg.geektech.deveem_labs_android_internship.ui.Item

class HomeViewModel : ViewModel() {
    var listItem = MutableLiveData<MutableList<Item>>()

    private  var list: MutableList<Item> = mutableListOf<Item>()

    fun init(){
        list.addAll(Constants.getData())
        listItem.value=list
        Log.e("TAG", "init: $list" )
    }




}