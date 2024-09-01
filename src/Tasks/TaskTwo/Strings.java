package TaskTwo;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
    
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);  
        
        System.out.printf("Digite um nome: ");
        String nome = scanner.nextLine();  
        
        System.out.printf("Número de caracteres é: %d\n", nome.length());
        System.out.printf("Todas as letras em maiúsculo: %s\n", nome.toUpperCase());

        int numVogais = 0;
        String vogais = "aeiouAEIOU";
        for (int i = 0; i < nome.length(); i++) {
            if (vogais.indexOf(nome.charAt(i)) != -1) {
                numVogais++;
            }
        }
        
        System.out.println("Número de vogais: " + numVogais);

        boolean comecaComUNI = nome.toUpperCase().startsWith("UNI");
        System.out.println("Começa com 'UNI': " + comecaComUNI);

        boolean terminaComRIO = nome.toUpperCase().endsWith("RIO");
        System.out.println("Termina com 'RIO': " + terminaComRIO);
    }
}