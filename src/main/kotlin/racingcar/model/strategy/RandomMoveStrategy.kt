package racingcar.model.strategy

import camp.nextstep.edu.missionutils.Randoms

class RandomMoveStrategy : MoveStrategy {

    override fun canMove(): Boolean {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= RANDOM_MOVE_THRESHOLD
    }

    private companion object CONSTANT {
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 9
        private const val RANDOM_MOVE_THRESHOLD = 4
    }
}
