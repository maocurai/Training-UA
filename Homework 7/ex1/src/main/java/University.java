public final class University implements Cloneable {

    private final String name;
    private final Faculty faculty;

    public University(String name, Faculty faculty) throws CloneNotSupportedException {
        this.name = name;
        this.faculty = faculty.clone();
    }

    public String getName() {
        return name;
    }

    public University setName(String name) throws CloneNotSupportedException {
        return new University(name, this.faculty.clone());
    }

    public Faculty getFaculty() throws CloneNotSupportedException {
        return this.faculty.clone();
    }

    public University setFaculty(Faculty faculty) throws CloneNotSupportedException {
        return new University(name, this.faculty.clone());
    }
}
