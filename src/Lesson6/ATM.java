package Lesson6;

import java.util.Arrays;

public class ATM {
    private int num20;
    private int num50;
    private int num100;

    public ATM(int num20, int num50, int num100) {
        this.num20 = num20;
        this.num50 = num50;
        this.num100 = num100;
    }

    public void addMoney(int num20, int num50, int num100) {
        this.num20 += num20;
        this.num50 += num50;
        this.num100 += num100;
    }


    public boolean withdrawMoney(int amount) {
        if (amount <= 0) {
            System.out.println("The withdrawal amount must be positive.");
            return false;
        }

        int[] banknotes = {100, 50, 20};
        int[] counts = {num100, num50, num20};
        int[] dispensed = new int[3];

        for (int i = 0; i < 3; i++) {
            int banknoteValue = banknotes[i];
            int availableCount = counts[i];
            while (amount >= banknoteValue && availableCount > 0) {
                amount -= banknoteValue;
                dispensed[i]++;
                availableCount--;
            }
        }

        if (amount == 0) {
            num100 -= dispensed[0];
            num50 -= dispensed[1];
            num20 -= dispensed[2];
            System.out.println("Issued:");
            System.out.println("100 bills: " + dispensed[0]);
            System.out.println("50 bills " + dispensed[1]);
            System.out.println("20 bills " + dispensed[2]);
            return true;
        } else {
            System.out.println("It is impossible to issue the amount " + amount + " with the available bills.");
            return false;
        }
    }


    public static void main(String[] args) {
        ATM atm = new ATM(1, 1, 1); // Создаем банкомат с начальным запасом купюр

        atm.addMoney(5000, 3, 7); // Добавляем деньги
        System.out.println(atm.withdrawMoney(10)); // Снимаем деньги
        System.out.println(atm.withdrawMoney(70)); // Снимаем деньги
        System.out.println(atm.withdrawMoney(350)); // Снимаем деньги

        // Проверка с недостаточными купюрами
        System.out.println(atm.withdrawMoney(1000));
    }
}




