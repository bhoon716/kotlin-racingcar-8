package racingcar.model.dto

data class RaceSnapshot(val roundSnapshots: List<RoundSnapshot> = listOf()) {

    operator fun plus(roundSnapshot: RoundSnapshot): RaceSnapshot {
        return copy(roundSnapshots = roundSnapshots + roundSnapshot)
    }
}
