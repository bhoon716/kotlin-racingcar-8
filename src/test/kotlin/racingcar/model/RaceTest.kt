package racingcar.model

import org.assertj.core.api.Assertions.assertThat
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

    @DisplayName("3회 경주 테스트")
    @Test
    fun raceStartTest() {
        // given
        val car1 = Car("car1") { true }
        val car2 = Car("car2") { true }
        val car3 = Car("car3") { false }
        val race =Race(3, Participants(listOf(car1, car2, car3)))

        // when
        val raceRecord = race.start()

        // then
        assertThat(raceRecord.roundRecords.size).isEqualTo(3)
        assertThat(race.winners().names).containsExactly("car1", "car2")
    }
}
