package racingcar.controller

import racingcar.model.Car
import racingcar.model.Participants
import racingcar.model.Race
import racingcar.model.strategy.RandomMoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val race = setUpRace()

        start(race)

        printWinner(race)
    }

    private fun setUpRace(): Race {
        val cars = setUpCars()
        val trialCount = setUpTrialCount()
        val race = Race(trialCount, Participants(cars))
        return race
    }

    private fun setUpCars(): List<Car> {
        val carNames = readCarNames()
        return generateCars(carNames)
    }

    private fun generateCars(carNames: String): List<Car> =
        carNames.split(",")
            .map { name -> Car(name, RandomMoveStrategy()) }
            .toList()

    private fun readCarNames(): String {
        outputView.printEnterCarNamesPrompt()
        return inputView.readCarNames()
    }

    private fun setUpTrialCount(): Int {
        outputView.printTrialCountPrompt()
        return inputView.readTrialCount()
    }

    private fun start(race: Race) {
        val result = race.start()
        outputView.printRaceResult(result)
    }

    private fun printWinner(race: Race) {
        val winners = race.winners()
        outputView.printWinners(winners)
    }
}
