package racingcar.model

import racingcar.error.ErrorCode
import racingcar.model.dto.CarRecord

class Participants(private val participants: List<Car>) {

    init {
        validate(participants)
    }

    private fun validate(participants: List<Car>) {
        val names = participants.map { it.name }
        if (names.toSet().size != participants.size) {
            throw IllegalArgumentException(ErrorCode.DUPLICATED_CAR_NAME.message())
        }
    }

    fun tryToMoveAll() {
        participants.forEach(Car::tryToMove)
    }

    fun records(): List<CarRecord> {
        return participants
            .stream()
            .map(Car::record)
            .toList()
    }
}
