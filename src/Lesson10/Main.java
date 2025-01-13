package Lesson10;

import Lesson10.Homework1.User;


public class Main {
    public static void main(String[] args) {
        user();
    }

    public static void user() {
        User user1 = new User("john_doe", "john.doe@example.com", 123);
        User user2 = new User("john_doe", "john.doe@example.com", 123);
        User user3 = new User("jane_doe", "jane.doe@example.com", 456);

        System.out.println("User 1: " + user1);
        System.out.println("User 2: " + user2);
        System.out.println("User 3: " + user3);

        System.out.println("user1.equals(user2): " + user1.equals(user2));
        System.out.println("user1.equals(user3): " + user1.equals(user3));
        System.out.println("user1.hashCode(): " + user1.hashCode());
        System.out.println("user2.hashCode(): " + user2.hashCode());
        System.out.println("user3.hashCode(): " + user3.hashCode());

    }
}



