package com.example.viagem.controller;

import com.example.viagem.Main;
import com.example.viagem.db.Conexao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViagemController implements Initializable {
    @FXML
    private ChoiceBox<String> cb_carro;
    @FXML
    private TextField txf_origem;
    @FXML
    private TextField txf_destino;
    @FXML
    private Button bt_viajar;
    public void solicitarViagem() {

       if (cb_carro.getValue() == null || txf_origem.getText() == null || txf_origem.getText() == "" || txf_destino.getText() == null || txf_destino.getText() == "" ){
           com.example.viagem.util.Alert.showAlert("Erro!", null, "Todos os campos precisam ser preenchidos!", javafx.scene.control.Alert.AlertType.ERROR);
       }else {
           String carro = cb_carro.getValue();
           String ori = txf_origem.getText();
           String des = txf_destino.getText();

           try {
               PreparedStatement pre = conn.recuperaConexao()
                       .prepareStatement("INSERT INTO viagem (modelo, origem, destino) VALUES (?, ?, ?);");
               pre.setString(1, carro);
               pre.setString(2, ori);
               pre.setString(3, des);

               pre.executeUpdate();
               pre.close();
           } catch (SQLException e) {
               throw new RuntimeException();
           }
           com.example.viagem.util.Alert.showAlert("Sucesso!", null, "Viagem solicitada com sucesso!", Alert.AlertType.WARNING);
           cb_carro.setValue(null);
           txf_origem.clear();
           txf_destino.clear();
       }
    }
    @FXML
    private Button bt_cancelaViagem;
    public void cancelaViagem()throws IOException {
        Main.mudaTela("menu");
    }

    Conexao conn = new Conexao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cb_carro.getItems().addAll(conn.resultSet("modelo", "veiculo"));

    }
}