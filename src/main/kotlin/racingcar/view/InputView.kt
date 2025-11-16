package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.IntParser

class InputView {

    fun readCarNames():String {
        return Console.readLine()
    }

    fun readTrialCount(): Int {
        return IntParser.parse(Console.readLine())
    }
}
