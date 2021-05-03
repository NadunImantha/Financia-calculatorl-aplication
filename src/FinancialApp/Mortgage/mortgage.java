package FinancialApp.Mortgage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class mortgage {
    public static HBox Mortgage(){
        Label title = new Label("MORTGAGE");    //title
        title.setFont(Font.font(31));
        title.setLayoutX(110); title.setLayoutY(28);

        Label housePrice = new Label("House Price :  ");
        housePrice.setLayoutX(83); housePrice.setLayoutY(122);
        TextField housePrice_TF = new TextField();
        housePrice_TF.setLayoutX(170); housePrice_TF.setLayoutY(117);
        housePrice_TF.setPromptText("$");
        housePrice_TF.setOnMouseClicked(event -> mortgageKeyboard.getTextField(housePrice_TF));

        Label downPayment = new Label("Down Payment : ");
        downPayment.setLayoutX(68); downPayment.setLayoutY(171);
        TextField downPayment_TF = new TextField();
        downPayment_TF.setLayoutX(170); downPayment_TF.setLayoutY(166);
        downPayment_TF.setPromptText("$");
        downPayment_TF.setOnMouseClicked(event -> mortgageKeyboard.getTextField(downPayment_TF));

        Label monthAddition = new Label("Monthly Addition : ");
        monthAddition.setLayoutX(58); monthAddition.setLayoutY(220);
        TextField monthAddition_TF = new TextField();
        monthAddition_TF.setLayoutX(170); monthAddition_TF.setLayoutY(215);
        monthAddition_TF.setPromptText("$");
        monthAddition_TF.setOnMouseClicked(event -> mortgageKeyboard.getTextField(monthAddition_TF));

        Label intRate = new Label("Interest Rate : ");
        intRate.setLayoutX(81); intRate.setLayoutY(269);
        TextField intRate_TF = new TextField();
        intRate_TF.setLayoutX(170); intRate_TF.setLayoutY(264);
        intRate_TF.setPromptText("%");
        intRate_TF.setOnMouseClicked(event -> mortgageKeyboard.getTextField(intRate_TF));

        Label loanTerm = new Label("Loan Term : ");
        loanTerm.setLayoutX(91); loanTerm.setLayoutY(318);
        TextField loanTerm_TF = new TextField();
        loanTerm_TF.setLayoutX(170); loanTerm_TF.setLayoutY(313);
        loanTerm_TF.setPromptText("Years");
        loanTerm_TF.setOnMouseClicked(event -> mortgageKeyboard.getTextField(loanTerm_TF));

        Button calculateBtn_mortgage = new Button("Calculate");
        calculateBtn_mortgage.setId("calculateBTN");
        calculateBtn_mortgage.setLayoutX(150); calculateBtn_mortgage.setLayoutY(375);
        calculateBtn_mortgage.setOnAction(event -> mortgageCalculations.MortgageCalculation(housePrice_TF,downPayment_TF,monthAddition_TF,intRate_TF,loanTerm_TF));

        Pane mortgagePane =  new Pane();
        mortgagePane.getChildren().addAll(
                title,
                housePrice,
                housePrice_TF,
                downPayment,
                downPayment_TF,
                monthAddition,
                monthAddition_TF,
                intRate,
                intRate_TF,
                loanTerm,
                loanTerm_TF,
                calculateBtn_mortgage);

        HBox mortgageHBOX = new HBox(100);
        mortgageHBOX.getChildren().addAll(
                mortgagePane,
                mortgageKeyboard.displayKeyboard());
        return mortgageHBOX;
    }
}
