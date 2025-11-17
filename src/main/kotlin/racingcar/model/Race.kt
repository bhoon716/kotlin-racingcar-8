package racingcar.model

import racingcar.error.ErrorCode
import racingcar.model.dto.RaceSnapshot
import racingcar.model.dto.RoundSnapshot
import racingcar.model.dto.Winners

class Race(private val trialCount: Int, private val participants: Participants) {

    init {
        validate(trialCount)
    }

    private fun validate(trialCount: Int) {
        if (trialCount < MINIMUM_TRIAL_COUNT || trialCount > MAXIMUM_TRIAL_COUNT) {
            throw IllegalArgumentException(ErrorCode.OUT_OF_RANCE_TRIAL_COUNT.message())
        }
    }

    fun start(): RaceSnapshot {
        var raceSnapshot = RaceSnapshot()
        for (round in 1..trialCount) {
            participants.tryToMoveAll()
            raceSnapshot += RoundSnapshot(round, participants.records())
        }
        return raceSnapshot
    }

    fun winners(): Winners {
        return participants.furthest()
    }

    private companion object CONSTANT {
        private const val MINIMUM_TRIAL_COUNT = 1
        private const val MAXIMUM_TRIAL_COUNT = 1000
    }
}
