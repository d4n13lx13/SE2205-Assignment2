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

    @Override
    public int compareTo(StudentGrade o) {
        return 0;
    }
}
