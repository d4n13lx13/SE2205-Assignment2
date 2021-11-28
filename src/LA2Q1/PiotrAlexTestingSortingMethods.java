package LA2Q1;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.Vector;

public class PiotrAlexTestingSortingMethods
{
    //Our implementation of merge sort based off class notes: Unit 4_3 Companion QMR pg 1
    public static <T extends Comparable<? super T>>long mergeSort(T[] arr)
    {
        long time;
        time = System.nanoTime(); //time start

        int n = arr.length;
        if (n < 2) return 0;

        int mid = n/2;
        T[] top = Arrays.copyOfRange(arr, 0, mid);
        T[] bot = Arrays.copyOfRange(arr, mid, n);

        mergeSort(top);
        mergeSort(bot);

        int i = 0, j = 0;
        while (i + j < arr.length)
        {
            if (j == bot.length || (i < top.length && top[i].compareTo(bot[j]) < 0))
                arr[i+j] = top[i++];
            else
                arr[i+j] = bot[j++];
        }

        time = System.nanoTime() - time; //time end
        return time;
    }
    //Our implementation of quick sort based off class notes: Unit 4_3 Advanced Sorting Algorithms slide 40
    public  static <T extends Comparable<? super T>>long quickSort(T[] arr, int a, int b)
    {
        long time = System.nanoTime(); //time start

        if (a >= b) return 0;

        T pivot = arr[b];
        int l = a, r = b-1;

        while (l <= r)
        {
            while (l <= r && arr[l].compareTo(pivot) <= 0 )
            {
                l = l + 1;
            }
            while (l <= r && arr[r].compareTo(pivot) >= 0 )
            {
                r = r - 1;
            }
            if (l < r)
            {
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
    //Our implementation of selection sort based off class notes: Unit 4_2 Simple Sorting Algorithms slide 23
    public static <T extends Comparable<? super T>> long selectionSort(T[] arr)
    {
        long time = System.nanoTime(); //time start

        for (int i = 0; i < arr.length; i++)
        {
            int nextSmallest = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j].compareTo(arr[nextSmallest]) < 0)
                {
                    nextSmallest = j;
                }
                T temp = arr[i];
                arr[i] = arr[nextSmallest];
                arr[nextSmallest] = temp;
            }
        }

        time = System.nanoTime() - time;
        return time;
    }
    //Our implementation of bubble sort based off class notes: Unit 4_2 Simple Sorting Algorithms slide 9
    public static <T extends Comparable<? super T>> long bubbleSort(T[] arr)
    {
        long time = System.nanoTime(); //time start

        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - i; j++)
            {
                if(arr[j].compareTo(arr[j+1]) > 0)
                {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        time = System.nanoTime() - time; //time end
        return time;
    }
    //Our implementation of insertion sort based off class notes: Unit 4_2 Simple Sorting Algorithms slide 17
    public static < T extends Comparable <? super T >> long insertionSort(T[] arr)
    {
        long time = System.nanoTime(); //start time

        for (int i = 0; i < arr.length; i++)
        {
            T key = arr[i];
            for (int j = i - 1; j >= 0 && arr[j].compareTo(key) > 0; j--)
            {
                arr[j+1] = arr[j];
                arr[j] = key;
            }
        }

        time = System.nanoTime() - time;
        return time;
    }
    //Our implementation of bucket sort based off class notes: Unit 4_3 Companion QMR pg 8-9
    public static long bucketSort(Integer[] arr, int first, int last, int maxDigits)
    {
        long time = System.nanoTime(); //time start

        Vector<Integer>[] bucket = new Vector[10];

        for (int i = 0; i < bucket.length; i++)
            bucket[i] = new Vector<>();

        for (int i = 0; i < maxDigits; i++)
        {
            for (int j = 0; j < bucket.length; j++)
                bucket[j].removeAllElements();

            for (int index = first; index <= last; index++)
            {
                Integer digit = findDigit(arr[index], i);
                bucket[digit].add(arr[index]);
            }

            int index = 0;
            for (int m = 0; m < bucket.length; m++)
            {
                for (int n = 0; n < bucket[m].size(); n++)
                    arr[index++] = bucket[m].get(n);
            }
        }

        time = System.nanoTime() - time; //time end
        return time;
    }
    //additional function for bucket sort
    private static Integer findDigit(int n, int i)
    {
        int t = 0;
        for (int j = 0; j <= i; j++)
        {
            t = n % 10;
            n = n / 10;
        }
        return t;
    }
}
