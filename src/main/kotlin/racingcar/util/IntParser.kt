package racingcar.util

import racingcar.error.ErrorCode

class IntParser {

    companion object {
        fun parse(input: String): Int {
            try {
                return input.toInt()
            } catch (_: NumberFormatException) {
                throw NumberFormatException(ErrorCode.INVALID_INT_FORMAT.message())
            }
        }
    }
}