package LA2Q2;

public class StudentGrade implements Comparable<StudentGrade>
{
    public StudentGrade(String firstName, String lastName, int grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    private String firstName, lastName;
    private int grade;

    public void setFirstName(String name)
    {
        this.firstName = name;
    }

    public void setLastName(String name)
    {
        this.lastName = name;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s : %d\n", getFirstName(), getLastName(), getGrade());
    }

    @Override
    public int compareTo(StudentGrade o) {
        if (this.getGrade() > o.getGrade())
            return 1;
        else if (this.getGrade() < o.getGrade()) {
            return -1;
        } else {
            return 0;
        }
    }
}
