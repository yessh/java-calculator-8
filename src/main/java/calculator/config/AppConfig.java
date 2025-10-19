package calculator.config;

import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.controller.CalculatorController;
import calculator.io.Input;
import calculator.io.Output;

public class AppConfig {

    public Input input() {
        return new Input();
    }

    public Output output() {
        return new Output();
    }

    public Calculator calculator() {
        return new Calculator();
    }

    public Delimiter delimiter() {
        return new Delimiter();
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(
                input(),
                calculator(),
                delimiter(),
                output()
        );
    }
}
