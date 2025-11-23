package racingcar.util

import racingcar.error.ErrorCode

object IntParser {

    fun parse(input: String): Int {
        try {
            return input.toInt()
        } catch (_: NumberFormatException) {
            throw NumberFormatException(ErrorCode.INVALID_INT_FORMAT.message())
        }
    }
}
