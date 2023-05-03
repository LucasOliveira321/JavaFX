package com.example.viagem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static Stage stage;
    @Override
    public void start(Stage Pstage) throws IOException {
        confTela("login-view.fxml", "Tela de Login",Pstage);

//        FXMLLoader fmx = new FXMLLoader(getClass().getResource("menu-view.fxml"));
//        Parent root = fmx.load();
//        Scene tela = new Scene(root);
//        stage.setTitle("Tela Login");
//        stage.setScene(tela);
//        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch();
    }

    public void confTela(String novaTela,String titulo,Stage Pstage) throws IOException {
        stage = Pstage;
        Pstage.setTitle(titulo);
        FXMLLoader fmx = new FXMLLoader(getClass().getResource(novaTela));
        Parent root = fmx.load();
        Scene tela = new Scene(root);

        Image icon = new Image(getClass().getResourceAsStream("logo.png"));
        stage.getIcons().add(icon);

        Pstage.setScene(tela);
        Pstage.show();


    }

    public static void mudaTela(String descricao) throws IOException{
        Main main = new Main();
        switch (descricao){
            case "menu":
                main.confTela("menu-view.fxml","Menu",stage);
                break;
            case "usuario":
                main.confTela("cadastraUsuario-view.fxml","Cadastra",stage);
                break;
            case "veiculo":
                main.confTela("cadastraVeiculo-view.fxml","Cadastra Veiculo",stage);
                break;
            case "viagem":
                main.confTela("solicitaViagem-view.fxml","Solicita Viagem",stage);
                break;
            case "login":
                main.confTela("login-view","Tela de Login", stage);
        }
    }
}