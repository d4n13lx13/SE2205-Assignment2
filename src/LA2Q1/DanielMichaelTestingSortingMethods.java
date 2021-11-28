package LA2Q1;

import java.lang.*;
import java.util.*;

public class DanielMichaelTestingSortingMethods {

    //Stuff here


    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long start = System.nanoTime();
        Vector<Integer>[] buckets = new Vector[10];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Vector<>();

        for (int j = 0; j < maxDigits; j++) {
            for (int k = 0; k < buckets.length; k++)
                buckets[k].removeAllElements();

            for (int l = first; l <= last; l++) {
                Integer digit = findDigit(a[l], j);
                buckets[digit].add(a[l]);
            }

            int idx = 0;
            for (int m = 0; m < buckets.length; m++) {
                for (int n = 0; n < buckets[m].size(); n++)
                    a[idx++] = buckets[m].get(n);
            }

        }

        return System.nanoTime() - start;
    }


    public static Integer findDigit(int n, int i) {
        int t = 0;
        for (int j = 0; j <= i; j++) {
            t = n % 10;
            n = n / 10;
        }
        return t;
    }

}