package com.example.viagem.objetos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Veiculo {
    private String modelo;
    private LocalDate anoFabricacao;
    private String placa;
    private ArrayList<Veiculo> carros = new ArrayList<>();

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public Veiculo(String modelo, LocalDate anoFabricacao, String placa){
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ArrayList<Veiculo> veiculos(){
        return carros;
    }

    public void adicionaVeiculos(Veiculo veiculo){
        carros.add(veiculo);
    }

    @Override
    public String toString() {
        return "Carro: " + getModelo() + ", Placa: "+getPlaca();
    }
}
