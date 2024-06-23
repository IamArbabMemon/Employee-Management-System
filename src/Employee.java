public class Employee {
    private int id,salary,age;
    private String name,department;

    Employee(int id , int salary, int age, String name , String department){
        this.id = id;
        this.salary=salary;
        this.age=age;
        this.name=name;
        this.department=department;
    }

    Employee(int salary, int age, String name , String department){
        this.salary=salary;
        this.age=age;
        this.name=name;
        this.department=department;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
