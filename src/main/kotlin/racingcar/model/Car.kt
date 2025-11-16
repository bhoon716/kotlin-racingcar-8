package racingcar.model

import racingcar.error.ErrorCode
import racingcar.model.strategy.MoveStrategy

class Car(name: String, private val moveStrategy: MoveStrategy) : Comparable<Car> {

    private val name: String
    private var position: Int = DEFAULT_POSITION

    companion object {
        const val DEFAULT_POSITION = 0
    }

    init {
        val trimmed = name.trim()
        validateName(trimmed)
        this.name = trimmed
    }

    private fun validateName(name: String) {
        val regex = "(^[a-zA-Z가-힣0-9]{1,5}$)".toRegex()
        if(!name.matches(regex)) {
            throw IllegalArgumentException(ErrorCode.INVALID_CAR_NAME.message())
        }
    }

    fun tryToMove() {
        if (moveStrategy.canMove()) {
            position++
        }
    }

    override fun compareTo(other: Car): Int {
        TODO("Not yet implemented")
    }
}
