package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private static final String CUSTOM_REGEX = "^//(.+)\\\\n(.+)$";
    private static final String DEFAULT_DELIMITER = "[,:]";

    private record ParsingInfo(String numberPart, String delimiter){}


    public List<Integer> parse(String text) {

        ParsingInfo info = findParsingInfo(text);

        validateNumberPartFormat(info.numberPart, info.delimiter);

        return convertToIntegerList(info.numberPart, info.delimiter);
    }


    private ParsingInfo findParsingInfo(String text) {
        Matcher customRegexMatcher = Pattern.compile(CUSTOM_REGEX).matcher(text);

        if (customRegexMatcher.matches()) {
            String customDelimiter = customRegexMatcher.group(1);
            String numberPart = customRegexMatcher.group(2);

            validateCustomDelimiter(customDelimiter);

            String delimiter = DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter);

            return new ParsingInfo(numberPart, delimiter);
        } else {
            return new ParsingInfo(text, DEFAULT_DELIMITER);
        }
    }

    private void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자로 하나의 문자만 가능합니다");
        }

        String numbers = "[0-9]";
        if (customDelimiter.matches(numbers)) {
            throw new IllegalArgumentException("커스텀 구분자로 숫자가 올 수 없습니다");
        }
    }


    private void validateNumberPartFormat(String numberPart, String delimiter) {
        String numberPartRegex = "^(-?\\d+((" + delimiter + ")-?\\d+)*)?$";

        if (!numberPart.matches(numberPartRegex)) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다");
        }
    }


    private List<Integer> convertToIntegerList(String numberPart, String delimiter) {
        if (numberPart.isEmpty()) {
            return List.of();
        }

        String[] numberStrings = numberPart.split(delimiter);

        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .toList();
    }
}
