package TaskTwo;
import java.util.Scanner;

public class VerificaClima {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner temp = new Scanner(System.in);
        System.out.printf("Digite a temperatura: ");
        int temperatura = temp.nextInt();

        if (temperatura > 30) {
            System.out.println("O clima esta quente.");
        } else {
            System.out.println("O clima esta frio.");
        }
    }
}