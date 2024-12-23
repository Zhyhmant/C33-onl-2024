package Lesson9;

import Lesson9.Figure.Cicrcle;
import Lesson9.Figure.Figure;
import Lesson9.Figure.Rectangle;
import Lesson9.Figure.Traingle;
import Lesson9.Person.Adress;
import Lesson9.Person.Person;
import Lesson9.Work.Accountant;
import Lesson9.Work.Director;
import Lesson9.Work.Worker;

public class MyMain {
    public static void main(String[] args) {
       Clone();

    }

    public static void job() {
        Director director = new Director("Ivan Ivanov");
        Worker worker = new Worker("Sergei Petrov");
        Accountant accountant = new Accountant("Sveta Sidorova");

        director.printPosition();
        director.manage();

        worker.printPosition();
        worker.work();

        accountant.printPosition();
        accountant.count();
    }

    public static void geometry() {
        Figure[] figures = new Figure[5];
        figures[0] = new Traingle(3, 4, 5);
        figures[1] = new Rectangle(5, 1);
        figures[2] = new Cicrcle(7);
        figures[3] = new Traingle(6, 8, 10);
        figures[4] = new Rectangle(2, 4);

        int totalPerimeter = 0;
        for (Figure figure : figures) {
            totalPerimeter += (int) figure.calculatePerimeter();
        }
        System.out.println("Sum perimeters all figure " + totalPerimeter);


    }

    public static void Clone() {
        Adress address = new Adress("Minsk", "Pritickogo Str.");
        Person person1 = new Person("Ivan ", 30, address);

        try {
            Person person2 = person1.clone(); // Клонирование объекта Person
            System.out.println("Original person: " + person1);
            System.out.println("Cloned person: " + person2);
            System.out.println("person1 == person2: " + (person1 == person2));

            // Изменяем клонированного человека:
            person2.setName("Petr");
            person2.setAge(25);
            person2.getAddress().setCity("Brest");


            System.out.println("\nModified clone person2: " + person2);
            System.out.println("Original  person1 " + person1);
            System.out.println("Comparison address1 == address2: " + (person1.getAddress() == person2.getAddress()));

        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported: " + e.getMessage());
        }
    }
}





