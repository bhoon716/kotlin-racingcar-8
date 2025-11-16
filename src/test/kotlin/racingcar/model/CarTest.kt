package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.error.ErrorCode
import racingcar.model.strategy.MoveStrategy

class CarTest {

    val mustMove = MoveStrategy { true }

    @DisplayName("차 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(
        strings = [
            "pobi",
            "a123",
            "123",
            "가나다1"
        ]
    )
    fun carTest(name: String) {
        // given
        // when & then
        Assertions.assertThatCode { Car(name, mustMove) }.doesNotThrowAnyException()
    }

    @DisplayName("차 생성 실패 - 잘못된 이름")
    @ParameterizedTest
    @ValueSource(
        strings = [
            "",
            " ",
            "pobi!",
            "pobipobi"
        ]
    )
    fun invalidCarNameTest(name: String) {
        // given
        // when & then
        Assertions.assertThatThrownBy { Car(name, mustMove) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorCode.INVALID_CAR_NAME.message())
    }

    @DisplayName("차 이동 테스트")
    @Test
    fun moveTest() {
        // given
        val car = Car("car1", mustMove)

        // when
        car.tryToMove()

        // then

    }
}
