public class Worker {
    private String name;
    private int age;
    private int category;

    public Worker(String name, int age, int category) {
        this.name = name;
        this.age = age;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((getClass() != obj.getClass()) || obj == null) return false;
        Worker ob = (Worker) obj;
        return name.equals(ob.getName()) && age == ob.getAge() && category == ob.getCategory();
    }

    public int hashCode() {
        return 31* age * category + ((name == null) ? 0 : name.hashCode());
    }
}
