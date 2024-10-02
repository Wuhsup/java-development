package com.pluralsight.financialcalculator;

import java.util.Scanner;

public class Main {

    // Mortgage Calculator
    static class MortgageCalculator {
        double principal; // Loan amount
        double interestRate; // Annual interest rate
        int loanLength; // Loan term in years
        double monthlyPayment; // Monthly payment amount
        double totalInterest; // Total interest paid

        public void calculateMonthlyPayments() {
            double monthlyInterestRate = interestRate / 12; // Monthly interest
            int totalNumberOfPayments = loanLength * 12; // Total payments

            // Monthly payment formula
            monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalNumberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);

            double amountRemaining = principal;

            // Calculate total interest
            for (int i = 1; i <= totalNumberOfPayments; i++) {
                double interest = amountRemaining * monthlyInterestRate;
                totalInterest += interest;
                amountRemaining -= (monthlyPayment - interest);
            }
        }
    }

    // CD Calculator
    static class CdCalculator {
        double deposit; // Initial deposit amount
        double interestRate; // Annual interest rate
        int years; // Number of years
        double futureValue; // Future value of the deposit
        double totalInterest; // Total interest earned

        public void findFutureValue() {
            double currentBalance = deposit; // Start with the deposit amount
            // Calculate future value
            for (int i = 1; i <= years; i++) {
                totalInterest += currentBalance * (interestRate / 100);
                currentBalance += currentBalance * (interestRate / 100);
            }
            futureValue = deposit + totalInterest; // Total future value
        }
    }

    // Annuity Calculator
    static class AnnuityCalculator {
        double presentValue; // Present value of annuity
        double totalNumberOfPayments; // Total number of payments
        double interestRate; // Annual interest rate
        double monthlyPayment; // Monthly payment amount

        public void findPresentValue() {
            presentValue = 0; // Resetting present value
            double monthlyInterestRate = interestRate / 12;
            // Calculate present value
            for (int i = 1; i <= totalNumberOfPayments; i++) {
                presentValue += monthlyPayment / Math.pow(1 + monthlyInterestRate, i);
            }
        }

        public void findMonthlyPayment() {
            double monthlyInterestRate = interestRate / 12;
            // Monthly payment calculation
            monthlyPayment = (interestRate == 0)
                    ? presentValue / totalNumberOfPayments
                    : (presentValue * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments));
        }

        public void findTotalNumberOfPayments() {
            double monthlyInterestRate = interestRate / 12;
            // Calculate total number of payments
            totalNumberOfPayments = -Math.log(1 - (presentValue * monthlyInterestRate) / monthlyPayment) / Math.log(1 + monthlyInterestRate);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a calculator: \n1. Mortgage Calculator\n2. CD Calculator\n3. Annuity Calculator");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1
                    : // Mortgage Calculator
                MortgageCalculator mortgageCalculator = new MortgageCalculator();
                System.out.println("Enter Loan Amount: ");
                mortgageCalculator.principal = scanner.nextDouble();
                System.out.println("Enter Interest Rate (%): ");
                mortgageCalculator.interestRate = scanner.nextDouble() / 100;
                System.out.println("Enter Loan Term (years): ");
                mortgageCalculator.loanLength = scanner.nextInt();
                mortgageCalculator.calculateMonthlyPayments();
                System.out.println("Monthly Payment: " + mortgageCalculator.monthlyPayment);
                System.out.println("Total Interest: " + mortgageCalculator.totalInterest);
                break;

            case 2: // CD Calculator
                CdCalculator cdCalculator = new CdCalculator();
                System.out.println("Enter Deposit Amount: ");
                cdCalculator.deposit = scanner.nextDouble();
                System.out.println("Enter Interest Rate (%): ");
                cdCalculator.interestRate = scanner.nextDouble();
                System.out.println("Enter Number of Years: ");
                cdCalculator.years = scanner.nextInt();
                cdCalculator.findFutureValue();
                System.out.println("Future Value: " + cdCalculator.futureValue);
                System.out.println("Total Interest: " + cdCalculator.totalInterest);
                break;

            case 3: // Annuity Calculator
                AnnuityCalculator annuityCalculator = new AnnuityCalculator();
                System.out.println("Enter Present Value: ");
                annuityCalculator.presentValue = scanner.nextDouble();
                System.out.println("Enter Monthly Payment: ");
                annuityCalculator.monthlyPayment = scanner.nextDouble();
                System.out.println("Enter Total Number of Payments: ");
                annuityCalculator.totalNumberOfPayments = scanner.nextDouble();
                System.out.println("Enter Annual Interest Rate (%): ");
                annuityCalculator.interestRate = scanner.nextDouble() / 100;

                System.out.println("Choose calculation: \n1. Present Value\n2. Monthly Payment\n3. Total Number of Payments");
                int annuityChoice = scanner.nextInt();

                switch (annuityChoice) {
                    case 1:
                        annuityCalculator.findPresentValue();
                        System.out.println("Present Value: " + annuityCalculator.presentValue);
                        break;
                    case 2:
                        annuityCalculator.findMonthlyPayment();
                        System.out.println("Monthly Payment: " + annuityCalculator.monthlyPayment);
                        break;
                    case 3:
                        annuityCalculator.findTotalNumberOfPayments();
                        System.out.println("Total Number of Payments: " + annuityCalculator.totalNumberOfPayments);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }

        scanner.close(); // Close scanner
    }
}
