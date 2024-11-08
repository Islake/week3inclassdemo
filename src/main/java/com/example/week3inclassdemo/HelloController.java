package com.example.week3inclassdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private TextField distanceField;

    @FXML
    private TextField fuelUsedField;

    @FXML
    private Label distanceLabel;

    @FXML
    private Label fuelLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private Button calculateButton;

    private static final double FUEL_PRICE_PER_LITER = 1.67;
    private double lastCost = 0.0;
    private boolean costCalculated = false;
    private Locale currentLocale = new Locale("en");

    @FXML
    private void initialize() {
        setLocale(currentLocale);
    }

    private void setLocale(Locale locale) {
        currentLocale = locale;
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        distanceLabel.setText(bundle.getString("distance.label"));
        fuelLabel.setText(bundle.getString("fuel.label"));
        calculateButton.setText(bundle.getString("calculate.button"));
        if (costCalculated) {
            resultLabel.setText(String.format(bundle.getString("result.label"), lastCost));
        }
    }

    @FXML
    private void calculateFuelCost() {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double fuelUsed = Double.parseDouble(fuelUsedField.getText());
            lastCost = (fuelUsed / distance) * 100 * FUEL_PRICE_PER_LITER;
            costCalculated = true;
            ResourceBundle bundle = ResourceBundle.getBundle("messages", currentLocale);
            resultLabel.setText(String.format(bundle.getString("result.label"), lastCost));
        } catch (NumberFormatException e) {
            ResourceBundle bundle = ResourceBundle.getBundle("messages", currentLocale);
            resultLabel.setText(bundle.getString("invalid.input"));
        }
    }

    public void setEN(ActionEvent actionEvent) {
        setLocale(new Locale("en"));
    }

    public void setFR(ActionEvent actionEvent) {
        setLocale(new Locale("fr"));
    }

    public void setJP(ActionEvent actionEvent) {
        setLocale(new Locale("ja"));
    }

    public void setIR(ActionEvent actionEvent) {
        setLocale(new Locale("fa"));
    }
}