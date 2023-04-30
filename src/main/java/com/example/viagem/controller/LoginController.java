package com.example.viagem.controller;

import com.example.viagem.db.Conexao;
import com.example.viagem.util.Alert;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    Conexao conn = new Conexao();
    @FXML
    private TextField txf_login;
    @FXML
    private TextField pf_senha;
    @FXML
    private Button bt_entrarLogin;
    public void entrarLogin(){
        String log = txf_login.getText();
        String sen = pf_senha.getText();

        if(conn.resultSet("login","usuario").contains(log) & conn.resultSet("senha","usuario").contains(sen)){
            System.out.println("deu certo!");
        }else {
            Alert.showAlert("Error", null, "Login ou Senha está incorreto!", javafx.scene.control.Alert.AlertType.ERROR);
        }
        txf_login.clear();
        pf_senha.clear();
    }
    @FXML
    private Button bt_sairLogin;

    public void sairLogin(){
        bt_sairLogin.setOnAction(ActionEvent -> Platform.exit());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
