package Lesson9.Person;



public class Person implements Cloneable {
    private String name;
    private int age;
    private Adress address; // Вложенный объект

    public Person(String name, int age, Adress address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    //getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Adress getAddress() {
        return address;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }

    //Переопределенный метод clone, для создания клона обьекта
    @Override
    public Person clone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone(); //Создается клон
        clonedPerson.address = this.address.clone(); //Клонируется вложенный обьект, address

        return clonedPerson;
    }

    @Override
    public String toString() {
        return "Person: " + '\n' +
                "Name: " + name + '\n' +
                "Age: " + age + '\n' +
                "Address: " + address + '\n';
    }
}
