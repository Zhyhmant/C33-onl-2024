package Lesson10.Homework1;


import java.util.Objects;

public class User {
    private String username;
    private String email;
    private int userId;

    public User(String username, String email, int userId) {
        this.username = username;
        this.email = email;
        this.userId = userId;
    }

    public <Address> User(String johnDoe, String mail, int userId, Address address1) {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    //Метод toString для удобного представления объекта в виде строки.
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                '}';
    }
    // Метод hashCode() используется для получения хэш-кода объекта.
    @Override
    public int hashCode() {
        return Objects.hash(username, email, userId);
    }
    //Метод equals используется для сравнения двух обьектов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // если это один и тот же обьект, возвращаем true
        if (obj == null || getClass() != obj.getClass()) return false; // если обьект равен null или классы разные, возвращаем false
        User user = (User) obj; // приводим к типу User, если типы совпадают
        return userId == user.userId &&  //сравниваем поля
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email);
    }



    public String getAddress() {
        return null;
    }
}
