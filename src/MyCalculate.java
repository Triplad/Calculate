

import java.io.IOException;
import java.util.Scanner;

public class MyCalculate {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String str = scanner.nextLine();

        String result = Main.calc(str);
        System.out.println(result);

    }
}
class Main {
    public static String calc(String input) throws Exception {

        Convert converter = new Convert();
        String[] operands = {"+", "-", "/", "*"};
        String[] opera = {"\\+", "-", "/", "\\*"};


        int defOperands = -1;
        for (int i = 0; i < operands.length; i++) {
            if (input.contains(operands[i])) {
                defOperands = i;
                break;
            }
        }

        if (defOperands == -1) throw new Exception("Ошибка, т.к строка не является математической операцией.");


        String[] str1 = input.split(opera[defOperands]);


        if (converter.isRoman(str1[0]) == converter.isRoman(str1[1])) {
            int a, b;
            boolean isRoman = converter.isRoman(str1[0]);

            if (isRoman) {
                a = converter.romanToInt(str1[0]);
                b = converter.romanToInt(str1[1]);
            } else {
                a = Integer.parseInt(str1[0]);
                b = Integer.parseInt(str1[1]);
            }


            if (str1.length != 2)
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            if (a > 10) {
                throw new IOException("Ошибка, т.к каждый операнд должен быть не более числа 10, включительно.");
            }
            if (b > 10) {
                throw new IOException("Ошибка, т.к каждый операнд должен быть не более числа 10, включительно.");
            }


            int result;
            switch (operands[defOperands]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }

            if (isRoman) {
                return converter.intToRoman(result);
            } else {

                return String.valueOf(result);
            }

        } else {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }
    }
}