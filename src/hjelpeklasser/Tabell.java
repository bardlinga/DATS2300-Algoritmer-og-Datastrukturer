package hjelpeklasser;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    private Tabell() {}

    // bytt ------------------------------------------------------------------------------------------------------------

    public static void bytt(int[] tabell, int i, int j){
        int temp = tabell[i];
        tabell[i] = tabell[j];
        tabell[j] = temp;
    }

    public static void bytt(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    // lag permutasjonar -----------------------------------------------------------------------------------------------

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random rand = new Random();         // en randomgenerator
        int[] tabell = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(tabell, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = rand.nextInt(k + 1);        // en tilfeldig tall fra 0 til k
            bytt(tabell, k, i);                   // bytter om
        }
        return tabell;                        // permutasjonen returneres
    }

    public static void randPerm(int[] tabell) {

        Random rand = new Random();

        for (int k = tabell.length - 1; k > 0; k--){
            int i = rand.nextInt(k + 1);
            bytt(tabell, k, i);
        }
    }

    // maks ------------------------------------------------------------------------------------------------------------

    public static int maks(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Ugyldig intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a){
        return maks(a,0,a.length);     // kaller metoden over
    }

    // min -------------------------------------------------------------------------------------------------------------

    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Ugyldig intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int minverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                minverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int min(int[] a){
        return min(a,0,a.length);     // kaller metoden over
    }

    // nestMaks og nestMin ---------------------------------------------------------------------------------------------

    public static int[] nestMaks(int[] tabell) {
        int n = tabell.length;
        if (n < 2){
            throw new java.util.NoSuchElementException("For kort tabell");
        }

        int maks = 0;
        int nestMaks = 1;
        if(tabell[1] > tabell[0]){
            maks = 1;
            nestMaks = 0;
        }
        int maksverdi = tabell[maks];
        int nestMaksverdi = tabell[nestMaks];

        for(int i = 2; i < n; i++){
            if(tabell[i]>nestMaksverdi){
                if(tabell[i]>maksverdi){
                    nestMaks = maks;
                    nestMaksverdi = maksverdi;
                    maks = i;
                    maksverdi = tabell[i];
                } else {
                    nestMaks = i;
                    nestMaksverdi = tabell[i];
                }
            }
        }
        return new int [] {maks, nestMaks};
    }

    public static int[] nestMin(int[] tabell){
        int n = tabell.length;
        if (n < 2){
            throw new java.util.NoSuchElementException("For kort tabell");
        }

        int min = 0;
        int nestMin = 1;
        if (tabell[1] < tabell[0]){
            min = 1;
            nestMin = 0;
        }
        int minverdi = tabell[min];
        int nestMinverdi = tabell[nestMin];

        for (int i = 2; i < n; i++) {
            if (tabell[i] < nestMinverdi){
                if (tabell[i] < minverdi){
                    nestMin = min;
                    nestMinverdi = minverdi;
                    min = i;
                    minverdi = tabell[i];
                } else {
                    nestMin = i;
                    nestMinverdi = tabell[i];
                }
            }
        }
        return new int[] {min, nestMin};
    }

    // telle inversjonar -----------------------------------------------------------------------------------------------

    public static int inversjoner(int[] tabell){
        int antall = 0;
        int verdi;
        for (int i = 0; i < tabell.length - 1; i++){
            verdi = tabell[i];
            for (int j = i + 1; j < tabell.length; j++){
                if (tabell[j] < verdi) {
                    antall ++;
                }
            }
        }
        return antall;
    }

    public static boolean erSortert(int[] tabell){
        for (int i = 0; i < tabell.length - 1; i++){
            if (tabell[i] > tabell[i+1]) return false;
        }
        return true;
    }

    // sortering -------------------------------------------------------------------------------------------------------

    public static int boble(int[] tabell){
        int antall = 0; // antal ombyttingar
        for (int i = 0; i < tabell.length - 1; i++){
            if (tabell[i] > tabell[i+1]){
                bytt(tabell, i, i+1);
                antall ++;
            }
        }
        return antall;
    }

    public static void boblesortering1(int[] tabell){
        for (int i = tabell.length; i > 1; i--){
            for (int j = 1; j < i; j++){
                if (tabell[j - 1] > tabell[j]){
                    bytt(tabell, j - 1, j);
                }
            }
        }
    }

    public static void boblesortering2(int[] tabell){ // med bytteindeksgreier
        for (int i = tabell.length; i > 1; ){
            int bytteindeks = 0;
            for (int j = 1; j < i; j++){
                if (tabell[j - 1] > tabell[j]){
                    bytt(tabell, j - 1, j);
                    bytteindeks = j;
                }
            }
            i = bytteindeks;
        }
    }

    public static void quicksort(int[] a, int fra, int til){
        if (til-fra < 2) return;
        int v = fra;
        int h = til - 1;
        bytt(a, h-(h-v)/2, h); // setter pivotelement som siste element
        int pivot = a[h];
        while (v < h){
            while (v < h && a[v] < pivot) v++;
            while (v < h && a[h] >= pivot) h--;
            if (v < h) bytt(a, v, h);
        }
        if (h != til-1) bytt(a,h,til-1);
        quicksort(a,fra,h);
        quicksort(a,h+1,til);
    }

    public static void quicksort(int[] a){
        quicksort(a, 0, a.length);
    }

    // søkemetodar -----------------------------------------------------------------------------------------------------

    public static int usortertsøk(int[] tabell, int verdi){
        for (int i = 0; i < tabell.length; i++){
            if (tabell[i] == verdi){
                return i;
            }
        }
        return -1;
    }

    public static int lineærsøk(int[] a, int verdi, int fra, int til) // copypaste fra pensum
    {
        til --;
        if (fra < 0 || til >= a.length || fra > til) {
            throw new IllegalArgumentException("Ugyldig intervall!");
        }
        if (verdi > a[til])
            return -(til + 2);  // verdi er større enn den største, vaktpost

        int i = fra;
        while (a[i] < verdi) {
            i++;
        }

        if (verdi == a[i]) {
            return i; // returnerer indeks til søkeverdi dersom fins
        } else {
            return -(i + 1); // returnerer negativt tall, beskriver innsettingspunkt
        }
    }

    public static int lineærsøk(int[] a, int verdi) {
        return lineærsøk(a, verdi, 0, a.length);
    }

    // TODO utvid lineærsøk med hoppesøk, kvadratrotsøk og intervallsøk ref 1.3.5 oppg

    public static int binærsøk(int [] tabell, int verdi, int fra, int til) {

        fratilKontroll(tabell.length, fra, til);

        int v = fra;
        int h = til - 1;

        while (v <= h){
            int m = (v + h) / 2;
            int mVerdi = tabell [m];

            if (verdi > mVerdi){
                v = m + 1;
            } else if (verdi < mVerdi) {
                h = m - 1;
            } else {
                return m; // fant verdi når verdi == mVerdi, returnerer indeks
            }
        }
        return -(v + 1); // returnerer relativt innsettingspunkt ved ikkje funnen
    }

    public static int binærsøk(int [] tabell, int verdi){
        return binærsøk(tabell, verdi, 0, tabell.length);
    }

    // fratilkontroll --------------------------------------------------------------------------------------------------

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
    }

    // programkode 1.4.2 b) generisk maks ------------------------------------------------------------------------------

    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    // programkode 1.4.2 e) generisk innsettingssortering --------------------------------------------------------------

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    // programkode 1.4.3 d) generisk bytt og randperm ------------------------------------------------------------------

    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }
}
