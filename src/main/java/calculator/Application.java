package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        int sum = calculate(input);

        System.out.println("결과 : " + sum);

    }


    private static int calculate(String input) {
        String delimiterSet = "[,:]";
        String myText = input;

        // 커스텀 구분자 생성 여부 확인
        Matcher customDelimiterRegex = Pattern.compile("^//(.)\\\\n(.+)$").matcher(myText);
        if (customDelimiterRegex.matches()) {
            String customDelimiter = customDelimiterRegex.group(1);
            myText = customDelimiterRegex.group(2);

            delimiterSet += "|" + Pattern.quote(customDelimiter);   // delimiterSet 에 커스텀 구분자 추가
        }

        // 제대로된 덧셈식 아닐시 예외 발생.
        String validationRegex = "^\\d+(" + delimiterSet + "\\d+)*$";
        if (!myText.matches(validationRegex)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }


        // 덧셈 완료 후 각 숫자를 list에 추가.
        String[] numberStrings = myText.split(delimiterSet);
        List<Integer> numbers = Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .toList();


        // 음수 입력 확인
        List<Integer> negativeNums = numbers.stream()
                .filter(n -> n < 0)
                .toList();
        if (!negativeNums.isEmpty()) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }


        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}