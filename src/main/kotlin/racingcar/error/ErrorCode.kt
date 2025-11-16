package racingcar.error

enum class ErrorCode(private val message: String) {

    INVALID_CAR_NAME("잘못된 자동차 이름입니다. 자동차 이름은 문자와 숫자로만 이루어진 1~5자 문자열만 가능합니다."),
    DUPLICATED_CAR_NAME("중복된 자동차 이름입니다. 경주할 자동차의 이름은 중복되면 안됩니다."),
    OUT_OF_RANGE_PARTICIPANTS_COUNT("허용된 자동차 개수를 벗어났습니다. 자동차는 최소 2대 ~ 최대 10대까지만 가능합니다."),
    OUT_OF_RANCE_TRIAL_COUNT("허용된 시도 횟수 범위를 벗어났습니다. 시도횟수는 최소 1회 ~ 최대 1,000회까지만 가능합니다.")
    ;

    fun message(): String {
        return "[Error] $message"
    }
}