module com.example.projet2javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports com.example.projet2javafx.controller;
    opens com.example.projet2javafx.controller to javafx.fxml;
    exports com.example.projet2javafx.model;
    opens com.example.projet2javafx.model to javafx.fxml;
}