public class Main {
    public static void main(String[] args) {
        Student studentOb1 = new Student("Marina", 19, "TV-91");
        Student studentOb2 = new Student("Marina", 19, "TV-91");
        System.out.println(studentOb1.equals(studentOb2));

        Faculty facultyOb1 = new Faculty("TEF", 5000);
        try {
            University universityOb1 = new University("KPI", facultyOb1);
            System.out.println(universityOb1.getFaculty().getName());
            facultyOb1.setName("IASA");
            System.out.println(universityOb1.getFaculty().getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
