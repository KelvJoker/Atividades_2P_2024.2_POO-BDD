package AT_03;

public class num_while {
    public static void main(String args[]){

        int num = 0;
        System.out.printf("Os números de 1 a 50: ");

        do {
            num++;
            System.out.printf("%d ", num);
        }while (num < 50);

        System.out.println();
        System.out.printf("Os números impares de 1 a 50: ");
        num = 1;

        do {
            num+= 2;
            System.out.printf("%d ", num);
        }while (num < 49);

    }
}