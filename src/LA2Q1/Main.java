package LA2Q1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    // Part B the driver method
    public static void main (String[] args)
    {
        // (i) call the header
        header();

        // (ii) and (iii) create two arrays size 50000
        Integer[] arr1 = new Integer[50000];
        int sz = arr1.length;
        Integer[] arr2 = new Integer[sz];

        // (iv) populate the array with values random 1 to 50000
        for(int i=0; i<arr1.length; i++)
        {
            arr1[i] = ((int)(Math.random()*(sz-1)))+1 ;
        }

        // (v) create a copy of the first array in the second
        System.arraycopy(arr1,0, arr2, 0, sz);
        //System.out.println("Unsorted Array: " + Arrays.toString(arr1));

        // (vi) create the convert the array into an ArrayList to do the Collections sort
        // time the collection sort and output the result
        double timeTaken; long start, finish;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(List.of(arr1));
        start = System.nanoTime();
        Collections.sort(arrayList);
        finish = System.nanoTime();
        //System.out.println(arrayList.toString());
        timeTaken = (finish - start)/(Math.pow(10,6));
        System.out.println("Collections Sorting Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));

        // (vii) copy the backup array into the original array to confirm that the unsorted array is the one being used
        System.arraycopy(arr2,0, arr1, 0, sz);

        // time the selection sort
        timeTaken = (PiotrAlexTestingSortingMethods.selectionSort(arr1))/(Math.pow(10,6));
        System.out.println("Our Selection-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz); // copy the array again

        // time the bubble sort
        timeTaken = (PiotrAlexTestingSortingMethods.bubbleSort(arr1))/(Math.pow(10,6));
        System.out.println("Our Bubble-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz); // copy the array again

        // time the insertion sort
        timeTaken = (PiotrAlexTestingSortingMethods.insertionSort(arr1))/(Math.pow(10,6));
        System.out.println("Our Insertion-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz); // copy the array again

        // time the merge sort
        timeTaken = (PiotrAlexTestingSortingMethods.mergeSort(arr1))/(Math.pow(10,6));
        System.out.println("Our Merge-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz); // copy the array again

        // time the quick sort
        timeTaken = (PiotrAlexTestingSortingMethods.quickSort(arr1, 0, arr1.length - 1))/(Math.pow(10,6));
        System.out.println("Our Quick-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz); // copy the array again

        // time the bucket sort
        timeTaken = (PiotrAlexTestingSortingMethods.bucketSort(arr1, 0, arr1.length - 1, 5))/(Math.pow(10,6));
        System.out.println("Our Merge-Sort Time: " + (timeTaken) + " milliseconds");
        //System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.arraycopy(arr2,0, arr1, 0, sz); // copy the array again

        // (x) call the footer
        footer();
    }
    static void header()
    {
        System.out.println("" +
                "*******************************************************************************\n" +
                "Names: Alexander and Piotr\n" +
                "Student Numbers: 251095362 and 251104481\n" +
                "Goal of this project: This project will sort an integer array using Selection,\n" +
                "Bubble, Insertion, Merge, Quick, and Bucket sorting. The time taken for each\n" +
                "sorting method will be outputted to the console to compare the time of each.\n" +
                "*******************************************************************************");
    }
    static void footer()
    {
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");

        System.out.println("" +
                "***********************************************************\n" +
                "This is "+currentTime.format(dtf) + " on " + currentDate + "\n" +
                "Completion of Lab Assignment 2, Question 1 is successful!\n" +
                "Good bye! Alexander Van Hoeve and Piotr Nowak\n" +
                "***********************************************************\n");
    }
}
