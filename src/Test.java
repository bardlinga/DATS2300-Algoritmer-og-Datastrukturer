import hjelpeklasser.*;

public class Test {
    public static void main(String [] args){
        int [] tabell = Tabell.randPerm(20);
        for (int i : tabell) System.out.print(i + " ");

        int maks = Tabell.maks(tabell);

        System.out.println("Største verdi har indeks " + maks);
    }
}
