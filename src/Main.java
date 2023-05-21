import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String str = scanner.nextLine();

        String result = Calculator.calc(str);
        System.out.println(result);

    }
}
