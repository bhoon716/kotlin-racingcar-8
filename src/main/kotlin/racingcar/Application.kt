package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.controller.RaceController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val raceController = RaceController(inputView, outputView)

    try {
        raceController.run()
    } finally {
        Console.close()
    }
}
