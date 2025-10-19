package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.io.Input;
import calculator.io.Output;

import java.util.List;

public class CalculatorController {

    private final Input input;
    private final Calculator calculator;
    private final Delimiter delimiter;
    private final Output output;

    public CalculatorController(Input input, Calculator calculator, Delimiter delimiter, Output output) {
        this.input = input;
        this.calculator = calculator;
        this.delimiter = delimiter;
        this.output = output;
    }


    public void run() {
        String inputValue = input.parseInput();

        List<Integer> numberList = delimiter.parse(inputValue);

        calculator.validateNegative(numberList);
        int sum = calculator.sum(numberList);

        output.printResult(sum);

    }


}
