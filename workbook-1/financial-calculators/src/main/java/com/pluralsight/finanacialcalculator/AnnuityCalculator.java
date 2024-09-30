package com.pluralsight.financialcalculator;

import java.util.Scanner;

public class AnnuityCalculator {
    double presentValue;
    double totalNumberOfPayments;
    double interestRate;
    double monthlyPayment;

    public void findPresentValue() {
        presentValue = 0; // Resetting presentValue
        double monthlyInterestRate = interestRate / 12;
        for (int i = 1; i <= totalNumberOfPayments; i++) {
            presentValue += monthlyPayment / Math.pow(1 + monthlyInterestRate, i);
        }
    }

    public void findMonthlyPayment() {
        double monthlyInterestRate = interestRate / 12;
        if (interestRate == 0) {
            monthlyPayment = presentValue / totalNumberOfPayments; // Handle zero interest rate
        } else {
            monthlyPayment = (presentValue * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments));
        }
    }

    public void findTotalNumberOfPayments() {
        double monthlyInterestRate = interestRate / 12;
        if (monthlyPayment == 0) {
            System.out.println("Monthly payment cannot be zero.");
            return; // Prevent calculation with zero monthly payment
        }
        totalNumberOfPayments = -Math.log(1 - (presentValue * monthlyInterestRate) / monthlyPayment) / Math.log(1 + monthlyInterestRate);
    }

    public static void main(String[] args) {
        AnnuityCalculator calculator = new AnnuityCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 to calculate the present value\nEnter 2 to calculate the monthly payment\nEnter 3 to calculate the total number of payments");
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            System.out.println("Enter Monthly Payment: ");
            calculator.monthlyPayment = scanner.nextDouble();
            System.out.println("Enter Total Number of Payments: ");
            calculator.totalNumberOfPayments = scanner.nextDouble();
            System.out.println("Enter Annual Interest Rate: ");
            calculator.interestRate = scanner.nextDouble() / 100;
            calculator.findPresentValue();
            System.out.println("Present Value: " + calculator.presentValue);
        } else if (userInput == 2) {
            System.out.println("Enter Present Value: ");
            calculator.presentValue = scanner.nextDouble();
            System.out.println("Enter Total Number of Payments: ");
            calculator.totalNumberOfPayments = scanner.nextDouble();
            System.out.println("Enter Annual Interest Rate: ");
            calculator.interestRate = scanner.nextDouble() / 100;
            calculator.findMonthlyPayment();
            System.out.println("Monthly Payment: " + calculator.monthlyPayment);
        } else if (userInput == 3) {
            System.out.println("Enter Present Value: ");
            calculator.presentValue = scanner.nextDouble();
            System.out.println("Enter Monthly Payment: ");
            calculator.monthlyPayment = scanner.nextDouble();
            System.out.println("Enter Annual Interest Rate: ");
            calculator.interestRate = scanner.nextDouble() / 100;
            calculator.findTotalNumberOfPayments();
            System.out.println("Total Number of Payments: " + calculator.totalNumberOfPayments);
        } else {
            System.out.println("Invalid input");
        }

        scanner.close();
    }
}


