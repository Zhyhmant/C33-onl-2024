package Lesson15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    public Student(String name,String group,int course,List<Integer> grades){
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }
    public double getAverageGrade(){
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
    class StudentManager {
        public static void removeLowPerFormers(List<Student> students){
            students.removeIf(student -> student.getAverageGrade() < 3);
            for (Student student : students){
                student.course++;
            }
        }
    public static void printStudents(List<Student> students,int course){
            students.stream()
                    .filter(student -> student.course == course)
                    .forEach(student -> System.out.println(student.name));
    }

        public static void main(String[] args) {
            List<Student> students = new ArrayList<>(Arrays.asList(
                    new Student("Aleksei","Group 1",1,Arrays.asList(4,3,5)),
                    new Student("Sergei","Group 2",2,Arrays.asList(2,3,2)),
                    new Student("Polina","Group 3",3,Arrays.asList(5,5,5))
            ));

            removeLowPerFormers(students);
            printStudents(students,2);
        }

}
