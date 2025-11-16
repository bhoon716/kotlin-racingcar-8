package racingcar.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
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
        assertThatCode { Car(name, mustMove) }.doesNotThrowAnyException()
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
        assertThatThrownBy { Car(name, mustMove) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorCode.INVALID_CAR_NAME.message())
    }

    @DisplayName("차 이동 및 비교 테스트")
    @Test
    fun moveTest() {
        // given
        val car1 = Car("car1", mustMove)
        val car2 = Car("car2", mustMove)

        // when
        car1.tryToMove()
        car2.tryToMove()

        // then
        assertThat(car1.compareTo(car2)).isEqualTo(0)
    }
}
