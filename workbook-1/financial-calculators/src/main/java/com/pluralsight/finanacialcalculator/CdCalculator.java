package com.pluralsight.finanacialcalculator;


    public class CdCalculator {
        double deposit;
        double interestRate;
        int years;
        double futureValue;
        double totalInterest;
        double currentBalance;

        public  void findFutureValue() {
            for (int i = 1; i <= years; i++) {
                totalInterest += currentBalance * (interestRate / 100);
                currentBalance += currentBalance * (interestRate / 100);
                System.out.println(totalInterest);
            }
            futureValue = deposit + totalInterest;


        }

        public static void main(String[] args) {
            CdCalculator calculator = new CdCalculator();
            calculator.deposit = 1000;
            calculator.currentBalance = calculator.deposit;
            calculator.interestRate = 1.75;
            calculator.years = 5;
            calculator.findFutureValue();
            System.out.println("Future Value: " + calculator.futureValue);
            System.out.println("Total Interest: " + calculator.totalInterest);
        }
}
