package racingcar.controller

import racingcar.model.Car
import racingcar.model.Participants
import racingcar.model.Race
import racingcar.model.strategy.RandomMoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        outputView.printEnterCarNamesPrompt()
        val carNames = inputView.readCarNames()

        val cars = carNames.split(",")
            .map { name -> Car(name, RandomMoveStrategy()) }
            .toList()

        outputView.printTrialCountPrompt()
        val trialCount = inputView.readTrialCount()
        val race = Race(trialCount, Participants(cars))

        val raceRecord = race.start()
        val winners = race.winners()

        outputView.printRaceRecord(raceRecord)
    }
}