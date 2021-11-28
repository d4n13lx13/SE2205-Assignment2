package LA2Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DriverClass {

    public static void main(String[] args) {
        header();

        Integer[] arr = new Integer[50000];
        Integer[] arr2 = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * (arr.length - 1))) + 1;
        }
        System.arraycopy(arr, 0, arr2, 0, arr.length);


        double start, finish, timeTaken;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(List.of(arr));
        start = System.nanoTime();
        Collections.sort(arrayList);
        System.out.println("Collections Sorting Time: " + (System.nanoTime() - start) / (Math.pow(10, 6))+ " milliseconds");

        //selection sort
        System.out.println("Selection-Sort Time: " + (DanielMichaelTestingSortingMethods.selectionSort(arr)) / (Math.pow(10, 6)) + " milliseconds");
        System.arraycopy(arr2, 0, arr, 0, arr.length);

        //bubble sort
        System.out.println("Bubble-Sort Time: " + (DanielMichaelTestingSortingMethods.bubbleSort(arr)) / (Math.pow(10, 6))+ " milliseconds");
        System.arraycopy(arr2, 0, arr, 0, arr.length); // copy the array again

        //insertion sort
        System.out.println("Insertion-Sort Time: " + (DanielMichaelTestingSortingMethods.insertionSort(arr)) / (Math.pow(10, 6)) + " milliseconds");
        System.arraycopy(arr2, 0, arr, 0, arr.length); // copy the array again

        //merge sort
        System.out.println("Merge-Sort Time: " + (DanielMichaelTestingSortingMethods.mergeSort(arr)) / (Math.pow(10, 6)) + " milliseconds");
        System.arraycopy(arr2, 0, arr, 0, arr.length); // copy the array again

        //quick sort
        System.out.println("Quick-Sort Time: " + (DanielMichaelTestingSortingMethods.quickSort(arr, 0, arr.length - 1)) / (Math.pow(10, 6)) + " milliseconds");
        System.arraycopy(arr2, 0, arr, 0, arr.length); // copy the array again

        //bucket sort
;
        System.out.println("Bucket-Sort Time: " + (DanielMichaelTestingSortingMethods.bucketSort(arr, 0, arr.length - 1, 5)) / (Math.pow(10, 6)) + " milliseconds");
        System.arraycopy(arr2, 0, arr, 0, arr.length); // copy the array again

        footer();
    }

    static void header() {
        System.out.println("*****************************************************************************************************" +
                "\nNames: Daniel and Michael" +
                "\nStudent Numbers: 251076275 and 251110243" +
                "Goal of this project: This project will sort an Integer array using generic Selection, Bubble, Insertion, Merge, Quick, and (Integer) Bucket sorting.\n"+
                "The time take for each type of sorting will be displayed to show time efficiencies of each sorting algorithm.\n" +
                "*******************************************************************************");
    }

    static void footer() {
        System.out.println("" +
                "***********************************************************\n" +
                "This is ____ on ____\n" +
                "Completion of Lab Assignment 2, Question 1 is successful!\n" +
                "Good bye! Alexander Van Hoeve and Piotr Nowak\n" +
                "***********************************************************\n");
    }

}