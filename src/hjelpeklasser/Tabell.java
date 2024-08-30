package hjelpeklasser;

import java.util.Arrays;
import java.util.Random;

public class Tabell {

    private Tabell() {}

    // bytt -------------------------------------------------------------------

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

    // lag permutasjonar ----------------------------------------------------------

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

    // maks -------------------------------------------------------------------

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

    // min --------------------------------------------------------------------

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

    // nestMaks og nestMin ----------------------------------------------------

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

    // telle inversjonar ---------------------------------------------------------

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

    // sortering --------------------------------------------------------------

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

    // søkemetodar ------------------------------------------------------------

    public static int usortertsøk(int[] tabell, int verdi){
        for (int i = 0; i < tabell.length; i++){
            if (tabell[i] == verdi){
                return i;
            }
        }
        return -1;
    }

    public static int lineærsøk(int[] a, int verdi) // copypaste fra pensum
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }
}
