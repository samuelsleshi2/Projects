import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Prompting user for principal
        int principal;
            while (true) {
                System.out.print("Principal ($1K - $1M): ");
                principal = scanner.nextInt();

                if (principal >= 1000 && principal <= 1000000) {
                    break;
                } else {
                    System.out.println("Enter a number between 1,000 and 1,000,000.");
                }
            }

// Prompting user for annual interest
            double annualInterest;
            while (true) {
                System.out.print("Annual Interest Rate: ");
                annualInterest = scanner.nextDouble();
                if (annualInterest > 0 && annualInterest <= 15) {
                    break;
                } else {
                    System.out.println("Enter a value greater than 0 and less than or equal to 15.");
                }
            }

            // Prompting user for years
        int years;
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
            if (years > 0 && years <= 50) {
                break;
            } else {
                System.out.println("Enter a value greater than 0 and less than or equal to 50");
            }
        }

        double monthlyInterest = annualInterest / 100 / 12;
        int numberOfPayments = years * 12;

        // Calculating result of mortgage payment
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly mortgage payment: " + mortgageFormatted);
    }
}