/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kawaguchicarloansystem;

import javax.swing.JOptionPane;

/**
 *
 * @author keithchang
 */
public class KawaguchiCarLoanSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int userInputIndex; 
        
        do {
            String[] options = {"Display Car Loan Scheme", "Calculate Car Loan Installment", "Generate Summary Report", "Exit"};
            userInputIndex = JOptionPane.showOptionDialog(null, " Choose an option: ", "Kawaguchi Bank Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            CarLoanOptions carLoanOptions = new CarLoanOptions();

            switch (userInputIndex) {
                case 0:
                    carLoanOptions.displayCarLoanScheme();
                    break;

                case 1:
                    carLoanOptions.calculateCarLoanInstallment();
                    break;

                case 2:
                    LoanDetails.SummaryReport.generateReport();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Press EXIT to exit.");
            }

        } while (userInputIndex != 3); 
  
    } 
    
}
