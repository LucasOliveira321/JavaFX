package com.example.viagem;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.SwipeEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuController{
    @FXML
    private Label lb_bemVindo;
    @FXML
    private Button bt_cadUser;
    public void mudaTelaUsuario() throws IOException{
        Main.mudaTela("usuario");
    }
    @FXML
    private Button bt_cadVeiculo;
    public void mudaTelaVeiculo() throws IOException{
        Main.mudaTela("veiculo");
    }
    @FXML
    private Button bt_solViagem;
    public void mudaTelaViagem() throws IOException{
        Main.mudaTela("viagem");
    }
    @FXML
    private Button bt_sairMenu;
    public void sairMenu(){
        bt_sairMenu.setOnAction(ActionEvent -> Platform.exit());
    }


}