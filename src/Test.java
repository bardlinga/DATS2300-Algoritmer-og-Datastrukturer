import hjelpeklasser.*;

import java.util.Arrays;

public class Test {
    public static void main(String [] args){
        int[] tabell = Tabell.randPerm(31);
        System.out.println(Arrays.toString(tabell));
        Binaertre bt = new Binaertre(tabell);
        int [] sortertTabell = bt.inOrdenTabell();
        System.out.println(Arrays.toString(sortertTabell));

        System.out.println(bt.inneholderVerdi(1));
        System.out.println(bt.inneholderVerdi(100));
    }
}
