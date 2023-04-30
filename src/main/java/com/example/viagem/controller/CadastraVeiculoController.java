package com.example.viagem.controller;

import com.example.viagem.db.Conexao;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CadastraVeiculoController implements Initializable {
    @FXML
    private TextField txf_modelo;
    @FXML
    private DatePicker dt_fabricacao;
    @FXML
    private TextField txf_placa;
    @FXML
    private Button bt_cadastrarVeiculo;
    public void cadastrarVeiculo() {
        if (txf_modelo.getText() == null || txf_modelo.getText() == "" || txf_placa.getText() == null || txf_placa.getText() == "" || dt_fabricacao.getValue() == null) {
            com.example.viagem.util.Alert.showAlert("Erro!", null, "Todos os campos precisam ser preenchidos!", javafx.scene.control.Alert.AlertType.ERROR);
        } else {

            String modelo = txf_modelo.getText();
            LocalDate fab = dt_fabricacao.getValue();
            Date sqlDate = Date.valueOf(fab);
            String placa = txf_placa.getText();

            Conexao conn = new Conexao();

            try {
                PreparedStatement pre = conn.recuperaConexao()
                        .prepareStatement("INSERT INTO veiculo (placa, modelo, ano_fabricacao) VALUES (?,?,?);");
                pre.setString(1, placa);
                pre.setString(2, modelo);
                pre.setDate(3, sqlDate);

                pre.executeUpdate();
                pre.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            com.example.viagem.util.Alert.showAlert("Sucesso!", null, "Veículo cadastrado com sucesso!", Alert.AlertType.WARNING);
            txf_modelo.clear();
            dt_fabricacao.setValue(null);
            txf_placa.clear();
        }
    }
    @FXML
    private Button bt_cancelaVeiculo;
    public void cancelaVeiculo(){
        bt_cancelaVeiculo.setOnAction(actionEvent -> Platform.exit());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
