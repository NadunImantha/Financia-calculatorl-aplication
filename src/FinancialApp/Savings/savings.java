package FinancialApp.Savings;

import FinancialApp.FinancialCalculator;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class savings {
    public static TabPane Savings(){
        TabPane savingTabs = new TabPane();
        savingTabs.setMinWidth(816);
        savingTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab simple = new Tab();
        simple.setText("Simple Saving");
        simple.setContent(SimpleSavings());

        Tab compound = new Tab();
        compound.setText("Compound Saving");
        compound.setContent(CompoundSavings());

        savingTabs.getTabs().addAll(simple, compound);

        return savingTabs;
    }

    public static HBox SimpleSavings(){
        Label tabTitle = new Label("SIMPLE SAVINGS");
        tabTitle.setFont(Font.font(31));
        tabTitle.setLayoutX(110); tabTitle.setLayoutY(28);

        Label capital_Sim = new Label("Capital : ");
        capital_Sim.setLayoutX(95); capital_Sim.setLayoutY(109);
        TextField capital_Sim_TF = new TextField();
        capital_Sim_TF.setLayoutX(170); capital_Sim_TF.setLayoutY(104);
        capital_Sim_TF.setPromptText("$");
        capital_Sim_TF.setOnMouseClicked(event -> simpleSavingsKeyboard.getTextField(capital_Sim_TF));

        Label rate_Sim = new Label("Interest Rate : ");
        rate_Sim.setLayoutX(67); rate_Sim.setLayoutY(167);
        TextField rate_Sim_TF = new TextField();
        rate_Sim_TF.setLayoutX(170); rate_Sim_TF.setLayoutY(162);
        rate_Sim_TF.setPromptText("%");
        rate_Sim_TF.setOnMouseClicked(event -> simpleSavingsKeyboard.getTextField(rate_Sim_TF));

        Label period_Sim = new Label("Period : ");
        period_Sim.setLayoutX(98); period_Sim.setLayoutY(224);
        TextField period_Sim_TF = new TextField();
        period_Sim_TF.setLayoutX(170); period_Sim_TF.setLayoutY(220);
        period_Sim_TF.setPromptText("Years");
        period_Sim_TF.setOnMouseClicked(event -> simpleSavingsKeyboard.getTextField(period_Sim_TF));

        Label fv_Sim = new Label("Future Value :");
        fv_Sim.setLayoutX(63); fv_Sim.setLayoutY(282);
        TextField fv_Sim_TF = new TextField();
        fv_Sim_TF.setLayoutX(170); fv_Sim_TF.setLayoutY(277);
        fv_Sim_TF.setPromptText("$");
        fv_Sim_TF.setOnMouseClicked(event -> simpleSavingsKeyboard.getTextField(fv_Sim_TF));

        Button calculateBtn_Sim = new Button("Calculate");
        calculateBtn_Sim.setId("calculateBTN");
        calculateBtn_Sim.setLayoutX(150); calculateBtn_Sim.setLayoutY(344);
        calculateBtn_Sim.setOnAction(event -> simpleSavingsCalculation.SimpleCalculation(capital_Sim_TF,rate_Sim_TF,period_Sim_TF,fv_Sim_TF));

        Pane SimpleSavingPane = new Pane();
        SimpleSavingPane.getChildren().addAll(
                tabTitle,
                capital_Sim,
                capital_Sim_TF,
                rate_Sim,
                rate_Sim_TF,
                period_Sim,
                period_Sim_TF,
                fv_Sim,
                fv_Sim_TF,
                calculateBtn_Sim,
                FinancialCalculator.MSG("",415));

        HBox simpleSavingHBOX = new HBox(105);
        simpleSavingHBOX.getChildren().addAll(SimpleSavingPane, simpleSavingsKeyboard.displayKeyboard());
        return simpleSavingHBOX;
    }

    public static HBox CompoundSavings(){
        Label tabTitle = new Label("COMPOUND SAVINGS");
        tabTitle.setFont(Font.font(31));
        tabTitle.setLayoutX(110); tabTitle.setLayoutY(28);

        Label capital_Com = new Label("Capital : ");
        capital_Com.setLayoutX(95); capital_Com.setLayoutY(107);
        TextField capital_Com_TF = new TextField();
        capital_Com_TF.setLayoutX(170); capital_Com_TF.setLayoutY(102);
        capital_Com_TF.setPromptText("$");
        capital_Com_TF.setOnMouseClicked(event -> compoundSavingsKeyboard.getTextField(capital_Com_TF));

        Label rate_Com = new Label("Interest Rate : ");
        rate_Com.setLayoutX(65); rate_Com.setLayoutY(156);
        TextField rate_Com_TF = new TextField();
        rate_Com_TF.setLayoutX(170); rate_Com_TF.setLayoutY(151);
        rate_Com_TF.setPromptText("%");
        rate_Com_TF.setOnMouseClicked(event -> compoundSavingsKeyboard.getTextField(rate_Com_TF));

        Label period_Com = new Label("Period : ");
        period_Com.setLayoutX(99); period_Com.setLayoutY(204);
        TextField period_Com_TF = new TextField();
        period_Com_TF.setLayoutX(170); period_Com_TF.setLayoutY(200);
        period_Com_TF.setPromptText("Years");
        period_Com_TF.setOnMouseClicked(event -> compoundSavingsKeyboard.getTextField(period_Com_TF));

        Label monthlyAddition_Com = new Label("Monthly Addition : ");
        monthlyAddition_Com.setLayoutX(43); monthlyAddition_Com.setLayoutY(254);
        TextField monthlyAddition_Com_TF = new TextField();
        monthlyAddition_Com_TF.setLayoutX(170); monthlyAddition_Com_TF.setLayoutY(249);
        monthlyAddition_Com_TF.setPromptText("$");
        monthlyAddition_Com_TF.setOnMouseClicked(event -> compoundSavingsKeyboard.getTextField(monthlyAddition_Com_TF));

        Label fv_Com = new Label("Future Value : ");
        fv_Com.setLayoutX(68); fv_Com.setLayoutY(303);
        TextField fv_Com_TF = new TextField();
        fv_Com_TF.setLayoutX(170); fv_Com_TF.setLayoutY(298);
        fv_Com_TF.setPromptText("$");
        fv_Com_TF.setOnMouseClicked(event -> compoundSavingsKeyboard.getTextField(fv_Com_TF));

        Button calculateBtn_Com = new Button("Calculate");
        calculateBtn_Com.setId("calculateBTN");
        calculateBtn_Com.setLayoutX(150); calculateBtn_Com.setLayoutY(360);
        calculateBtn_Com.setOnAction(event -> compoundSavingsCalculation.CompoundCalculation(capital_Com_TF,rate_Com_TF,period_Com_TF,monthlyAddition_Com_TF,fv_Com_TF));

        Pane CompoundSavingPane = new Pane();
        CompoundSavingPane.getChildren().addAll(
                tabTitle,
                capital_Com,
                capital_Com_TF,
                rate_Com,
                rate_Com_TF,
                period_Com,
                period_Com_TF,
                monthlyAddition_Com,
                monthlyAddition_Com_TF,
                fv_Com,
                fv_Com_TF,
                calculateBtn_Com,
                FinancialCalculator.MSG("WithoutRate",415));

        HBox compoundSavingHBOX = new HBox(-149);
        compoundSavingHBOX.getChildren().addAll(
                CompoundSavingPane,
                compoundSavingsKeyboard.displayKeyboard());
        return compoundSavingHBOX;
    }
}
