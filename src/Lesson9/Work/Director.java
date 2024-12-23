package Lesson9.Work;

public class Director implements Employee {
    private String name;

    public Director(String name){
        this.name = name;
    }
    @Override
    public void printPosition(){
        System.out.println("Major: Director");
    }
    public void manage(){
        System.out.println("Director manage company");
    }
}
