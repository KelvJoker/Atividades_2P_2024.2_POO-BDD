package AT_03;

public class array {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Valores maiores que 3:");
        for (int i = 0; i < num.length; i++) {
           
            if (num[i] > 3) {
                System.out.println("Posição: " + num[i]);
            }
        }
    }
}
