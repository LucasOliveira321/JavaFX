package com.example.viagem.objetos;

import java.util.ArrayList;

public class Viagem {
    private Veiculo carro;
    private String destino;
    private String origem;
    private ArrayList<Viagem> viagens = new ArrayList<>();

    public Viagem(Veiculo carro, String destino, String origem) {
        this.carro = carro;
        this.destino = destino;
        this.origem = origem;
    }
    public Veiculo getCarro() {
        return carro;
    }
    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

}
