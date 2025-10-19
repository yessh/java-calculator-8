package calculator.domain;

import java.util.List;

public class Calculator {
    
    public void validateNegative(List<Integer> numbers) {

        List<Integer> negativeGroup = numbers.stream()
                .filter(n -> n < 0)
                .toList();

        if (!negativeGroup.isEmpty()) {
            throw new IllegalArgumentException("음수는 입력될 수 없습니다");
        }
    }


    public int sum(List<Integer> numbers) {

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}