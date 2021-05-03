package FinancialApp;

import javafx.scene.control.Alert;

public class help {
    public static Alert Help(){
        Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);       //Alert Box
        helpAlert.setTitle(null);
        helpAlert.setContentText(
                " --> In the Savings you have two choices, one is Simple Savings and other is Compound Savings.\n\n" +
                " --> Using custom keyboard, first you should select text field what you going to enter value then by clicking numeric numbers you can entered values.\n\n"+
                " --> You can leave one field what need to calculate and fill the rest.\n\n"+
                " --> But you must fill the rate field for your calculation except Simple Savings rate field."
        );
        helpAlert.showAndWait();

        return helpAlert;
    }
}
