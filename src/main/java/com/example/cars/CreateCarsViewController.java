package com.example.cars;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class CreateCarsViewController {

    @FXML
    private ComboBox<?> brandComboBox;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Spinner<?> priceSpinner;

    @FXML
    private CheckBox sportCheckBox;

}
