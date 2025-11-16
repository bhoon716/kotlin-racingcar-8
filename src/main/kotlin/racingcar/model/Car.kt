package racingcar.model

import racingcar.model.strategy.MoveStrategy

class Car(private val name: String, private val moveStrategy: MoveStrategy) : Comparable<Car> {

    companion object {
        const val DEFAULT_POSITION = 0
    }

    private var position: Int = DEFAULT_POSITION

    fun tryToMove() {
        if (moveStrategy.canMove()) {
            position++
        }
    }

    override fun compareTo(other: Car): Int {
        TODO("Not yet implemented")
    }
}
