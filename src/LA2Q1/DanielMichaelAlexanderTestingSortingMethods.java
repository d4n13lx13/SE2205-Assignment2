package LA2Q1;

public class DanielMichaelAlexanderTestingSortingMethods {
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
        finish = System.nanoTime();
        return finish - start;
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
        finish = System.nanoTime();
        return finish - start;
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

        finish = System.nanoTime();
        return finish - start;
    }
}
