/*
 * Josh Bartlett
 * February 15, 2020
 * Assignment 3.2
 * Bellevue University
 * CreatePurchase.java
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class CreatePurchase {
    public static void main (String[] args){
        // create scanner object
        Scanner input = new Scanner(System.in);
        // declare variables for use in main
        int invoiceNum;
        double amountOfSale;
        // ask user for the invoice number and save to invoiceNum variable
        System.out.print("Enter Invoice Number: ");
        invoiceNum = input.nextInt();
        // ask user for the amount of sale and save to amountOfSale variable,
        // keep asking until user enters nonnegative number
        do {
            System.out.print("Enter Amount of Sale: ");
            amountOfSale = input.nextDouble();
        } while (amountOfSale < 0);
        // create new instance of the Purchase class, calling the sets with the user inputs,
        // and calling the display method
        Purchase newPurchase = new Purchase();
        newPurchase.setInvoiceNum(invoiceNum);
        newPurchase.setAmountOfSale(amountOfSale);
        Purchase.display(newPurchase);
    }
}

class Purchase{
    // declare variables for use in the Purchase class
    private static final double SALES_TAX_RATE = 0.075;
    private int invoiceNum;
    private double amountOfSale,
                   amountOfSalesTax;
    // method to set the invoiceNum
    public int setInvoiceNum(int iNum){
        invoiceNum = iNum;
        return invoiceNum;
    }
    // method to set the amountOfSale, also calculates the amountOfSalesTax
    public double setAmountOfSale(double amntOfSale){
        amountOfSale = amntOfSale;
        amountOfSalesTax = Purchase.SALES_TAX_RATE * amountOfSale;
        return amountOfSalesTax;
    }
    // method to display the sale information, includes NumberFormat for currency display
    public static void display(Purchase instance){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("\n      Sale Information");
        System.out.printf("Invoice Number: \t\t" + instance.invoiceNum + "\nAmount of Sale: \t\t" +
                currency.format(instance.amountOfSale) + "\nAmount of Sales Tax: \t" +
                currency.format(instance.amountOfSalesTax));
    }
}
