package racingcar.model

import racingcar.model.dto.CarRecord

class Participants(private val participants: List<Car>) {

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