package LA2Q1;

import java.lang.*;
import java.util.*;

public class DanielMichaelTestingSortingMethods {

    //Stuff here

    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long start, finish;
        start = System.nanoTime();
        if (a.length < 2)
            return 0;
        for (int i = 0; i < a.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[smallest].compareTo(a[j]) > 0) {
                    smallest = j;
                }
            }
            T temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }

        return System.nanoTime() - start;
    }

    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long start, finish;
        start = System.nanoTime();
        if (a.length < 2)
            return 0;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; (j + 1) <= i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        return System.nanoTime() - start;
    }

    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long start, finish;
        start = System.nanoTime();
        if (a.length < 2)
            return 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    T temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }

        return System.nanoTime() - start;
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] arr, int a, int b) {
        long time = System.nanoTime(); //time start

        if (a >= b) return 0;

        T pivot = arr[b];
        int l = a, r = b - 1;

        while (l <= r) {
            while (l <= r && arr[l].compareTo(pivot) <= 0) {
                l = l + 1;
            }
            while (l <= r && arr[r].compareTo(pivot) >= 0) {
                r = r - 1;
            }
            if (l < r) {
                T temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l = l + 1;
                r = r - 1;
            }
        }
        T temp = arr[l];
        arr[l] = arr[b];
        arr[b] = temp;

        quickSort(arr, a, l - 1);
        quickSort(arr, l + 1, b);

        time = System.nanoTime() - time; //time end
        return time;
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] arr) {
        long start = System.nanoTime(); //time start

        int n = arr.length;
        if (n < 2) return 0;

        int mid = n / 2;
        T[] top = Arrays.copyOfRange(arr, 0, mid);
        T[] bot = Arrays.copyOfRange(arr, mid, n);

        mergeSort(top);
        mergeSort(bot);

        int i = 0, j = 0;
        while (i + j < arr.length) {
            if (j == bot.length || (i < top.length && top[i].compareTo(bot[j]) < 0))
                arr[i + j] = top[i++];
            else
                arr[i + j] = bot[j++];
        }

        return System.nanoTime() - start;
    }

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
