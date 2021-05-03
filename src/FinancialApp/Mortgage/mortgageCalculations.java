
package FinancialApp.Mortgage;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mortgageCalculations {
    public static Alert MortgageCalculation(TextField HousePrice, TextField DownPayment, TextField MonthlyAddition, TextField Rate, TextField LoanTerm){
        String HousePrice_V = HousePrice.getText();     //House Price Value
        String DownPayment_V = DownPayment.getText();       //Down payment value
        String MonthlyAddition_V = MonthlyAddition.getText();       //monthly additon value
        String Rate_V = Rate.getText();     //rate value
        String LoanTerm_V = LoanTerm.getText();     //loan term value

        File file = new File("src/FinancialApp/history.txt");   //Create txt File or Append Text into Existing txt File

        Alert alert = new Alert(Alert.AlertType.INFORMATION);       //new alert box
        alert.setTitle(null);

        DateFormat df = new SimpleDateFormat("dd/MM/yy   HH:mm:ss");    //date and tile format
        Date DateTime = new Date();     //get current date and time

        double Calculation = 0;
        double RoundCalculation = 0;
        String ConvertCalculations = "";

        try {
            FileWriter F_Writer = new FileWriter(file,true);
            PrintWriter PW = new PrintWriter(F_Writer, true);
            PW.println("<-------------------  MORTGAGE  ------------------->");
            if (HousePrice.getText().isEmpty() && !DownPayment.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && !Rate.getText().isEmpty() && !LoanTerm.getText().isEmpty()){
                //Calculate House Price
                Calculation = Double.parseDouble(DownPayment_V) + ((12 * Double.parseDouble(MonthlyAddition_V) * (Math.pow((1 + (Double.parseDouble(Rate_V) / 1200)), (12 * Double.parseDouble(LoanTerm_V))) - 1)) / (Double.parseDouble(Rate_V)*0.01 * Math.pow((1 + (Double.parseDouble(Rate_V) / 1200)), (12 * Double.parseDouble(LoanTerm_V)))));
                RoundCalculation = Math.round(Calculation*100.00)/100.00;       //round calculated value
                ConvertCalculations = "\tHouse Price Is  $"+RoundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tHouse Price :  $"+RoundCalculation);
                PW.println("\tDown Payment :  $"+DownPayment_V);
                PW.println("\tMonthly Addition :  $"+MonthlyAddition_V);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tLoan Term : "+LoanTerm_V+" years");
                PW.println();
                PW.close();
            }
            else if (!HousePrice.getText().isEmpty() && DownPayment.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && !Rate.getText().isEmpty() && !LoanTerm.getText().isEmpty()){
                //Calculate Down Payment
                Calculation = Double.parseDouble(HousePrice_V) - ((12 * Double.parseDouble(MonthlyAddition_V) * (Math.pow((1 + (Double.parseDouble(Rate_V) / 1200)), 12 * Double.parseDouble(LoanTerm_V)) - 1)) / (Double.parseDouble(Rate_V)*0.01 * Math.pow((1 + (Double.parseDouble(Rate_V) / 1200)), 12 * Double.parseDouble(LoanTerm_V))));
                RoundCalculation = Math.round(Calculation*100.00)/100.00;
                ConvertCalculations = "\tDown Payment Is  $"+RoundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tHouse Price :  $"+HousePrice_V);
                PW.println("\tDown Payment :  $"+RoundCalculation);
                PW.println("\tMonthly Addition :  $"+MonthlyAddition_V);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tLoan Term : "+LoanTerm_V+" years");
                PW.println();
                PW.close();
            }
            else if (!HousePrice.getText().isEmpty() && !DownPayment.getText().isEmpty() && MonthlyAddition.getText().isEmpty() && !Rate.getText().isEmpty() && !LoanTerm.getText().isEmpty()){
                //Calculate Monthly Addition
                Calculation = ((Double.parseDouble(HousePrice_V) - Double.parseDouble(DownPayment_V)) * (Double.parseDouble(Rate_V) / 1200) * Math.pow((1 + (Double.parseDouble(Rate_V) / 1200)), 12 * Double.parseDouble(LoanTerm_V))) / (Math.pow((1 + (Double.parseDouble(Rate_V) / 1200)), 12 * Double.parseDouble(LoanTerm_V)) - 1);
                RoundCalculation = Math.round(Calculation);
                ConvertCalculations = "\tMonthly Addition Is  $"+RoundCalculation;

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tHouse Price :  $"+HousePrice_V);
                PW.println("\tDown Payment :  $"+DownPayment_V);
                PW.println("\tMonthly Addition :  $"+RoundCalculation);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tLoan Term : "+LoanTerm_V+" years");
                PW.println();
                PW.close();
            }
            else if (!HousePrice.getText().isEmpty() && !DownPayment.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && Rate.getText().isEmpty() && !LoanTerm.getText().isEmpty()){
                //Calculate Rate
                ConvertCalculations = "Rate is missing...!";
            }
            else if (!HousePrice.getText().isEmpty() && !DownPayment.getText().isEmpty() && !MonthlyAddition.getText().isEmpty() && !Rate.getText().isEmpty() && LoanTerm.getText().isEmpty()){
                //Calculate Loan Term
                Calculation = (Math.log((Double.parseDouble(MonthlyAddition_V) / (Double.parseDouble(MonthlyAddition_V) - ((Double.parseDouble(Rate_V)/1200) * (Double.parseDouble(HousePrice_V) - Double.parseDouble(DownPayment_V))))))) /  (12 * Math.log(1 + (Double.parseDouble(Rate_V)/1200)));
                RoundCalculation = Math.round(Calculation);
                ConvertCalculations = "\tLoan Term Is "+RoundCalculation+" Years";

                PW.println("( "+df.format(DateTime)+" )");
                PW.println("\tHouse Price :  $"+HousePrice_V);
                PW.println("\tDown Payment :  $"+DownPayment_V);
                PW.println("\tMonthly Addition :  $"+MonthlyAddition_V);
                PW.println("\tInterest Rate : "+Rate_V+"%");
                PW.println("\tLoan Term : "+RoundCalculation+" years");
                PW.println();
                PW.close();
            }
            else{
                //Warning Message
                ConvertCalculations = "Excluding rate field, you can leave one rest of fields what you need to calculate...!";
            }

            alert.setContentText(ConvertCalculations);      //display alert box
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

