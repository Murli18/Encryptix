package com.encryptix;

import java.util.Scanner;

public class ATM {
    private double balance = 1000.00; // Starting balance

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. ");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is ₹" + balance);
    }

    private void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.showMenu();
    }
}
