package LA2Q1;

import java.util.Arrays;

public class PiotrAlexTestingSortingMethods
{
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

    public static <T extends Comparable<? super T>> long selectionSort(T[] arr)
    {
        long time;
        time = System.nanoTime(); //time start
        if (arr.length < 2)
            return 0;
        for (int i = 0; i < arr.length; i++)
        {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[smallest].compareTo(arr[j]) > 0)
                {
                    smallest = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        time = System.nanoTime() - time;
        return time;
    }

    public static <T extends Comparable<? super T>> long bubbleSort(T[] a)
    {
        long start, finish;
        start = System.nanoTime();
        if(a.length < 2)
            return 0;
        for (int i = a.length - 1; i > 0; i--)
        {
            for (int j = 0; (j + 1) <= i; j++)
            {
                if(a[j].compareTo(a[j+1]) > 0)
                {
                    T temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        finish = System.nanoTime();
        return finish - start;
    }

}
