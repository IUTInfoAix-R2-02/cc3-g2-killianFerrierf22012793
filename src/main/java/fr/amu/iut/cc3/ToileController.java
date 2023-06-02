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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.BLACK;

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
    @FXML
    private Pane radar;

    private Circle point1;
    private Circle point2;
    private Circle point3;
    private Circle point4;
    private Circle point5;
    private Circle point6;

    private Line ligne1;
    private Line ligne2;
    private Line ligne3;
    private Line ligne4;
    private Line ligne5;
    private Line ligne6;

    private static final int radius = 5;

    @FXML
    TextField inputComp1;
    @FXML
    TextField inputComp2;
    @FXML
    TextField inputComp3;
    @FXML
    TextField inputComp4;
    @FXML
    TextField inputComp5;
    @FXML
    TextField inputComp6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFieldValue = 0;
        comp1 = -1;
        comp2 = -1;
        comp3 = -1;
        comp4 = -1;
        comp5 = -1;
        comp6 = -1;
        point1 = new Circle(radius, BLACK);
        point2 = new Circle(radius, BLACK);
        point3 = new Circle(radius, BLACK);
        point4 = new Circle(radius, BLACK);
        point5 = new Circle(radius, BLACK);
        point6 = new Circle(radius, BLACK);
        radar.getChildren().addAll(point1, point2, point3, point4, point5, point6);
        ligne1 = new Line();
        ligne1.setStyle("-fx-stroke: BLACK");
        ligne2 = new Line();
        ligne2.setStyle("-fx-stroke: BLACK");
        ligne3 = new Line();
        ligne3.setStyle("-fx-stroke: BLACK");
        ligne4 = new Line();
        ligne4.setStyle("-fx-stroke: BLACK");
        ligne5 = new Line();
        ligne5.setStyle("-fx-stroke: BLACK");
        ligne6 = new Line();
        ligne6.setStyle("-fx-stroke: BLACK");
        radar.getChildren().addAll(ligne1, ligne2, ligne3, ligne4, ligne5, ligne6);
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
        if (comp1!=-1 && comp2!=-1 && comp3!=-1 && comp4!=-1 && comp5!=-1 && comp6!=-1) {
            ligne1 = new Line(point1.getCenterX(), point1.getCenterY(), point2.getCenterX(), point2.getCenterY());
            ligne1.setStyle("-fx-stroke: BLACK");
            ligne2 = new Line(point2.getCenterX(), point2.getCenterY(), point3.getCenterX(), point3.getCenterY());
            ligne2.setStyle("-fx-stroke: BLACK");
            ligne3 = new Line(point3.getCenterX(), point3.getCenterY(), point4.getCenterX(), point4.getCenterY());
            ligne3.setStyle("-fx-stroke: BLACK");
            ligne4 = new Line(point4.getCenterX(), point4.getCenterY(), point5.getCenterX(), point5.getCenterY());
            ligne4.setStyle("-fx-stroke: BLACK");
            ligne5 = new Line(point5.getCenterX(), point5.getCenterY(), point6.getCenterX(), point6.getCenterY());
            ligne5.setStyle("-fx-stroke: BLACK");
            ligne6 = new Line(point6.getCenterX(), point6.getCenterY(), point1.getCenterX(), point1.getCenterY());
            ligne6.setStyle("-fx-stroke: BLACK");
            radar.getChildren().addAll(ligne1, ligne2, ligne3, ligne4, ligne5, ligne6);
        } else {
            System.out.println("Il manque des points pour compléter me schéma");
        }
    }

    public void viderAction(ActionEvent actionEvent) {
        radar.getChildren().removeAll(point1, point2, point3, point4, point5, point6, ligne1, ligne2, ligne3, ligne4, ligne5, ligne6);
        textFieldValue = 0;
        comp1 = -1;
        comp2 = -1;
        comp3 = -1;
        comp4 = -1;
        comp5 = -1;
        comp6 = -1;
        point1 = new Circle(radius, BLACK);
        point2 = new Circle(radius, BLACK);
        point3 = new Circle(radius, BLACK);
        point4 = new Circle(radius, BLACK);
        point5 = new Circle(radius, BLACK);
        point6 = new Circle(radius, BLACK);
        radar.getChildren().addAll(point1, point2, point3, point4, point5, point6);
    }

    public float retourneTextFieldValue(KeyEvent actionEvent){
        textFieldValue = -1;
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
        if (value!=-1 && value <= 20) {
            comp1 = value;
            point1.setCenterX(getXRadarChart(comp1,1));
            point1.setCenterY(getYRadarChart(comp1, 1));
        }
    }

    public void comp2Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1 && value <= 20) {
            comp2 = value;
            point2.setCenterX(getXRadarChart(comp2,2));
            point2.setCenterY(getYRadarChart(comp2, 2));

        }
    }

    public void comp3Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1 && value <= 20) {
            comp3 = value;
            point3.setCenterX(getXRadarChart(comp3,3));
            point3.setCenterY(getYRadarChart(comp3, 3));
        }
    }

    public void comp4Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1 && value <= 20) {
            comp4 = value;
            point4.setCenterX(getXRadarChart(comp4,4));
            point4.setCenterY(getYRadarChart(comp4, 4));
        }
    }

    public void comp5Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1 && value <= 20) {
            comp5 = value;
            point5.setCenterX(getXRadarChart(comp5,5));
            point5.setCenterY(getYRadarChart(comp5, 5));
        }
    }

    public void comp6Action(KeyEvent actionEvent) {
        float value = retourneTextFieldValue(actionEvent);
        if (value!=-1 && value <= 20) {
            comp6 = value;
            point6.setCenterX(getXRadarChart(comp6,6));
            point6.setCenterY(getYRadarChart(comp6, 6));
        }
    }
}
