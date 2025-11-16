package racingcar.model

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.error.ErrorCode

class RaceTest {

    val cars = listOf("pobi", "woni", "jun")
        .map { name -> Car(name) { true } }
        .toList()

    @DisplayName("경주 생성 성공 테스트")
    @Test
    fun raceTest() {
        // given
        val trialCount = 10
        val participants = Participants(cars)

        // when & then
        assertThatCode { Race(trialCount, participants) }.doesNotThrowAnyException()
    }

    @DisplayName("경주 생성 실패  테스트 - 시도 횟수가 1~1000이 아님")
    @ParameterizedTest
    @ValueSource(
        ints = [
            -1,
            0,
            1001
        ]
    )
    fun outOfRangeRaceCountTest(trialCount: Int) {
        // given
        val participants = Participants(cars)

        // when & then
        assertThatThrownBy { Race(trialCount, participants) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorCode.OUT_OF_RANCE_TRIAL_COUNT.message())
    }
}
