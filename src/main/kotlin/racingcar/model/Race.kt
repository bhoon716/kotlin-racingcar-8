package racingcar.model

import racingcar.model.dto.RaceRecord
import racingcar.model.dto.RoundRecord

class Race(private val trialCount:Int, private val participants: Participants) {

    fun start(): RaceRecord {
        var raceRecord = RaceRecord()

        for(round in 1 .. trialCount) {
            participants.tryToMoveAll()
            raceRecord += RoundRecord(round, participants.records())

        }
        return raceRecord
    }
}
