public class Student {
    private String name;
    private int age;
    private String group;

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return (age == student.age && name.equals(student.name) && group.equals(student.group));
    }

    @Override
    public int hashCode() {
        return (int) (31 * age + ((name == null) ? 0 : name.hashCode()) + ((group == null) ? 0 : group.hashCode()));
    }
}
