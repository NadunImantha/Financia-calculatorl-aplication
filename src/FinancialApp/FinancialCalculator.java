package FinancialApp;

import FinancialApp.Loan.loan;
import FinancialApp.Mortgage.mortgage;
import FinancialApp.Savings.savings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinancialCalculator extends Application {

    Scene Main_Scene, Saving_Scene, Loan_Scene,Mortgage_Scene,History_Scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Financial Calculator App");


//Main_Scene
        Label title = new Label("WELCOME");
        title.setFont(Font.font(38));
        title.setLayoutX(314);
        title.setLayoutY(315);

        Button savingBtn = new Button("Saving");
        savingBtn.setLayoutX(200);
        savingBtn.setLayoutY(399);
        savingBtn.setMinWidth(72);

        Button loanBtn = new Button("Loan");
        loanBtn.setLayoutX(291);
        loanBtn.setLayoutY(399);
        loanBtn.setMinWidth(72);

        Button mortgageBtn = new Button("Mortgage");
        mortgageBtn.setLayoutX(385);
        mortgageBtn.setLayoutY(399);
        mortgageBtn.setMinWidth(72);

        Button historyBtn = new Button("History");
        historyBtn.setLayoutX(480);
        historyBtn.setLayoutY(399);
        historyBtn.setMinWidth(72);

        Button helpBtn = new Button("Help");
        helpBtn.setLayoutX(579);
        helpBtn.setLayoutY(399);
        helpBtn.setMinWidth(72);

            //Buttons on click events
        savingBtn.setOnAction(e -> primaryStage.setScene(Saving_Scene));
        loanBtn.setOnAction(e -> primaryStage.setScene(Loan_Scene));
        mortgageBtn.setOnAction(e -> primaryStage.setScene(Mortgage_Scene));
        historyBtn.setOnAction(e -> primaryStage.setScene(History_Scene));
        helpBtn.setOnAction(e -> help.Help());

        Pane MainPane = new Pane();
        MainPane.setId("MainDisplay");
        MainPane.getChildren().addAll(title, savingBtn, loanBtn, mortgageBtn, historyBtn, helpBtn);
        Main_Scene = new Scene(MainPane, 816,506);

            //link css file
        String css_main = FinancialCalculator.class.getResource("CssStyles/FinancialCalculatorStyles.css").toExternalForm();
        Main_Scene.getStylesheets().add(css_main);

            //show scene
        primaryStage.setScene(Main_Scene);
        primaryStage.show();


//Saving_Scene
        Button SavingPaneBackButton = new Button("");
        SavingPaneBackButton.setId("backBTN");
        SavingPaneBackButton.setLayoutX(30); SavingPaneBackButton.setLayoutY(50);
        SavingPaneBackButton.setOnAction(e -> primaryStage.setScene(Main_Scene));

        Pane savingsPane = new Pane();
        savingsPane.setId("PaneImage");
        savingsPane.getChildren().addAll(savings.Savings(),SavingPaneBackButton);

        Saving_Scene = new Scene(savingsPane,816,506);
        String css_saving = FinancialCalculator.class.getResource("CssStyles/Pane.css").toExternalForm();
        Saving_Scene.getStylesheets().add(css_saving);



//Loan_Scene
        Button LoanPaneBackButton = new Button("");
        LoanPaneBackButton.setId("backBTN");
        LoanPaneBackButton.setLayoutX(30); LoanPaneBackButton.setLayoutY(19);
        LoanPaneBackButton.setOnAction(e -> primaryStage.setScene(Main_Scene));

        Pane LoanPane = new Pane();
        LoanPane.setId("PaneImage");
        LoanPane.getChildren().addAll(loan.Loan(),LoanPaneBackButton,MSG("WithoutRate",444));

        Loan_Scene = new Scene(LoanPane,816,506);
        String css_loan = FinancialCalculator.class.getResource("CssStyles/Pane.css").toExternalForm();
        Loan_Scene.getStylesheets().add(css_loan);


//Mortgage_Scene
        Button MortgagePaneBackButton = new Button("");
        MortgagePaneBackButton.setId("backBTN");
        MortgagePaneBackButton.setLayoutX(30); MortgagePaneBackButton.setLayoutY(19);
        MortgagePaneBackButton.setOnAction(e -> primaryStage.setScene(Main_Scene));

        Pane MortgagePane = new Pane();
        MortgagePane.setId("PaneImage");
        MortgagePane.getChildren().addAll(mortgage.Mortgage(),MortgagePaneBackButton,MSG("WithoutRate",444));

        Mortgage_Scene = new Scene(MortgagePane,816,506);
        String css_mortgage = FinancialCalculator.class.getResource("CssStyles/Pane.css").toExternalForm();
        Mortgage_Scene.getStylesheets().add(css_mortgage);


//History_Scene
        Button HistoryPaneBackButton = new Button("");
        HistoryPaneBackButton.setId("backBTN");
        HistoryPaneBackButton.setLayoutX(30); HistoryPaneBackButton.setLayoutY(19);
        HistoryPaneBackButton.setOnAction(e -> primaryStage.setScene(Main_Scene));

        Pane HistoryPane = new Pane();
        HistoryPane.getChildren().addAll(history.History(),HistoryPaneBackButton);

        History_Scene = new Scene(HistoryPane,816,506);
        String css_history = FinancialCalculator.class.getResource("CssStyles/Pane.css").toExternalForm();
        History_Scene.getStylesheets().add(css_history);

    }
    public static Label MSG(String sceneName, int layoutY){
        String labelMSG = "";
        if (sceneName.equals("WithoutRate")){
            labelMSG = "Excluding Rate Field,\nYou Can Leave One Rest Of Fields What You Need To Calculate...";
        } else{
            labelMSG = "Leave What You Need To Calculate \nAnd Fill The Rest.....";
        }
        Label msg = new Label(labelMSG);
        msg.setId("message");
        msg.setLayoutX(25);
        msg.setLayoutY(layoutY);
        msg.setFont(Font.font(21));

        return msg;
    }

    public static void main(String[] args) {
        launch(args);
    }
}