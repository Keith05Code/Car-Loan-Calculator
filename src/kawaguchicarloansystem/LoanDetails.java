/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kawaguchicarloansystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author keithchang
 */
public class LoanDetails {

private String carType;
    private double loanAmount;
    private int loanTerm;
    private double totalInterest;
    private double purchaseInsurance;
    private double monthlyInstalment;
    private double totalLoanCost;

    public LoanDetails(String carType, double loanAmount, int loanTerm, double totalInterest, double purchaseInsurance, double monthlyInstalment, double totalLoanCost) {
        this.carType = carType;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.totalInterest = totalInterest;
        this.purchaseInsurance = purchaseInsurance;
        this.monthlyInstalment = monthlyInstalment;
        this.totalLoanCost = totalLoanCost;
    }

    
    //getter method
    public String getCarType() {
        return carType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public double getTotalInterest() {
        return totalInterest;
    }
    
    public double getMonthlyInstalment() {
        return monthlyInstalment;
    }

    public double getPurchaseInsurance() {
        return purchaseInsurance;
    }
    
    public double getTotalLoanCost() {
        return totalLoanCost;
    }

    public static class SummaryReport {

        private static ArrayList<LoanDetails> loanDetailsList = new ArrayList<>();

        public static void addLoanDetails(LoanDetails loanDetails) {
            loanDetailsList.add(loanDetails);
        }
        
        //Generate summary
        public static void generateReport() {
            String summary = "       ======= Summary Report =======\n";
            double totalInsured = 0;
            double totalInterest = 0;
            double totalLoanCost = 0;
            double totalMonthlyInstallment = 0;

            for (int i = 0; i < loanDetailsList.size(); i++) {
                LoanDetails details = loanDetailsList.get(i);
                
                summary += "--------------------------------------------\n";
                summary += "Transaction: " + (i + 1) + "\n";
                summary += "Car Type: " + details.getCarType() + "\n";
                summary += "Insured: RM " + String.format("%.2f", details.getPurchaseInsurance()) + "\n";
                summary += "Total Interest: RM " + String.format("%.2f", details.getTotalInterest()) + "\n";
                summary += "Total Loan Cost: RM " + String.format("%.2f", details.getTotalLoanCost()) + "\n";
                summary += "Monthly Instalment: RM " + String.format("%.2f", details.getMonthlyInstalment()) + "\n";
                
                totalInsured += details.getPurchaseInsurance();
                totalInterest += details.getTotalInterest();
                totalLoanCost += details.getTotalLoanCost();
                totalMonthlyInstallment += details.getMonthlyInstalment();
            }
            summary += "===================================\n";
            summary += "Total Cummulative Insured: RM " + String.format("%.2f\n", totalInsured);
            summary += "Total Cummulative Interest: RM " + String.format("%.2f\n", totalInterest);
            summary += "Total Cummulative Loan Cost: RM " + String.format("%.2f\n", totalLoanCost);
            summary += "Total Cummulative Monthly Installment: RM " + String.format("%.2f\n", totalMonthlyInstallment);
            summary += "===================================\n";
            
            JOptionPane.showMessageDialog(null, summary, "Summary Report", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
