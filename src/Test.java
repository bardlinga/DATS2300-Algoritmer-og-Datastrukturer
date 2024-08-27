import hjelpeklasser.*;

import java.util.Arrays;

public class Test {
    public static void main(String [] args){
        int[] tabell = Tabell.randPerm(31);
        System.out.println(Arrays.toString(tabell));
        Binaertre bt = new Binaertre(tabell);
        System.out.println("bt inneholder 10: " + bt.inneholderVerdi(10));
        System.out.println("bt inneholder 22: " + bt.inneholderVerdi(22));
    }
}
