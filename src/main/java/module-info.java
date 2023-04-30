module com.example.viagem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.viagem to javafx.fxml;
    exports com.example.viagem.controller;
    opens com.example.viagem.controller to javafx.fxml;
    exports com.example.viagem.objetos;
    opens com.example.viagem.objetos to javafx.fxml;
    exports com.example.viagem.app;
    opens com.example.viagem.app to javafx.fxml;
    exports com.example.viagem;
}