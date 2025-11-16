package racingcar.model.strategy

@FunctionalInterface
fun interface MoveStrategy {

    fun canMove(): Boolean
}
