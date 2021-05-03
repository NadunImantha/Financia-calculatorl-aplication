package FinancialApp;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class history {
    public static Pane History() throws FileNotFoundException {
        Label titleHis = new Label("HISTORY");
        titleHis.setFont(Font.font(31));
        titleHis.setLayoutX(110); titleHis.setLayoutY(28);

        FileInputStream file = new FileInputStream("history.txt");
        Scanner input = new Scanner(file);
        String data = "";
        while(input.hasNextLine())         //reads lines in file
        {
            String currentText = input.nextLine();
            data = data.concat(currentText+"\n");
        }
        input.close();     //closes the scanner
        TextArea displayHistory = new TextArea(data);
        displayHistory.setEditable(false);  //disable edit
        displayHistory.setLayoutY(87);
        displayHistory.setPrefHeight(418);
        displayHistory.setPrefWidth(816);

        Pane historyPane = new Pane();
        historyPane.getChildren().addAll(
                titleHis,
                displayHistory);

        return historyPane;
    }
}
