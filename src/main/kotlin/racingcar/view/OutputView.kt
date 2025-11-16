package racingcar.view

import racingcar.model.dto.CarRecord
import racingcar.model.dto.RaceRecord
import racingcar.model.dto.RoundRecord
import racingcar.model.dto.Winners

class OutputView {

    fun printEnterCarNamesPrompt() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printTrialCountPrompt() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRaceRecord(raceRecord: RaceRecord) {
        val stringBuilder = StringBuilder()
        appendExecutionResultPrompt(stringBuilder)
        buildRaceRecord(raceRecord, stringBuilder)
        print(stringBuilder)
    }

    private fun appendExecutionResultPrompt(stringBuilder: StringBuilder) {
        stringBuilder
            .append(System.lineSeparator())
            .append("실행결과")
            .append(System.lineSeparator())
    }

    private fun buildRaceRecord(raceRecord: RaceRecord, stringBuilder: StringBuilder) {
        raceRecord.roundRecords
            .forEach { roundRecord -> buildRoundRecord(roundRecord, stringBuilder) }
    }

    private fun buildRoundRecord(roundRecord: RoundRecord, stringBuilder: StringBuilder) {
        roundRecord.carRecords
            .forEach { carRecord -> buildCarRecord(carRecord, stringBuilder) }
        stringBuilder.append(System.lineSeparator())
    }

    private fun buildCarRecord(carRecord: CarRecord, stringBuilder: StringBuilder) {
        stringBuilder
            .append(carRecord.name)
            .append(NAME_DISTANCE_SEPARATOR)
            .append(POSITION_MARK.repeat(carRecord.position))
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
