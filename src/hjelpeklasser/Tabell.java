package hjelpeklasser;

import java.util.Arrays;
import java.util.Random;

public class Tabell {

    private Tabell() {}

    public static void bytt(int[] tabell, int k, int i){
        int temp = tabell[k];
        tabell[k] = tabell[i];
        tabell[i] = temp;
    }

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
}
