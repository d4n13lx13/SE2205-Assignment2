package LA2Q2;

public class StudentGrade implements Comparable<StudentGrade> {

    private String firstName, lastName;
    private int grade;

    public StudentGrade(String firstName, String lastName, int grade) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }


    /**
     * setLastName() method sets a new last name for the object
     *
     * @param name new last name
     */

    public void setLastName(String name) {
        this.lastName = name;
    }

    /**
     * setGrade() method sets a new grade for the object
     *
     * @param grade new grade
     */

    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * getFirstName() method returns the current first name of the object
     *
     * @return the current first name of the object
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getlastName() method returns the current last name of the object
     *
     * @return the current last name of the object
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getGrade() method returns the current grade of the object
     *
     * @return the current grade of the object
     */
    public int getGrade() {
        return grade;
    }

    /**
     * toString() method returns a string representation of the first name, last name, and grade
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return String.format("%-10s %-10s : %d\n", getFirstName(), getLastName(), getGrade());
    }

    /**
     * compareTo() method compares the grades between 2 StudentGrade objects
     *
     * @param o other StudentGrade object
     * @return whether the grade is less than, greater than, or equal to
     */
    public int compareTo(StudentGrade o) {
        if (this.getGrade() > o.getGrade()) {
            return 1;
        } else if (this.getGrade() < o.getGrade()) {
            return -1;
        } else {
            return 0;
        }
    }
}
