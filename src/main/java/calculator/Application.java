package calculator;

import calculator.config.AppConfig;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {

        AppConfig appconfig = new AppConfig();
        CalculatorController controller = appconfig.calculatorController();

        controller.run();
    }
}