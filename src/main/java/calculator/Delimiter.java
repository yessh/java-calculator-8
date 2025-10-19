package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private String numberPart;
    private String delimiter = "[,:]";

    private final String CUSTOM_REGEX = "^//(.)\\\\n(.+)$";
    private final String NUMBERPART_REGEX = "^\\d+(" + delimiter + "\\d+)*$";


    public List<Integer> parse(String text) {

        findCustomRegex(text);

        validateNumberPartFormat(numberPart);

        return convertToIntegerList(numberPart);

    }

    private void findCustomRegex(String text) {
        Matcher customRegexMatcher = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if (customRegexMatcher.matches()) {
            String customDelimiter = customRegexMatcher.group(1);
            this.numberPart = customRegexMatcher.group(2);

            this.delimiter += "|" + Pattern.quote(customDelimiter);
        } else {
            this.numberPart = text;
        }
    }

    private void validateNumberPartFormat(String text) {
        if (!numberPart.matches(NUMBERPART_REGEX)) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다");
        }

    }

    private List<Integer> convertToIntegerList(String numberPart) {
        String[] numberStrings = numberPart.split(delimiter);

        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .toList();
    }
}
