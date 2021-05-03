package FinancialApp.Savings;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class compoundSavingsCalculation {
    public static Alert CompoundCalculation(TextField Capital, TextField Rate, TextField Period, TextField MonthlyAddition, TextField FV){
            //Get values
        String Capital_V = Capital.getText();
        String Rate_V = Rate.getText();
        String Period_V = Period.getText();
        String MonthAddition_V = MonthlyAddition.getText();
        String FV_V = FV.getText();

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
            PW.println("<-------------------  COMPOUND SAVINGS  ------------------->");

            if (Capital.getText().isEmpty() && !Rate.getText().isEmpty() && !Period.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && !FV.getText().isEmpty()){
                //Calculate Capital
                calculation = (Double.parseDouble(FV_V) - ( Double.parseDouble(MonthAddition_V)*((Math.pow((1+(Double.parseDouble(Rate_V)/1200)),(12*Double.parseDouble(Period_V))) - 1)/( Double.parseDouble(Rate_V)/1200)) ))  /  Math.pow((1+(Double.parseDouble(Rate_V)/1200)),(12*Double.parseDouble(Period_V)));
                roundCalculation = Math.round(calculation*100.00)/100.00;
                convertCalculations = "\tCapital Amount Is  $"+roundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+roundCalculation);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tTime Period : "+Period_V+" years");
                PW.println("\tMonthly Addition :  $"+MonthAddition_V);
                PW.println("\tFuture Value :  $"+FV_V);
                PW.println();
                PW.close();
            }
            else if (!Capital.getText().isEmpty() && Rate.getText().isEmpty() && !Period.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && !FV.getText().isEmpty()){
                //Calculate rate
                convertCalculations = "Rate is missing...!";
            }
            else if (!Capital.getText().isEmpty() && !Rate.getText().isEmpty() && Period.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && !FV.getText().isEmpty()){
                //Calculate period
                calculation = Math.log(((((Double.parseDouble(Rate_V) * Double.parseDouble(FV_V)) / 1200) + Double.parseDouble(MonthAddition_V)) / (((Double.parseDouble(Capital_V) * Double.parseDouble(Rate_V)) / 1200) + Double.parseDouble(MonthAddition_V)))) / (12 * Math.log(1 + (Double.parseDouble(Rate_V)/1200)));
                roundCalculation = Math.round(calculation);
                convertCalculations = "\tTime Period Is "+roundCalculation+" Years";

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+Capital_V);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tTime Period : "+roundCalculation+" years");
                PW.println("\tMonthly Addition :  $"+MonthAddition_V);
                PW.println("\tFuture Value :  $"+FV_V);
                PW.println();
                PW.close();
            }
            else if (!Capital.getText().isEmpty() && !Rate.getText().isEmpty() && !Period.getText().isEmpty() && MonthlyAddition.getText().isEmpty() && !FV.getText().isEmpty()){
                //Calculate Monthly Addition
                calculation = ( Double.parseDouble(FV_V) - (Double.parseDouble(Capital_V)*Math.pow((1+(Double.parseDouble(Rate_V)/1200)),(12*Double.parseDouble(Period_V)))) )  /  ((Math.pow((1+(Double.parseDouble(Rate_V)/1200)),(12*Double.parseDouble(Period_V))) - 1)/( Double.parseDouble(Rate_V)/1200));
                roundCalculation = Math.round(calculation*100.00)/100.00;
                convertCalculations = "\tYour Monthly Addition Is  $"+roundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+Capital_V);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tTime Period : "+Period_V+" years");
                PW.println("\tMonthly Addition :  $"+roundCalculation);
                PW.println("\tFuture Value :  $"+FV_V);
                PW.println();
                PW.close();
            }
            else if (!Capital.getText().isEmpty() && !Rate.getText().isEmpty() && !Period.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && FV.getText().isEmpty()){
                //Calculate future value
                calculation = ( Double.parseDouble(Capital_V)*Math.pow((1+(Double.parseDouble(Rate_V)/1200)),(12*Double.parseDouble(Period_V))) )  +  ( Double.parseDouble(MonthAddition_V)*((Math.pow((1+(Double.parseDouble(Rate_V)/1200)),(12*Double.parseDouble(Period_V))) - 1)/( Double.parseDouble(Rate_V)/1200)) );
                roundCalculation = Math.round(calculation*100.00)/100.00;
                convertCalculations = "\tFuture Value Is  $"+roundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tCapital Amount :  $"+Capital_V);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tTime Period : "+Period_V+" years");
                PW.println("\tMonthly Addition :  $"+MonthAddition_V);
                PW.println("\tFuture Value :  $"+roundCalculation);
                PW.println();
                PW.close();
            }
            else{
                //Warning Message
                convertCalculations = "Excluding rate field, you can leave one rest of fields what you need to calculate...!";
            }
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
