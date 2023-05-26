//import java.util.Scanner;
//
//public class StringCalc {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите выражение: ");
//        String s = scanner.nextLine();
//        String[] operands = {" + ", " - ", " / ", " * "};
//        String[] opera = {" \\+ ", " - ", " / ", " \\* "};
//        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//
//
//        int defineOp = -1;
//        for (int i = 0; i < operands.length; i++) {
//            if (s.contains(operands[i])) {
//                defineOp = i;
//                break;
//            }
//        }
//
//
//        String[] str = s.split(opera[defineOp]);
//        String let1 = str[0].trim();
//        String let2 = str[1].trim();
//
//
//        boolean addAndSubst = wOp(operands[defineOp]);
//        boolean isMultiAndDiv = wOp2(operands[defineOp]);
//        int a;
//
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i].equals(let1) && !let1.contains("\"")) {
//                throw new RuntimeException("т.к. для выполнения операции число нужно вводить вторым(после оператора).");
//            }
//        }
//
//
//        if (addAndSubst) {
//            if (!let2.contains("\""))
//                throw new RuntimeException("т.к. выполнять сложение либо вычитание нужно на строку.");
//            String result = additionAndSubtraction(operands[defineOp], let1, let2);
//            System.out.println("\"" + result + "\"");
//        } else if (isMultiAndDiv) {
//            if (let2.contains("\""))
//                throw new RuntimeException("т.к. выполнять умножение либо деление нужно на число.");
//            String result = multiAndDivision(operands[defineOp], let1, Integer.parseInt(let2));
//            System.out.println("\"" + result + "\"");
//        }
//
//
//    }
//
//    private static String additionAndSubtraction(String operand, String l1, String l2) {
//        String res = "";
//
//        l1 = l1.replace("\"", "");
//        l2 = l2.replace("\"", "");
//
//        for (int i = 0; i <= l1.length(); i++) {
//            for (int j = 0; j <= l2.length(); j++) {
//                if (i > 10 || j > 10) {
//                    throw new RuntimeException("т.к. строка должна состоять не более 10 символов.");
//                }
//            }
//        }
//        if (operand.contains("+")) {
//            res = l1 + l2;
//        }
//        if (operand.contains("-")) {
//            res = l1.replace(l2, "");
//        }
//        return res;
//    }
//
//    private static String multiAndDivision(String operand, String l1, int l2) {
//        String res = "";
//        l1 = l1.replace("\"", "");
//
//        for (int i = 0; i <= l1.length(); i++) {
//            if (i > 10 || l2 > 10) {
//                throw new RuntimeException("т.к. строка должна состоять не более 10 символов и число не более 10 включительно.");
//            }
//        }
//
//        if (operand.contains("/")) {
//            String str = l1.substring(0, l1.length() / l2);
//            res = str;
//        }
//        if (operand.contains("*")) {
//            for (int i = 0; i < l2; i++) {
//                res = res + l1;
//            }
//        }
//        if (res.length() > 40) {
//            res = res.substring(0, 40);
//            res = res + "...";
//        }
//
//        return res;
//    }
//
//
//    private static boolean wOp(String o1) {
//        boolean isOperands = false;
//
//        if (o1.contains("+")) {
//            isOperands = true;
//        }
//        if (o1.contains("-")) {
//            isOperands = true;
//        }
//        return isOperands;
//    }
//
//    private static boolean wOp2(String o1) {
//        boolean isOperands = false;
//
//        if (o1.contains("*")) {
//            isOperands = true;
//        }
//        if (o1.contains("/")) {
//            isOperands = true;
//        }
//        return isOperands;
//    }
//
//}
//
