package racingcar.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.error.ErrorCode

class ParticipantsTest {

    @DisplayName("참가자 생성 성공 테스트")
    @Test
    fun participantsTest() {
        // given
        val cars = listOf("pobi", "woni", "jun")
            .map { name -> Car(name) { true } }
            .toList()

        // when & then
        assertThatCode { Participants(cars) }.doesNotThrowAnyException()
    }

    @DisplayName("참가자 생성 실패 테스트 - 중복된 이름 존재")
    @Test
    fun duplicatedNameTest() {
        // given
        val cars = listOf("pobi", "woni", "jun", "pobi")
            .map { name -> Car(name) { true } }
            .toList()

        // when & then
        assertThatThrownBy { Participants(cars) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorCode.DUPLICATED_CAR_NAME.message())
    }

    @DisplayName("참가자 전원 전진 1회 테스트")
    @Test
    fun moveAllTest() {
        // given
        val cars = listOf("pobi", "woni", "jun", "pobi")
            .map { name -> Car(name) { true } }
            .toList()
        val participants = Participants(cars)

        // when
        participants.tryToMoveAll()

        // then
        participants.records()
            .forEach { participant ->
                assertThat(participant.position).isEqualTo(1)
            }
    }
}