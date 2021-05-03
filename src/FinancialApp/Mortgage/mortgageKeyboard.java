package FinancialApp.Mortgage;

import FinancialApp.FinancialCalculator;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class mortgageKeyboard {

    private static Button button1 = new Button("1");
    private static Button button2 = new Button("2");
    private static Button button3 = new Button("3");
    private static Button button4 = new Button("4");
    private static Button button5 = new Button("5");
    private static Button button6 = new Button("6");
    private static Button button7 = new Button("7");
    private static Button button8 = new Button("8");
    private static Button button9 = new Button("9");
    private static Button button0 = new Button("0");
    private static Button buttonDOT = new Button(".");
    private static Button buttonCLREAR = new Button("AC");
    private static Button buttonDEL = new Button("DEL");
    private static Button buttonNEG = new Button("-");


    public static GridPane displayKeyboard() {
        GridPane gp = new GridPane();
        gp.setHgap(15.0);
        gp.setVgap(15.0);

        buttonDEL.setId("equalBTN");

        setButtonSize(button0);
        setButtonSize(button1);
        setButtonSize(button2);
        setButtonSize(button3);
        setButtonSize(button4);
        setButtonSize(button5);
        setButtonSize(button6);
        setButtonSize(button7);
        setButtonSize(button8);
        setButtonSize(button9);
        setButtonSize(buttonDOT);
        setButtonSize(buttonNEG);

        gp.add(button7, 1, 1);
        gp.add(button8, 2, 1);
        gp.add(button9, 3, 1);
        gp.add(buttonCLREAR, 4, 1,1,2);
        buttonCLREAR.setMinSize(65,135);

        gp.add(button4, 1, 2);
        gp.add(button5, 2, 2);
        gp.add(button6, 3, 2);

        gp.add(button1, 1, 3);
        gp.add(button2, 2, 3);
        gp.add(button3, 3, 3);
        gp.add(buttonDEL, 4, 3,1,2);
        buttonDEL.setMinSize(60,135);

        gp.add(button0, 1, 4,2,1);
        button0.setMinSize(135,60);
        gp.add(buttonDOT, 3, 4);

        gp.setPadding(new Insets(85,0,0,0));

        String css_keyboard = FinancialCalculator.class.getResource("CssStyles/keyboardStyles.css").toExternalForm();
        gp.getStylesheets().add(css_keyboard);
        return gp;
    }

    public static void setButtonSize(Button button){
        button.setPrefHeight(60.0);
        button.setPrefWidth(60.0);
    }

    public static TextField getTextField(TextField textFieldName){
        buttonCLREAR.setOnAction(event -> {
            textFieldName.setText("");
        });
        buttonDEL.setOnAction(event -> {
            String getValue = textFieldName.getText().substring(0,textFieldName.getText().length()-1);
            textFieldName.setText(getValue);
        });
        button0.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"0");
        });
        button1.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"1");
        });
        button2.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"2");
        });
        button3.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"3");
        });
        button4.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"4");
        });
        button5.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"5");
        });
        button6.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"6");
        });
        button7.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"7");
        });
        button8.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"8");
        });
        button9.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"9");
        });
        buttonDOT.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+".");
        });
        buttonNEG.setOnAction(event -> {
            String getValue = textFieldName.getText();
            textFieldName.setText(getValue+"-");
        });

        return textFieldName;
    }
}

