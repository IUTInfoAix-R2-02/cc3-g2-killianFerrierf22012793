package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;
    private float textFieldValue;
    private float comp1;
    private float comp2;
    private float comp3;
    private float comp4;
    private float comp5;
    private float comp6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFieldValue = 0;
        comp1 = -1;
        comp2 = -1;
        comp3 = -1;
        comp4 = -1;
        comp5 = -1;
        comp6 = -1;
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    public void tracerAction(ActionEvent actionEvent) {

    }

    public void viderAction(ActionEvent actionEvent) {
    }

    public float retourneTextFieldValue(KeyEvent actionEvent){
        if (actionEvent.getCode() == KeyCode.ENTER) {
            if (actionEvent.getSource() instanceof TextField) {
                TextField textField = (TextField) actionEvent.getSource();
                String textFieldValueString = textField.getText();
                try {
                    textFieldValue = Float.parseFloat(textFieldValueString);
                } catch (NumberFormatException e) {
                    System.out.println("Ce n'est pas un nombre !");
                }
                return textFieldValue;
            }
        }
        return -1;
    }

    public void comp1Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1) {
            comp1 = value;
        }
    }

    public void comp2Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1) {
            comp2 = value;
        }
    }

    public void comp3Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1) {
            comp3 = value;
        }
    }

    public void comp4Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1) {
            comp4 = value;
        }
    }

    public void comp5Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1) {
            comp5 = value;
        }
    }

    public void comp6Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1) {
            comp6 = value;
        }
    }


}
