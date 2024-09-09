import hjelpeklasser.*;
import java.util.*;

public class Test {
    public static void main(String [] args){
        quicksortTest();
    }

    private static void quicksortTest(){
        int[] a = Tabell.randPerm(19);
        System.out.println(Arrays.toString(a));
        Tabell.quicksort(a);
        System.out.println(Arrays.toString(a));
    }
}
