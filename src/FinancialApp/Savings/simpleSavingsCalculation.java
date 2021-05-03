package FinancialApp.Savings;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class simpleSavingsCalculation {
    public static Alert SimpleCalculation(TextField capital, TextField rate, TextField period, TextField fv){
                //get values from text fields
        String capital_V = capital.getText();
        String rate_V = rate.getText();
        String period_V = period.getText();
        String fv_V = fv.getText();

        File file = new File("src/FinancialApp/history.txt");   //Create txt File or Append Text into Existing txt File

        Alert alert = new Alert(Alert.AlertType.INFORMATION);       //new alert box
        alert.setTitle(null);

        DateFormat df = new SimpleDateFormat("dd/MM/yy   HH:mm:ss");    //date and tile format
        Date DateTime = new Date();     //get current date and time

        double calculation = 0;
        double roundCalculation = 0;
        String convertCalculations = "";

        try {
            FileWriter F_Writer = new FileWriter(file,true);
            PrintWriter PW = new PrintWriter(F_Writer, true);
            PW.println("<-------------------  SIMPLE SAVINGS  ------------------->");

            if (capital.getText().isEmpty() && !rate.getText().isEmpty() && !period.getText().isEmpty() && !fv.getText().isEmpty()){
                //Calculate Capital
                calculation = (100*Double.parseDouble(fv_V))/((100)+(Double.parseDouble(rate_V)*Double.parseDouble(period_V)));
                roundCalculation = Math.round(calculation*100.00)/100.00;
                convertCalculations = "\tCapital Amount Is  $"+roundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+roundCalculation);
                PW.println("\tInterest Rate : "+rate_V+"%");
                PW.println("\tTime Period : "+period_V+" years");
                PW.println("\tFuture Value :  $"+fv_V);
                PW.println();
                PW.close();
            }
            else if (!capital.getText().isEmpty() && rate.getText().isEmpty() && !period.getText().isEmpty() && !fv.getText().isEmpty()){
                //Calculate rate
                calculation = (Double.parseDouble(fv_V)-Double.parseDouble(capital_V))*100/(Double.parseDouble(capital_V)*Double.parseDouble(period_V));
                roundCalculation = Math.round(calculation*100.00)/100.00;
                convertCalculations = "\tCalculated Rate Is  "+roundCalculation+"%";

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+capital_V);
                PW.println("\tInterest Rate : "+roundCalculation+"%");
                PW.println("\tTime Period : "+period_V+" years");
                PW.println("\tFuture Value :  $"+fv_V);
                PW.println();
                PW.close();
            }
            else if (!capital.getText().isEmpty() && !rate.getText().isEmpty() && period.getText().isEmpty() && !fv.getText().isEmpty()){
                //Calculate period
                calculation = (Double.parseDouble(fv_V)-Double.parseDouble(capital_V))*100/(Double.parseDouble(capital_V)*Double.parseDouble(rate_V));
                roundCalculation = Math.round(calculation);
                convertCalculations = "\tTime Period Is "+roundCalculation+" Years";

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+capital_V);
                PW.println("\tInterest Rate : "+rate_V+"%");
                PW.println("\tTime Period : "+roundCalculation+" years");
                PW.println("\tFuture Value :  $"+fv_V);
                PW.println();
                PW.close();
            }
            else if (!capital.getText().isEmpty() && !rate.getText().isEmpty() && !period.getText().isEmpty() && fv.getText().isEmpty()){
                //Calculate future value
                calculation = Double.parseDouble(capital_V)+(Double.parseDouble(capital_V)*(Double.parseDouble(rate_V)/100)*Double.parseDouble(period_V));
                roundCalculation = Math.round(calculation*100.00)/100.00;
                convertCalculations = "\tFuture Value Is  $"+roundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+capital_V);
                PW.println("\tInterest Rate : "+rate_V+"%");
                PW.println("\tTime Period : "+period_V+" years");
                PW.println("\tFuture Value :  $"+roundCalculation);
                PW.println();
                PW.close();
            }
            else{
                convertCalculations = "Leave What You Need To Calculate And Fill The Rest..!!";
            }
                //display Alert
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
