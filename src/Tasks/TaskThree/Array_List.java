package AT_03;

import java.util.Comparator;
import java.lang.String;
import java.util.ArrayList;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class Array_List {  
    @Test
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Talles");
        nomes.add("Bruno");
        nomes.add("Carlos");
        nomes.add("Daniela");
        nomes.add("Eduardo");

        System.out.println("Lista:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        nomes.remove(1);

        System.out.println();
        System.out.println("Lista após remover o segundo nome:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        nomes.remove(2);

        System.out.println("\nLista após remover o terceiro nome:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        if (nomes.get(0).equals("Talles")) {
            System.out.println("\nO nome na primeira posição é Talles.");
        } else {
            System.out.println("\nO nome na primeira posição NÃO é Talles.");
        }
    }
}