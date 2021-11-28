package LA2Q1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DriverClass {

    public static void main(String[] args) {
        header();

        Integer[] arr1 = new Integer[50000];
        int sz = arr1.length;
        Integer[] arr2 = new Integer[sz];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = ((int) (Math.random() * (sz - 1))) + 1;
        }
        System.arraycopy(arr1, 0, arr2, 0, sz);


        double start, finish, timeTaken;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(List.of(arr1));
        start = System.nanoTime();
        Collections.sort(arrayList);
        finish = System.nanoTime();
        //System.out.println(arrayList.toString());
        timeTaken = (finish - start) / (10 ^ 6);
        System.out.println("Collections Sorting Time: " + (timeTaken) + " milliseconds");


        //System.out.println("\n\n");

        timeTaken = (DanielMichaelTestingSortingMethods.selectionSort(arr1)) / (10 ^ 6);
        System.out.println("Our Selection-Sort Time: " + (timeTaken) + " milliseconds");
        System.arraycopy(arr2, 0, arr1, 0, sz);


        footer();
    }

    static void header() {
        System.out.println("*****************************************************************************************************" +
                "\nNames: Daniel and Michael" +
                "\nStudent Numbers: 251076275 and 251110243" +
                "\nGoal of this project: This project will sort a generic array using Selection Bubble, Insertion, Merge, Quick, and Bucket sorting and an integer array for bucketSort." +
                "\nThe time taken for each sorting method will be outputted to the console to compare the time of each." +
                "*******************************************************************************");
    }

    static void footer() {
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("hh:mm");

        System.out.println("**********************************************************" +
                "\nThis is " + currentTime.format(dt1) + " on " + currentDate +
                "\nCompletion of Lab Assignment 2 is successful!" +
                "\nGood bye! Daniel Xie and Michael Wong" +
                "\n**********************************************************");
    }

}
