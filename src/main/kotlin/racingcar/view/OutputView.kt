package racingcar.view

import racingcar.model.dto.CarSnapshot
import racingcar.model.dto.RaceSnapshot
import racingcar.model.dto.RoundSnapshot
import racingcar.model.dto.Winners

class OutputView {

    fun printEnterCarNamesPrompt() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printTrialCountPrompt() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRaceResult(raceSnapshot: RaceSnapshot) {
        val stringBuilder = StringBuilder()
        appendExecutionResultPrompt(stringBuilder)
        buildRaceSnapshot(raceSnapshot, stringBuilder)
        print(stringBuilder)
    }

    private fun appendExecutionResultPrompt(stringBuilder: StringBuilder) {
        stringBuilder
            .append(System.lineSeparator())
            .append("실행결과")
            .append(System.lineSeparator())
    }

    private fun buildRaceSnapshot(raceSnapshot: RaceSnapshot, stringBuilder: StringBuilder) {
        raceSnapshot.roundSnapshots
            .forEach { roundSnapshot -> buildRoundSnapshot(roundSnapshot, stringBuilder) }
    }

    private fun buildRoundSnapshot(roundSnapshot: RoundSnapshot, stringBuilder: StringBuilder) {
        roundSnapshot.carSnapshots
            .forEach { carSnapshot -> buildCarSnapshot(carSnapshot, stringBuilder) }

        stringBuilder.append(System.lineSeparator())
    }

    private fun buildCarSnapshot(carSnapshot: CarSnapshot, stringBuilder: StringBuilder) {
        stringBuilder
            .append(carSnapshot.name)
            .append(NAME_DISTANCE_SEPARATOR)
            .append(POSITION_MARK.repeat(carSnapshot.position))
            .append(System.lineSeparator())
    }

    fun printWinners(winners: Winners) {
        println("최종 우승자 : " + winners.names.joinToString(WINNER_NAME_SEPARATOR))
    }

    companion object {
        private const val NAME_DISTANCE_SEPARATOR = " : "
        private const val POSITION_MARK = "-"
        private const val WINNER_NAME_SEPARATOR = ", "
    }
}
