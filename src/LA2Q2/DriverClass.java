package LA2Q2;

public class DriverClass {
    public static void main(String[] args) {
//call your header method
//Three arrays with 8 first names, 8 last names and 8 randomly
// generated grades between 60 and 85 inclusive have been created below
// for your use Lab Assignment 2 SE2205a QMR 4
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26)};
//create a Vector<> class instance sg with StudentGrade tag.
//Add each StudentGrade object to the Vector class with its add method (Slide #36, Unit 2 Part 2)
//print the unsorted sg contents just by using toString() method (see the sample output)
//sort sg using Collections’ sort method and that will sort the list based on the grade
//print the sorted content by using toString() method (see the sample output)

//Create an array of StudentGrade type with a length of fnArray

//with the help of Vectors copyInto() method, copy sg to StudentGrade array you just created above
//At this point tweak one of the stable sorting methods (your created in Q1), either merge or insertion
// sort that will accept a StudentGrade array and an integer key. Define this public static void method
// outside the driver method below. The key in the method header will decide whether you would like to
// sort the StudentGrade array according to the first name (key = 1) or the last name (key = 2). Once
// done, come back to this place inside the driver and call your sort method with the argument of
// StudentGrade array (you created above) and key = 1 (first names).


//print the sorted array (see the sample output)
// Call your sort method again with the argument of StudentGrade array (you created above) and key = 2.
//print the sorted array (see the sample output)
//call your footer method here
    }
//Your sort method will go here.

}