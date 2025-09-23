package com.example.projet2javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class PriseRdvController implements Initializable
{
    @FXML private ToggleGroup grpSexe;
    @FXML private TextField fieldNom;
    @FXML private TextField fieldPrenom;
    @FXML private TextField fieldSS;
    @FXML private TextField fieldSujet;
    @FXML private CheckBox checkBoxReponse;
    @FXML private DatePicker datePickerRdv;
    @FXML private Spinner<Integer> fromHour;
    @FXML private Spinner<Integer> fromMinute;
    @FXML private Spinner<Integer> toHour;
    @FXML private Spinner<Integer> toMinute;
    @FXML private TextArea areaCommentaire;
    @FXML private Label errorRdvLabel;
    @FXML private Button btnValiderRdv;

    public Boolean isCheckBoxTrue = false;

    @Override
    public void initialize(URL location, ResourceBundle ressources)
    {
        datePickerRdv.setValue(LocalDate.now());

        LocalTime time = LocalTime.now();
        int setFromHour = time.getHour() + 1;
        if (setFromHour >= 18) {
            datePickerRdv.setValue(LocalDate.now().plusDays(1));
        }
        int setToHour = setFromHour + 1;

        SpinnerValueFactory<Integer> valueFactoryFromHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 18, setFromHour, 1);
        fromHour.setValueFactory(valueFactoryFromHour);
        SpinnerValueFactory<Integer> valueFactoryFromMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 55, 30, 5);
        fromMinute.setValueFactory(valueFactoryFromMinute);
        SpinnerValueFactory<Integer> valueFactoryToHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 18, setToHour, 1);
        toHour.setValueFactory(valueFactoryToHour);
        SpinnerValueFactory<Integer> valueFactoryToMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 55, 30, 5);
        toMinute.setValueFactory(valueFactoryToMinute);
    }

    @FXML
    public void evntValiderRdvClicked()
    {
        if ((fieldNom.getLength() <= 0) || (fieldPrenom.getLength() <= 0) || (fieldSS.getLength() <= 0)) {
            errorRdvLabel.setText("Veuillez entrer des valeurs correctes !");
            return;
        }

        if (fieldSujet.getLength() <= 0) {
            errorRdvLabel.setText("Veuillez entrer un sujet de rendez-vous !");
            return;
        }

        if (datePickerRdv.getValue().isBefore(LocalDate.now())) {
            errorRdvLabel.setText("Veuillez entrer une date correcte !");
            return;
        }

        LocalTime from = LocalTime.of(fromHour.getValue(), fromMinute.getValue());
        LocalTime to = LocalTime.of(toHour.getValue(), toMinute.getValue());
        if (from.isAfter(to) || from.equals(to)) {
            errorRdvLabel.setText("Veuillez entrer une heure correcte !");
            return;
        }

        if (checkBoxReponse.isSelected()) {
            isCheckBoxTrue = true;
        }

        errorRdvLabel.setText("");
    }

}
