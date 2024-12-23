package Lesson9.Work;

public class Worker implements Employee{
    private String name;

    public Worker(String name){
        this.name = name;
    }
    @Override
    public void printPosition(){
        System.out.println("Major: Worker");
    }
    public void work(){
        System.out.println("Worker has work ");
    }
}
