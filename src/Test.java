import hjelpeklasser.*;
import java.util.*;

public class Test {
    public static void main(String [] args){
        int[] a = {3,8,10,14,14,16,21,24,27,30,32,33,34,37,40};
        int[] b = {1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 14, 14, 15};

        System.out.println(Tabell.binærsøk(b,4));
    }
}
