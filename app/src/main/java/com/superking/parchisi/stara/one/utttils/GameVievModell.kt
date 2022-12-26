package com.superking.parchisi.stara.one.utttils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameVievModell : ViewModel() {

    companion object {
        const val VIN = 11
        const val LOSE = 33
    }

    private var _currentMode = MutableLiveData<GameVariant>()
    val currentMode: LiveData<GameVariant>
        get() = _currentMode

    private var _vinOrLose = MutableLiveData<Int>()
    val vinOrLose: LiveData<Int>
        get() = _vinOrLose


    init {

        _vinOrLose.value = LOSE
        _currentMode.value = GameVariant.One()
    }

    fun launchGameVariant1(){
        Log.d("lolo", "vieModel fun launchGameVariant1")
        _currentMode.value = GameVariant.One()
    }

     fun launchGameVariant2(){
         Log.d("lolo", "vieModel fun launchGameVariant2")
        _currentMode.value = GameVariant.Tvo()
    }

     fun launchGameVariant3(){
         Log.d("lolo", "vieModel fun launchGameVariant3")
        _currentMode.value = GameVariant.Three()
    }

     fun launchGameVariant4(){
         Log.d("lolo", "vieModel fun launchGameVariant4")
        _currentMode.value = GameVariant.Four()
    }

     fun launchGameVariant5(){
         Log.d("lolo", "vieModel fun launchGameVariant5")
        _currentMode.value = GameVariant.Five()
    }

     fun launchGameVariant6(){
         Log.d("lolo", "vieModel fun launchGameVariant6")
        _currentMode.value = GameVariant.Six()
    }

    fun userVin(){
        _vinOrLose.value = VIN
    }
    fun userLose(){
        _vinOrLose.value = LOSE
    }

    fun checkSavedGame(savedGameVar:Int){
        when(savedGameVar){
            1->{
                _currentMode.value = GameVariant.One()
            }
            2->{
                _currentMode.value = GameVariant.Tvo()
            }
            3->{
                _currentMode.value = GameVariant.Three()
            }
            4->{
                _currentMode.value = GameVariant.Four()
            }
            5->{
                _currentMode.value = GameVariant.Five()
            }
            6->{
                _currentMode.value = GameVariant.Six()
            }
        }

    }


}
