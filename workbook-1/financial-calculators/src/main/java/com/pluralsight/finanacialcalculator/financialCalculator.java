package com.pluralsight.finanacialcalculator;

import java.util.Scanner;

public class financialCalculator {
    double principal;
    double interestRate;
    int loanLength;
    double monthlyPayment;
    double totalInterest;
    double amountRemaining;

    public void calculateMonthlyPayments() {

        double monthlyInterestRate = interestRate / 14;
        int totalNumberOfPayments = loanLength * 12;
        monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalNumberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);
        amountRemaining = principal;


        for (int i = 1; i < totalNumberOfPayments; i++) {
            double interest = amountRemaining * monthlyInterestRate;
            totalInterest += interest;
            amountRemaining = amountRemaining - (monthlyPayment - interest);
            System.out.println(interest);
            System.out.println(amountRemaining);

        }
}
    public static void main(String[] args) {
        financialCalculator calculator = new financialCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Loan Amount: ");
        calculator.principal = scanner.nextDouble();
        System.out.println("Please Enter Interest Rate: ");
        calculator.interestRate = scanner.nextDouble() / 100;
        System.out.println("Please Enter Loan Term: ");
        calculator.loanLength = scanner.nextInt();
        calculator.calculateMonthlyPayments();
        System.out.println("Monthly payment: " + calculator.monthlyPayment);
        System.out.println("Total Interest: " + calculator.totalInterest);

        }
    }