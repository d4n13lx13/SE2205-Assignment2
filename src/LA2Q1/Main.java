package LA2Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main (String[] args)
    {
        header();

        Integer[] arr1 = new Integer[50000];
        int sz = arr1.length;
        Integer[] arr2 = new Integer[sz];

        for(int i=0; i<arr1.length; i++)
        {
            arr1[i] = ((int)(Math.random()*(sz-1)))+1 ;
        }
        System.arraycopy(arr1,0, arr2, 0, sz);
        //System.out.println("Unsorted Array: " + Arrays.toString(arr1));


        double start, finish, timeTaken;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(List.of(arr1));
        start = System.nanoTime();
        Collections.sort(arrayList);
        finish = System.nanoTime();
        //System.out.println(arrayList.toString());
        timeTaken = (finish - start)/(Math.pow(10,6));
        System.out.println("Collections Sorting Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));


        //System.out.println("\n\n");

        timeTaken = (PiotrAlexTestingSortingMethods.selectionSort(arr1))/(Math.pow(10,6));
        System.out.println("Our Selection-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz);

        timeTaken = (PiotrAlexTestingSortingMethods.bubbleSort(arr1))/(Math.pow(10,6));
        System.out.println("Our Bubble-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz);

        timeTaken = (PiotrAlexTestingSortingMethods.mergeSort(arr1))/(Math.pow(10,6));
        System.out.println("Our Merge-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz);

        timeTaken = (PiotrAlexTestingSortingMethods.quickSort(arr1, 0, arr1.length - 1))/(Math.pow(10,6));
        System.out.println("Our Quick-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz);

        timeTaken = (PiotrAlexTestingSortingMethods.bucketSort(arr1, 0, arr1.length - 1, 5))/(Math.pow(10,6));
        System.out.println("Our Merge-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz);

        footer();
    }

    static void header()
    {
        System.out.println("" +
                "*******************************************************************************\n" +
                "Names: Alexander and Piotr\n" +
                "Student Numbers: 251095362 and #########\n" +
                "Goal of this project: This project will sort an integer array using Selection,\n" +
                "Bubble, Insertion, Merge, Quick, and Bucket sorting. The time taken for each\n" +
                "sorting method will be outputted to the console to compare the time of each.\n" +
                "*******************************************************************************");
    }
    static void footer()
    {
        System.out.println("" +
                "***********************************************************\n" +
                "This is ____ on ____\n" +
                "Completion of Lab Assignment 2, Question 1 is successful!\n" +
                "Good bye! Alexander Van Hoeve and Piotr Nowak\n" +
                "***********************************************************\n");
    }

}
