package calculator;

import calculator.io.Input;
import calculator.io.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        String inputValue = input.parseInput();

        Delimiter delimiter = new Delimiter();
        List<Integer> numberList = delimiter.parse(inputValue);

        Calculator calculator = new Calculator();
        calculator.validateNegative(numberList);
        int sum = calculator.sum(numberList);

        Output output = new Output();
        output.printResult(sum);
    }
}