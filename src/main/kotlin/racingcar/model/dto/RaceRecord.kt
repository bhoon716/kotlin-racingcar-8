package racingcar.model.dto

data class RaceRecord(val roundRecords : List<RoundRecord> = listOf()) {

    operator fun plus(roundRecord: RoundRecord): RaceRecord {
        return copy(roundRecords = roundRecords + roundRecord)
    }
}
