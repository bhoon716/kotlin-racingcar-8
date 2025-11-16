package racingcar.model

import racingcar.error.ErrorCode
import racingcar.model.dto.RaceRecord
import racingcar.model.dto.RoundRecord

class Race(private val trialCount:Int, private val participants: Participants) {

    init {
        validate(trialCount)
    }

    private fun validate(trialCount: Int) {
        if (trialCount < 1 || trialCount > 1000) {
            throw IllegalArgumentException(ErrorCode.OUT_OF_RANCE_TRIAL_COUNT.message())
        }
    }

    fun start(): RaceRecord {
        var raceRecord = RaceRecord()

        for(round in 1 .. trialCount) {
            participants.tryToMoveAll()
            raceRecord += RoundRecord(round, participants.records())

        }
        return raceRecord
    }
}
