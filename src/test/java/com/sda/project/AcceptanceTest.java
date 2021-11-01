package com.sda.project;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AcceptanceTest {

    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENT = 100;

    @Test
    void givenInput_shouldCalculateMortgage() {
        int principal = 105_000;
        double annualInterest = 4.25D;
        int years = 25;
        int downPayment = 16_000;

        double mortgage = calculateMortgage(principal, annualInterest, years, downPayment);

        assertThat(mortgage).isEqualTo(480);
    }

    // TODO: move to mortgage service
    private double calculateMortgage(
            int principal,
            double annualInterestRate,
            int years,
            int downPayment) {

        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return mortgage;
    }

    private double calculateBalance(
            int principal,
            double annualInterest,
            int years,
            int numberOfPaymentsMade) {

        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }
}
