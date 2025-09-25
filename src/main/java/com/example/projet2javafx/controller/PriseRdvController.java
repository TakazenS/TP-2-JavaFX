package com.example.projet2javafx.controller;

import com.example.projet2javafx.model.Rdv;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.ResourceBundle;

public class PriseRdvController implements Initializable
{
    @FXML private RadioButton radioMr;
    @FXML private RadioButton radioMme;
    @FXML private ToggleGroup grpSexe;
    @FXML private TextField fieldNom;
    @FXML private TextField fieldPrenom;
    @FXML private TextField fieldSS;
    @FXML private TextField fieldSujet;
    @FXML private CheckBox checkBoxReponse;
    @FXML private Label labelReponse;
    @FXML private DatePicker datePickerRdv;
    @FXML private Spinner<Integer> fromHour;
    @FXML private Spinner<Integer> fromMinute;
    @FXML private Spinner<Integer> toHour;
    @FXML private Spinner<Integer> toMinute;
    @FXML private TextArea areaCommentaire;
    @FXML private Label errorRdvLabel;
    @FXML private Button btnValiderRdv;

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

    private String formatTextField(TextField txt)
    {
        return txt.getText().substring(0, 1).toUpperCase() + txt.getText().substring(1).toLowerCase();
    }

    private String formatTextArea(TextArea txt)
    {
        if (Objects.equals(txt.getText(), "")) {return "";}
        return txt.getText().substring(0, 1).toUpperCase() + txt.getText().substring(1).toLowerCase();
    }

    @FXML
    public void evntValiderRdvClicked()
    {
        try
        {
            if ((fieldNom.getLength() <= 0) || (fieldPrenom.getLength() <= 0) || (fieldSS.getLength() <= 0)) {
                errorRdvLabel.setText("Veuillez entrer des valeurs correctes !");
                return;
            }

            String regexfieldSS = "^[0-9]{13}$";
            if (!(fieldSS.getText().matches(regexfieldSS))) {
                errorRdvLabel.setText("Veuillez entrer des caractère correctes pour le n° de SS !");
                return;
            }

            if (!(fieldSS.getLength() == 13)) {
                errorRdvLabel.setText("Veuillez entrer un n° de sécutitée sociale correcte !");
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

            String prenom = formatTextField(fieldPrenom);
            String sujet = formatTextField(fieldSujet);
            String commentaire = formatTextArea(areaCommentaire);

            Rdv rdv = new Rdv(
                    radioMr.isSelected() ? 1 : 2,
                    fieldNom.getText().toUpperCase(),
                    prenom,
                    fieldSS.getText(),
                    sujet,
                    checkBoxReponse.isSelected(),
                    datePickerRdv.getValue(),
                    fromHour.getValue(),
                    fromMinute.getValue(),
                    toHour.getValue(),
                    toMinute.getValue(),
                    commentaire
            );

            FXMLLoader fxmlLoader = new FXMLLoader(Tp2.class.getResource("/com/example/projet2javafx/view/confirmationRdv.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);
            Stage stage = new Stage();
            stage.setTitle("TP 2 | Confirmation RDV");
            stage.setScene(scene);
            stage.setResizable(true);
            stage.getIcons().add(new Image(Objects.requireNonNull(Tp2.class.getResourceAsStream("/com/example/projet2javafx/assets/img/favicon.png"))));
            stage.initModality(Modality.APPLICATION_MODAL);

            ConfirmationRdvController confirmRdvController = fxmlLoader.getController();
            confirmRdvController.setRdv(rdv);

            stage.showAndWait();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
