package com.example.viagem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RodaTela extends Application {

    public static void main(String[]args) throws Exception{
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fmx = new FXMLLoader(getClass().getResource("cadastraVeiculo-view.fxml"));
        Parent root = fmx.load();
        Scene tela = new Scene(root);
        stage.setTitle("Tela Login");
        stage.setScene(tela);
        stage.show();
    }
}
