package FinancialApp.Loan;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class loan {
    public static HBox Loan(){
        Label tabTitle = new Label("LOAN");
        tabTitle.setFont(Font.font(31));
        tabTitle.setLayoutX(110); tabTitle.setLayoutY(28);

        Label Loan_Amount = new Label("Loan Amount : ");
        Loan_Amount.setLayoutX(78); Loan_Amount.setLayoutY(112);
        TextField Loan_Amount_TF = new TextField();
        Loan_Amount_TF.setLayoutX(170); Loan_Amount_TF.setLayoutY(107);
        Loan_Amount_TF.setPromptText("$");
        Loan_Amount_TF.setOnMouseClicked(event -> loanKeyboard.getTextField(Loan_Amount_TF));

        Label No_Months = new Label("Number Of Months : ");
        No_Months.setLayoutX(47); No_Months.setLayoutY(171);
        TextField No_Months_TF = new TextField();
        No_Months_TF.setLayoutX(170); No_Months_TF.setLayoutY(166);
        No_Months_TF.setPromptText("Months");
        No_Months_TF.setOnMouseClicked(event -> loanKeyboard.getTextField(No_Months_TF));

        Label Monthly_Pay = new Label("Monthly Payment : ");
        Monthly_Pay.setLayoutX(57); Monthly_Pay.setLayoutY(231);
        TextField Monthly_Pay_TF = new TextField();
        Monthly_Pay_TF.setLayoutX(170); Monthly_Pay_TF.setLayoutY(226);
        Monthly_Pay_TF.setPromptText("$");
        Monthly_Pay_TF.setOnMouseClicked(event -> loanKeyboard.getTextField(Monthly_Pay_TF));

        Label rate_Loan = new Label("Interest Rate : ");
        rate_Loan.setLayoutX(81); rate_Loan.setLayoutY(292);
        TextField rate_Loan_TF = new TextField();
        rate_Loan_TF.setLayoutX(170); rate_Loan_TF.setLayoutY(287);
        rate_Loan_TF.setPromptText("%");
        rate_Loan_TF.setOnMouseClicked(event -> loanKeyboard.getTextField(rate_Loan_TF));

        Button calculateBtn_Lon = new Button("Calculate");
        calculateBtn_Lon.setId("calculateBTN");
        calculateBtn_Lon.setLayoutX(150); calculateBtn_Lon.setLayoutY(358);
        calculateBtn_Lon.setOnAction(event -> loanCalculations.LoanCalculation(Loan_Amount_TF,No_Months_TF,Monthly_Pay_TF,rate_Loan_TF));

        Pane LoanPane = new Pane();
        LoanPane.getChildren().addAll(
                tabTitle,
                Loan_Amount,
                Loan_Amount_TF,
                No_Months,
                No_Months_TF,
                Monthly_Pay,
                Monthly_Pay_TF,
                rate_Loan,
                rate_Loan_TF,
                calculateBtn_Lon);

        HBox loanHBOX = new HBox(100);
        loanHBOX.getChildren().addAll(
                LoanPane,
                loanKeyboard.displayKeyboard());
        return loanHBOX;
    }
}
