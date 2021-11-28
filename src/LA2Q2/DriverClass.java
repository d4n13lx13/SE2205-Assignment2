package LA2Q2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DriverClass {
    public static void main(String[] args) {
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};

        header();

        Vector<StudentGrade> sg = new Vector<>();

        for (int i = 0; i < fnArray.length; i++) {
            sg.add(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }

        System.out.println("Unsorted Array: ");
        for (int i = 0; i < sg.size(); i++) {
            System.out.printf(sg.get(i).toString());
        }

        Collections.sort(sg);
        System.out.println("\nSorted by Grades: ");
        for (int i = 0; i < sg.size(); i++) {
            System.out.printf(sg.get(i).toString());
        }

        StudentGrade stgrd[] = new StudentGrade[fnArray.length];
        sg.copyInto(stgrd);

        sortMethod(stgrd, 1);
        System.out.println("\nSorted by First Names: ");
        for (int i = 0; i < stgrd.length; i++) {
            System.out.printf(stgrd[i].toString());
        }

        sortMethod(stgrd, 2);
        System.out.println("\nSorted by Last Names: ");
        for (int i = 0; i < stgrd.length; i++) {
            System.out.printf(stgrd[i].toString());
        }

        footer();
    }

    public static void sortMethod(StudentGrade[] stgrd, int key) {
        if (stgrd.length < 2)
            return;

        int mid = stgrd.length / 2;

        StudentGrade[] t = Arrays.copyOfRange(stgrd, 0, mid);
        StudentGrade[] b = Arrays.copyOfRange(stgrd, mid, stgrd.length);

        sortMethod(t, key);
        sortMethod(b, key);

        int i = 0, j = 0;
        while (i + j < stgrd.length) {
            if (key == 1) {
                if (j == b.length || (i < t.length && t[i].getFirstName().compareTo(b[j].getFirstName()) < 0))
                    stgrd[i + j] = t[i++];
                else
                    stgrd[i + j] = b[j++];
            } else if (key == 2) {
                if (j == b.length || (i < t.length && t[i].getLastName().compareToIgnoreCase(b[j].getLastName()) < 0))
                    stgrd[i + j] = t[i++];
                else
                    stgrd[i + j] = b[j++];
            }
        }

    }

    public static void header() {
        System.out.println("*****************************************************************************************************" +
                "\nNames: Daniel and Michael" +
                "\nStudent Numbers: 251076275 and 251110243" +
                "\nGoal of this project: To sort an array of students by their grades, first names, and last names." +
                "\n*****************************************************************************************************");
    }

    public static void footer() {
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
