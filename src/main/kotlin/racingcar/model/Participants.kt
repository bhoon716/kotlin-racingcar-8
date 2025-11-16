package racingcar.model

import racingcar.error.ErrorCode
import racingcar.model.dto.CarRecord
import racingcar.model.dto.Winners

class Participants(private val participants: List<Car>) {

    init {
        validateParticipantsCount(participants)
        validateDuplicatedName(participants)
    }

    private fun validateParticipantsCount(participants: List<Car>) {
        if (participants.size < 2 || participants.size > 10) {
            throw IllegalArgumentException(ErrorCode.OUT_OF_RANGE_PARTICIPANTS_COUNT.message())
        }
    }

    private fun validateDuplicatedName(participants: List<Car>) {
        val names = participants.map { it.name }
        if (names.toSet().size != participants.size) {
            throw IllegalArgumentException(ErrorCode.DUPLICATED_CAR_NAME.message())
        }
    }

    fun tryToMoveAll() {
        participants.forEach(Car::tryToMove)
    }

    fun furthest(): Winners {
        val first = participants.max()
        val furthest = participants
            .filter { car -> first.compareTo(car) == 0 }
            .map { car -> car.name }
            .toList()
        return Winners(furthest)
    }

    fun records(): List<CarRecord> {
        return participants
            .stream()
            .map(Car::record)
            .toList()
    }
}
