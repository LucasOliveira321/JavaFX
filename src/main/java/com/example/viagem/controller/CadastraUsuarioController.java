package com.example.viagem.controller;

import com.example.viagem.Main;
import com.example.viagem.db.Conexao;
import com.example.viagem.util.Alert;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CadastraUsuarioController implements Initializable {
    @FXML
    private Button bt_cancela;
    @FXML
    public void cancela()throws IOException {
        Main.mudaTela("menu");
    }

    @FXML
    private Button bt_cadastrar;
    @FXML
    public void cadastrar() {

        if (txf_login.getText() == null || txf_nome.getText() == null || pb_senhaCadUser.getText() == null || dtp_dataNascimento.getValue() == null) {
            Alert.showAlert("Erro!", null, "Todos os campos precisam ser preenchidos!", javafx.scene.control.Alert.AlertType.ERROR);
        }else {
            String login = txf_login.getText();
            String senha = pb_senhaCadUser.getText();
            String nome = txf_nome.getText();
            LocalDate dtNascimento = dtp_dataNascimento.getValue();
            Date sqlDate = Date.valueOf(dtNascimento);


            try {
                Conexao conn = new Conexao();
                PreparedStatement pre = conn.recuperaConexao()
                        .prepareStatement("INSERT INTO usuario (login, senha, nome, data_nascimento) VALUES (?,?,?,?);");
                pre.setString(1, login);
                pre.setString(2, senha);
                pre.setString(3, nome);
                pre.setDate(4, sqlDate);

                pre.executeUpdate();
                pre.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Alert.showAlert("Sucesso!", null, "Cadastro Realizado com Sucesso!", javafx.scene.control.Alert.AlertType.WARNING);
            txf_login.clear();
            pb_senhaCadUser.clear();
            txf_nome.clear();
            dtp_dataNascimento.setValue(null);

        }

    }

    @FXML
    private TextField txf_login;
    @FXML
    private TextField pb_senhaCadUser;
    @FXML
    private TextField txf_nome;
    @FXML
    private DatePicker dtp_dataNascimento;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
