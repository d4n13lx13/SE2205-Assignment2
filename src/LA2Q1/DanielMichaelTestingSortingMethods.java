package LA2Q1;

import java.lang.*;
import java.util.*;

public class DanielMichaelTestingSortingMethods {
    /**
     * the selectionSort method sorts a generic array using the selection sorting algorithm
     *
     * @param a - array to be sorted
     * @return the time taken to sort the array
     */
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        // start time
        long start = System.nanoTime();
        // if the array has less than 2 elements
        if (a.length < 2)
            return 0;
        for (int i = 0; i < a.length; i++) {
            int smallest = i;
            // Compare all the elements in the array with smallest index
            for (int j = i + 1; j < a.length; j++) {
                // if the element is found to be smaller, set smallest as the new found smallest index
                if (a[smallest].compareTo(a[j]) > 0) {
                    smallest = j;
                }
            }
            // swap the elements in the array
            T temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
        // finish time
        return System.nanoTime() - start;
    }

    /**
     * the bubbleSort method sorts a generic array using the bubble sorting algorithm
     *
     * @param a - array to be sorted
     * @return the time taken to sort the array
     */
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        // start time
        long start = System.nanoTime();
        // if the array has less than 2 elements
        if (a.length < 2)
            return 0;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; (j + 1) <= i; j++) {
                // compares the current element to the next consecutive element
                if (a[j].compareTo(a[j + 1]) > 0) {
                    // swap the elements in the array if the smaller index is bigger
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        // finish time
        return System.nanoTime() - start;
    }

    /**
     * the insertionSort method sorts a generic array using the insertion sorting algorithm
     *
     * @param a - array to be sorted
     * @return the time taken to sort the array
     */
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        // start time
        long start = System.nanoTime();
        // if the array has less than 2 elements
        if (a.length < 2)
            return 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                // compares the current element in the array with next smaller consecutive element
                if (a[j].compareTo(a[j - 1]) < 0) {
                    // swap the elements in the array if the bigger index is smaller
                    T temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        // finish time
        return System.nanoTime() - start;
    }


    /**
     * the quickSort method sorts a generic array using the quick sorting algorithm
     *
     * @param a - array to be sorted
     * @return the time taken to sort the array
     */
    public static <T extends Comparable<? super T>> long quickSort(T[] arr, int a, int b) {
        // start time
        long time = System.nanoTime();

        if (a >= b)
            return 0;

        // create a pivot element
        T pivot = arr[b];
        int l = a, r = b - 1;

        // while left is less than or equal to right
        while (l <= r) {
            // if less is less than or equal to right and is less than the pivot
            while (l <= r && arr[l].compareTo(pivot) <= 0) {
                // increment left
                l = l + 1;
            }
            // if less is less than or equal to right and right is greater than the pivot
            while (l <= r && arr[r].compareTo(pivot) >= 0) {
                // decrement right
                r = r - 1;
            }
            if (l < r) {
                // swap the elements in the array
                T temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l = l + 1;
                r = r - 1;
            }
        }
        // swap the elements in the array
        T temp = arr[l];
        arr[l] = arr[b];
        arr[b] = temp;

        quickSort(arr, a, l - 1);
        quickSort(arr, l + 1, b);
        // finish time
        time = System.nanoTime() - time;
        return time;
    }

    /**
     * the mergeSort method sorts a generic array using the merge sorting algorithm
     *
     * @param a - array to be sorted
     * @return the time taken to sort the array
     */
    public static <T extends Comparable<? super T>> long mergeSort(T[] arr) {
        // start time
        long start = System.nanoTime();

        int n = arr.length;
        // if the number of elements in the array is less than 2
        if (n < 2)
            return 0;

        // split the array in half
        int mid = n / 2;
        T[] top = Arrays.copyOfRange(arr, 0, mid);
        T[] bot = Arrays.copyOfRange(arr, mid, n);

        // sort the top array using recursion
        mergeSort(top);
        // sort the bottom array using recursion
        mergeSort(bot);

        int i = 0, j = 0;
        while (i + j < arr.length) {
            if (j == bot.length || (i < top.length && top[i].compareTo(bot[j]) < 0))
                arr[i + j] = top[i++];
            else
                arr[i + j] = bot[j++];
        }

        // finish time
        return System.nanoTime() - start;
    }

    /**
     * the bucketSort method sorts an integer array using the bucket sorting algorithm.
     *
     * @param a - array to be sorted
     * @return the time taken to sort the array
     */
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long start = System.nanoTime();
        Vector<Integer>[] buckets = new Vector[10]; //using radix 10

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Vector<>();

        for (int j = 0; j < maxDigits; j++) {
            for (int k = 0; k < buckets.length; k++)
                buckets[k].removeAllElements();

            for (int l = first; l <= last; l++) {
                Integer digit = findDigit(a[l], j); //puts element in the correct bucket
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


    public static Integer findDigit(int n, int i) { //finds correct radix for element n
        int t = 0;
        for (int j = 0; j <= i; j++) {
            t = n % 10;
            n = n / 10;
        }
        return t;
    }

}
