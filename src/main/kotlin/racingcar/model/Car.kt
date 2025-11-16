package racingcar.model

import racingcar.error.ErrorCode
import racingcar.model.dto.CarSnapshot
import racingcar.model.strategy.MoveStrategy

class Car(name: String, private val moveStrategy: MoveStrategy) : Comparable<Car> {

    val name: String
    private var position: Int = DEFAULT_POSITION

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

    fun record(): CarSnapshot {
        return CarSnapshot(name, position)
    }

    override fun compareTo(other: Car): Int {
        return this.position.compareTo(other.position)
    }

    private companion object CONSTANT {
        private const val DEFAULT_POSITION = 0
    }
}
