package com.example.a34c_liveapp.ui

import androidx.lifecycle.ViewModel
import com.example.a34c_liveapp.data.QuizRepository
import com.example.a34c_liveapp.data.model.Vip

class QuizViewModel : ViewModel() {

    private val repository = QuizRepository()

    private var vipList = repository.loadVips()

    private var index = 0

    private var _finished = false
    val finished: Boolean
        get() = _finished

    private var _score = 0
    val score: Int
        get() = _score

    private var _currentVip = vipList[index]
    val currentVip: Vip
        get() = _currentVip

    fun checkAnswer(clickedAnswer: Boolean) {

        if (clickedAnswer == currentVip.isMusician) {
            _score ++
        }

        if (index < vipList.size - 1) {
            index ++
        } else {
            _finished = true
        }

        _currentVip = vipList[index]
    }

    fun restartGame() {
        _score = 0
        index = 0
        _finished = false
        vipList = vipList.shuffled()
    }
}
