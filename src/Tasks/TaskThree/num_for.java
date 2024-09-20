package AT_03;

public class num_for {
    public static void main(String args[]){

        System.out.printf("Os números de 1 a 50: ");

        for (int num = 1; num < 51; num++){
            System.out.printf("%d ", num);
        }

            System.out.println();
            System.out.printf("Os números pares de 1 a 50:");

        for (int num = 2; num < 51; num+= 2){
            System.out.printf("%d ", num);
        }
    }
} 