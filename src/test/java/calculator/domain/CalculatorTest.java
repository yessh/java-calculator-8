package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();


    @DisplayName("양수로 이루어진 배열은 예외 발생 안함")
    @Test
    void validateCalculator() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);
        // when
        // then
        assertThatCode(() -> calculator.validateNegative(numbers))
                .doesNotThrowAnyException();
    }


    @DisplayName("음수가 입력되면 예외 발생")
    @Test
    void validateNegative() {
        // given
        List<Integer> numbers = List.of(-1,2,3);
        // when
        // then
        assertThatThrownBy(() -> calculator.validateNegative(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력될 수 없습니다");
    }


    @DisplayName("배열에 대한 총 합 계산 성공")
    @Test
    void sum() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);
        // when
        int sum = calculator.sum(numbers);
        // then
        assertThat(sum).isEqualTo(6);
    }


    @DisplayName("빈 배열 넘어올시 0 반환 성공")
    @Test
    void sumZero() {
        // given
        List<Integer> numbers = List.of(0);
        // when
        int sum = calculator.sum(numbers);
        // then
        assertThat(sum).isEqualTo(0);
    }
}