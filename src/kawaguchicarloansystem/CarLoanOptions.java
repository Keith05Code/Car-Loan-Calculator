package kawaguchicarloansystem;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author keithchang
 */
public class CarLoanOptions {
    
    //car loan info
    public void displayCarLoanScheme(){
        JOptionPane.showMessageDialog(null, "------------------------------------------------------"
                                           + "\nCar Type            |          Loan Amount(RM)       |      Interest Rate(%)"
                                           + "\n------------------------------------------------------"
                                           + "\nImported           |              >300000                 |            2.35%"
                                           + "\n                         |        100000 - 300000          |            2.55%"
                                           + "\n                         |              <100000                 |            2.75%"
                                           + "\n------------------------------------------------------"
                                           + "\nLocal                 |              >100000                 |            3.00%"
                                           + "\n                         |         50000 - 100000           |            3.10%"
                                           + "\n                         |              >50000                   |            3.20%"
                                           + "\n------------------------------------------------------  ", 
                                             " Kawaguchi Car Loan Scheme", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    
       public void calculateCarLoanInstallment() {
        String carType;
        double loanAmount = 0;
        int loanTerm;
        String wantPurchaseInsurance;

       // Validate the carType.
        do {
            carType = JOptionPane.showInputDialog("Enter Car Type:\n- Imported\n- Local").trim();
        } while (!carType.equalsIgnoreCase("Imported") && !carType.equalsIgnoreCase("Local"));

        // Validate The loanAmount
        do {
            String loanAmountInput = JOptionPane.showInputDialog("Enter loan amount (RM): ").trim();
        try {
            loanAmount = Double.parseDouble(loanAmountInput);
        if (loanAmount <= 0) {
            JOptionPane.showMessageDialog(null,"Invalid input. Please enter a positive number for the loan amount.");
            continue;
        }
        break; 
        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null,"Invalid input. Please enter a valid number for the loan amount.");
        }
        } while (true);

        // Validate the loanTerm
        do {
            String loanTermInput = JOptionPane.showInputDialog("Enter loan term (Years): ").trim();
        try {
            loanTerm = Integer.parseInt(loanTermInput);
        if (loanTerm <= 0) {
            JOptionPane.showMessageDialog(null,"Invalid input. Please enter a positive integer for the loan term.");
            continue;
        }
        break; 
        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null,"Invalid input. Please enter a valid integer for the loan term.");
        }
        } while (true);

        // Validate wantPurchaseInsurance
        do {
            wantPurchaseInsurance = JOptionPane.showInputDialog("Do you want to purchase a Loan Insurance? (Yes/No)").trim();
        } while (!wantPurchaseInsurance.equalsIgnoreCase("Yes") && !wantPurchaseInsurance.equalsIgnoreCase("No"));


        //if and else to calculate the installment
        double interestRate = 0.0;
        if (carType.equalsIgnoreCase("Imported")) {
            if (loanAmount > 300000) {
                interestRate = 0.0235;
            } else if (loanAmount >= 100000 && loanAmount <= 300000) {
                interestRate = 0.0255;
            } else if (loanAmount < 100000) {
                interestRate = 0.0275;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        } else if (carType.equalsIgnoreCase("Local")) {
            if (loanAmount > 100000) {
                interestRate = 0.03;
            } else if (loanAmount >= 50000 && loanAmount <= 100000) {
                interestRate = 0.031;
            } else if (loanAmount < 50000) {
                interestRate = 0.032;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }

        //if and else to calculate purchaseLoan
        double purchaseInsurance = 0.0;
        if (wantPurchaseInsurance.equalsIgnoreCase("Yes")) {
            purchaseInsurance = 200 * loanTerm;
        } else if (wantPurchaseInsurance.equalsIgnoreCase("No")) {
            purchaseInsurance = 0;
        } else {
            purchaseInsurance = 0;
            JOptionPane.showMessageDialog(null, "No Option Selected: Set to NO");
        }

        //calculate total interest, total loan cost and montly installment
        double totalInterest = loanAmount * interestRate * loanTerm;
        double totalLoanCost = loanAmount + totalInterest + purchaseInsurance;
        double monthlyInstalment = (loanAmount + totalInterest + purchaseInsurance) / (loanTerm *12);
        double totalInsured = purchaseInsurance;

        LoanDetails.SummaryReport.addLoanDetails(new LoanDetails(carType, loanAmount, loanTerm, totalInterest, purchaseInsurance, monthlyInstalment, totalLoanCost));
        JOptionPane.showMessageDialog(null, String.format("Car Type: " + carType + "\nLoan Amount: RM" + loanAmount + "\nLoan Term: " + loanTerm + " Years" + "\nInsurance: " + wantPurchaseInsurance +"\n\nTotal Interest: RM %.2f" + "\nTotal Insured: RM " + totalInsured + "\n\nTotal Loan Cost: RM " + totalLoanCost + "\nMonthly Instalment: RM %.2f", totalInterest,monthlyInstalment));
    } 
    
} 
