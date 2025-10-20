package calculator.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterTest {

    private final Delimiter delimiter = new Delimiter();

    @DisplayName("입력값을 파싱해 정수형 배열로 반환")
    @Test
    void parse() {
        // given
        String input = "1:2:3";
        // when
        List<Integer> numbers = delimiter.parse(input);
        // then

        assertThat(numbers).isEqualTo(List.of(1,2,3));
    }

    @DisplayName("빈 배열 입력 가능")
    @Test
    void inputEmpty() {
        // given
        String input = "";
        // when
        List<Integer> numbers = delimiter.parse(input);
        // then
        assertThat(numbers).isEqualTo(List.of());
    }

    @DisplayName("커스텀 구분자 입력 성공")
    @Test
    void inputCustomDelimiter() {
        // given
        String input = "//@\\n1@2@3";
        // when
        List<Integer> numbers = delimiter.parse(input);
        // then
        assertThat(numbers).isEqualTo(List.of(1,2,3));
    }

    @DisplayName("커스텀 구분자로 숫자 입력되면 예외 발생")
    @Test
    void inputNumberCustomDelimiter() {
        // given
        String input = "//2\\n12121";
        // when
        // then
        assertThatThrownBy(() -> delimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자로 숫자가 올 수 없습니다");
    }


    @DisplayName("커스텀 구분자로 두 개 이상의 문자가 입력되면 예외 발생")
    @Test
    void inputManyNumbersCustomDelimiter() {
        // given
        String input = "//@@\\n1@@2@@3";
        // when
        // then
        assertThatThrownBy(() -> delimiter.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자로 하나의 문자만 가능합니다");
    }
}