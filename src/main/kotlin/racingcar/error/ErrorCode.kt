package racingcar.error

enum class ErrorCode(private val message: String) {

    INVALID_CAR_NAME("잘못된 자동차 이름입니다. 자동차 이름은 문자와 숫자로만 이루어진 1~5자 문자열만 가능합니다."),
    ;

    fun message(): String {
        return "[Error] $message"
    }
}