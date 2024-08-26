import java.util.Scanner;

public class Calculadora {
    public static Scanner scanner = new Scanner(System.in);
    public static double n1;
    public static double n2;
    public static String opcao;
    public static boolean loop = true;

    public static void main(String[] args) {
        while (loop) {
            System.out.println("==========================Menu==========================");
            userInput();

            if (loop) {
                double result = escolha(n1, opcao, n2);
                fim(result);
            }
        }
    }

    public static void userInput() {
        System.out.print("Digite seu primeiro número ou digite 'sair' para encerrar: ");
        if (scanner.hasNextDouble()) {
            n1 = scanner.nextDouble();
            System.out.print("Escolha seu operador (+, -, *, /): ");
            opcao = scanner.next();
            System.out.print("Digite seu segundo número: ");
            n2 = scanner.nextDouble();
        } else {
            opcao = scanner.next();
            if (opcao.equalsIgnoreCase("sair")) {
                loop = false;
            } else {
                System.out.println("Entrada inválida. O programa será encerrado.");
                loop = false;
            }
        }
    }

    public static double escolha(double x, String select, double y) {
        switch (select) {
            case "+":
                return soma(x, y);
            case "*":
                return multi(x, y);
            case "/":
                if (y == 0) {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                    loop = false;
                    return Double.NaN;
                }
                return divi(x, y);
            case "-":
                return sub(x, y);
            default:
                System.out.println("Operador inválido.");
                loop = false;
                return 0;
        }
    }

    public static void fim(double result) {
        if (Double.isNaN(result)) {
            System.out.println("Operação não realizada devido a um erro.");
        } else {
            System.out.printf("O resultado da operação %.2f %s %.2f é: %.2f\n", n1, opcao, n2, result);
        }
        if (loop) {
            System.out.print("Quer calcular novamente? (s/n): ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("n")) {
                loop = false;
                System.out.println("Obrigado por usar a calculadora. Até logo!");
            }
        }
    }

    public static double soma(double x, double y) {
        return x + y;
    }

    public static double sub(double x, double y) {
        return x - y;
    }

    public static double multi(double x, double y) {
        return x * y;
    }

    public static double divi(double x, double y) {
        return x / y;
    }
}