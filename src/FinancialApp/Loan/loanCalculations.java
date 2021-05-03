package FinancialApp.Loan;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class loanCalculations {
    public static Alert LoanCalculation(TextField loan, TextField noMonths, TextField monthPay, TextField rate){
        // Get text form all textfield
        String loan_V = loan.getText();
        String noMonths_V = noMonths.getText();
        String monthPay_V = monthPay.getText();
        String rate_V = rate.getText();

        File file = new File("src/FinancialApp/history.txt");   //Create txt File or Append Text into Existing txt File

        Alert alert = new Alert(Alert.AlertType.INFORMATION);       //new alert box
        alert.setTitle(null);

        DateFormat df = new SimpleDateFormat("dd/MM/yy   HH:mm:ss");    //date and tile format
        Date DateTime = new Date();     //get current date and time

        double calculatedValue = 0;
        double roundCalculatedValue = 0;
        String convertCalculations = "";

        try {
            FileWriter F_Writer = new FileWriter(file,true);
            PrintWriter PW = new PrintWriter(F_Writer, true);
            PW.println("<-------------------  LOAN  ------------------->");

            if (loan_V.isEmpty() && !noMonths_V.isEmpty() && !monthPay_V.isEmpty() && !rate_V.isEmpty()){
                //Calculate loan amount
                double i = Double.parseDouble(rate_V)/1200;        //calculate rate (6% --> 0.005)
                calculatedValue = (Double.parseDouble(monthPay_V)/i) * (1-(1/Math.pow((1+i), Double.parseDouble(noMonths_V))));
                roundCalculatedValue = Math.round(100.00*calculatedValue)/100.00;
                convertCalculations = "\tLoan Amount Is $"+roundCalculatedValue;      //Convert double value to string

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tLoan Amount :  $"+roundCalculatedValue);
                PW.println("\tNumber Of Months : "+noMonths_V);
                PW.println("\tMonthly Payment :  $"+monthPay_V);
                PW.println("\tInterest Rate : "+rate_V+"%");
                PW.println();
                PW.close();
            }
            else  if (!loan_V.isEmpty() && noMonths_V.isEmpty() && !monthPay_V.isEmpty() && !rate_V.isEmpty()){
                //Calculate number of months
                double i = Double.parseDouble(rate_V)/1200;        //calculate rate (6% --> 0.005)
                calculatedValue = Math.log10((Double.parseDouble(monthPay_V)/i) / ((Double.parseDouble(monthPay_V)/i)-Double.parseDouble(loan_V))) / Math.log10(1+i);
                roundCalculatedValue = Math.round(calculatedValue);
                convertCalculations = "\tNumber Of Months Is "+roundCalculatedValue;      //Convert double value to string

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tLoan Amount :  $"+loan_V);
                PW.println("\tNumber Of Months : "+roundCalculatedValue);
                PW.println("\tMonthly Payment :  $"+monthPay_V);
                PW.println("\tInterest Rate : "+rate_V+"%");
                PW.println();
                PW.close();
            }
            else if (!loan_V.isEmpty() && !noMonths_V.isEmpty() && monthPay_V.isEmpty() && !rate_V.isEmpty()){
                //Calculate monthly payment
                double i = Double.parseDouble(rate_V)/1200;        //calculate rate (6% --> 0.005)
                calculatedValue = (Double.parseDouble(loan_V)*i*Math.pow((1+i),Double.parseDouble(noMonths_V))) / (Math.pow((1+i),Double.parseDouble(noMonths_V)) - 1);
                roundCalculatedValue = Math.round(100.00*calculatedValue)/100.00;
                convertCalculations = "\tMonthly Payment Is $"+roundCalculatedValue;      //Convert double value to string

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tLoan Amount :  $"+loan_V);
                PW.println("\tNumber Of Months : "+noMonths_V);
                PW.println("\tMonthly Payment :  $"+roundCalculatedValue);
                PW.println("\tInterest Rate : "+rate_V+"%");
                PW.println();
                PW.close();
            }
            else if (!loan_V.isEmpty() && !noMonths_V.isEmpty() && !monthPay_V.isEmpty() && rate_V.isEmpty()){
                //Message to fill the rate field
                convertCalculations = "Rate is missing...!";
            }
            else{
                //Warning message
                convertCalculations = "Excluding rate field, you can leave one rest of fields what you need to calculate...!";
            }

            //Alert
            alert.setContentText(convertCalculations);
            alert.showAndWait();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return alert;
    }
}
