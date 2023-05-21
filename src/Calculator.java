import java.io.IOException;

public class Calculator {

    private static String[] operands = {"+", "-", "/", "*"};
    private static String[] opera = {"\\+", "-", "/", "\\*"};

    public static String calc(String input) throws Exception {


        int defOperands = -1;
        for (int i = 0; i < operands.length; i++) {
            if (input.contains(operands[i])) {
                defOperands = i;
                break;
            }
        }

        if (defOperands == -1) throw new Exception("Ошибка, т.к строка не является математической операцией.");


        String[] numbers = input.split(opera[defOperands]);
        String number1 = numbers[0].trim();
        String number2 = numbers[1].trim();


        boolean isRoman = isNumbersRoman(number1, number2);
        int a;
        int b;
        if (isRoman) {
            a = Converter.romanToArab(number1);
            b = Converter.romanToArab(number2);
        } else {
            a = Integer.parseInt(number1);
            b = Integer.parseInt(number2);
        }


        if (numbers.length != 2)
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        if (a > 10) {
            throw new IOException("Ошибка, т.к каждый операнд должен быть не более числа 10, включительно.");
        }
        if (b > 10) {
            throw new IOException("Ошибка, т.к каждый операнд должен быть не более числа 10, включительно.");
        }


        int result = processMathOperation(operands[defOperands], a, b);
        if (isRoman) {
            return Converter.arabToRoman(result);
        } else {
            return String.valueOf(result);
        }

    }

    private static int processMathOperation(String operand, int num1, int num2) {

        switch (operand) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;

        }
    }
    private static boolean isNumbersRoman(String number1, String number2) {
        boolean isNumber1Roman = false;
        boolean isNumber2Roman = false;
        for (int i = 0; i < Converter.ROMAN_NUMBER.length; i++) {

            if (Converter.ROMAN_NUMBER[i].equals(number1)) {
                isNumber1Roman = true;
            }
            if (Converter.ROMAN_NUMBER[i].equals(number2)) {
                isNumber2Roman = true;
            }
        }
        if (isNumber1Roman == isNumber2Roman) {
            return isNumber1Roman && isNumber2Roman;
        }
        throw new RuntimeException("т.к. используются одновременно разные системы счисления");
    }
}