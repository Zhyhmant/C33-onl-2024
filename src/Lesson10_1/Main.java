package Lesson10_1;

import java.util.Objects;
import java.util.Scanner;

class Address implements Cloneable{
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address)super.clone(); // клонируем обьект Address
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}


class User implements Cloneable {
    private String username;
    private String email;
    private int userId;
    private Address address;

    public User(String username, String email, int userId, Address address) {
        this.username = username;
        this.email = email;
        this.userId = userId;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
    }

    public Address getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    //Метод toString для удобного представления объекта в виде строки.
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                ", address=" + address +
                '}';
    }
    // Метод hashCode() используется для получения хэш-кода объекта.
    @Override
    public int hashCode() {
        return Objects.hash(username, email, userId, address);
    }
    //Метод equals используется для сравнения двух обьектов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // если это один и тот же обьект, возвращаем true
        if (obj == null || getClass() != obj.getClass()) return false; // если обьект равен null или классы разные, возвращаем false
        User user = (User) obj; // приводим к типу User, если типы совпадают
        return userId == user.userId &&  //сравниваем поля
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(address, user.address);
    }
    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone(); // Создается поверхностная копия объекта
    }
    public User deepClone() throws CloneNotSupportedException {
        User clonedUser = (User) super.clone(); // Создается клон обьекта User
        clonedUser.address = this.address.clone(); //Клонируется вложенный обьект, address
        return clonedUser;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Address address1 = new Address("Minsk", "Nezavisimosti");
        User user1 = new User("john_doe", "john.doe@example.com", 123, address1);
        System.out.println("Оригинальный пользователь: " + user1);
        while (true){
            System.out.println("Выберите тип клонирования (поверхностное/глубокое) или exit для выхода: ");
            String cloneType = scanner.nextLine();

            if (cloneType.equalsIgnoreCase("exit")) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                if (cloneType.equalsIgnoreCase("поверхностное")){
                    User clonedUser = user1.clone();
                    testClone(user1, clonedUser, "Поверхностное клонирование");

                } else if(cloneType.equalsIgnoreCase("глубокое")){
                    User clonedUser = user1.deepClone();
                    testClone(user1, clonedUser, "Глубокое клонирование");

                } else {
                    System.out.println("Неверный ввод, попробуйте еще раз. ");
                }
            } catch (CloneNotSupportedException e) {
                System.out.println("Клонирование не поддерживается: " + e.getMessage());
            }
        }
        scanner.close();
    }
    public static void testClone(User originalUser, User clonedUser, String cloneType){
        System.out.println("----------------------------------------");
        System.out.println(cloneType + " :");
        System.out.println("Оригинальный пользователь: " + originalUser);
        System.out.println("Клонированный пользователь: " + clonedUser);

        System.out.println("Сравнение: " + (originalUser == clonedUser));
        System.out.println("Сравнение адресов до изменения: " + (originalUser.getAddress() == clonedUser.getAddress()));

        clonedUser.setUsername("test_user");
        clonedUser.setUserId(456);
        clonedUser.getAddress().setCity("Brest");

        System.out.println("Оригинальный пользователь (после изменения клона): " + originalUser);
        System.out.println("Клонированный пользователь (после изменения клона): " + clonedUser);
        System.out.println("Сравнение адресов после изменения: " + (originalUser.getAddress() == clonedUser.getAddress()));
        System.out.println("----------------------------------------");

    }

}

