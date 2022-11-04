package com.example.a34c_liveapp.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a34c_liveapp.data.QuizRepository
import com.example.a34c_liveapp.data.model.Vip

class QuizViewModel : ViewModel() {

    private val repository = QuizRepository()

    private var vipList = repository.loadVips()

    private var index = 0

    private val _finished = MutableLiveData<Boolean>(false)
    val finished: LiveData<Boolean>
        get() = _finished

    private val _score = MutableLiveData<Int>(0)
    val score: LiveData<Int>
        get() = _score

    private var _currentVip = MutableLiveData<Vip>(vipList[index])
    val currentVip: LiveData<Vip>
        get() = _currentVip

    fun checkAnswer(clickedAnswer: Boolean) {

        if (clickedAnswer == currentVip.value?.isMusician) {
            _score.value = _score.value?.plus(1)
        }

        if (index < vipList.size - 1) {
            index ++
        } else {
            _finished.value = true
        }

        _currentVip.value = vipList[index]
    }

    fun restartGame() {
        _score.value = 0
        index = 0
        _finished.value = false
        vipList = vipList.shuffled()
    }
}
