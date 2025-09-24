package com.example.projet2javafx.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Tp2 extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Tp2.class.getResource("/com/example/projet2javafx/view/priseRdv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setTitle("TP 2 | Prise de RDV");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(Tp2.class.getResourceAsStream("/com/example/projet2javafx/assets/img/favicon.png"))));
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }

}
