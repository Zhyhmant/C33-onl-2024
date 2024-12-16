package Lesson6;

import java.util.Random;

public class CreditCard {
    private long accountNumber;
    private double balance;

    // Конструктор
    public CreditCard(long accountNumber) {
        this.accountNumber = accountNumber;
        double initialBalance = 10000;
        this.balance = initialBalance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("The amount to be replenished must be positive.");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("There are not enough funds in the account or the withdrawal amount must be positive.");
        }
    }


    public void displayInfo() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        Random random = new Random();
        CreditCard card1 = new CreditCard(random.nextLong() &  1000);
        CreditCard card2 = new CreditCard(random.nextLong() &  500);
        CreditCard card3 = new CreditCard(random.nextLong() & 2000);

        card1.deposit(5055);
        card2.deposit(200);
        card3.withdraw(800);

        System.out.println("Info card number 1:");
        card1.displayInfo();
        System.out.println("\nInfo card number 2:");
        card2.displayInfo();
        System.out.println("\nInfo card nimber 3:");
        card3.displayInfo();
    }
}






