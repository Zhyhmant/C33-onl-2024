package Lesson9.Work;
//  Employee — интерфейс, определяющий метод printPosition().  Этот метод должен выводить название должности.
//  Director, Worker, Accountant — классы, реализующие интерфейс Employee.
//  Каждый класс переопределяет метод printPosition() для вывода соответствующего названия должности.
public class Accountant implements Employee{
    public String name;

    public Accountant(String name){
        this.name = name;
    }
    @Override
    public void printPosition(){
        System.out.println("Major: Accountant");
    }
    public void count(){
        System.out.println("The accountant keeps records");
    }
}
// interface Employee:  Объявление интерфейса Employee. Интерфейс в Java — это  абстрактный тип данных,
// который определяет набор методов, которые должны быть реализованы классами, реализующими этот интерфейс.
// Интерфейс не содержит реализации методов (только сигнатуры — имена методов и типы параметров).

//void printPosition();:  Объявление абстрактного метода printPosition().
// Этот метод не имеет возвращаемого значения (void) и не принимает никаких аргументов.
// Он объявляет контракт: любой класс, реализующий интерфейс Employee, обязан реализовать этот метод.
