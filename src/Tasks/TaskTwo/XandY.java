package TaskTwo;
import java.util.Scanner;

public class XandY {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Digite o X: ");
        int x = scanner.nextInt();
        System.out.printf("Digite Y: ");
        int y = scanner.nextInt();

        if (x > y) {
            System.out.println("O maior valor é: " + x);
        } else if (y > x) {
            System.out.println("O maior valor é: " + y);
        } else {
            System.out.println("Os valores são iguais.");
        }
    }
}