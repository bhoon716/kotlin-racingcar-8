package racingcar.model.dto

data class RoundSnapshot(val round: Int, val carSnapshots: List<CarSnapshot>)
