package com.example.viagem.objetos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private LocalDate dataNascimento ;
    private static ArrayList <Usuario> cadastrados = new ArrayList<>();

    public Usuario(String login, String senha, String nome, LocalDate dataNascimento){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimento = dataNascimento;

    }

    public String getLogin(){
        return this.login;
    }
    public String getNome(){
        return this.nome;
    }
    public ArrayList<Usuario> getCadastrados(){
        return cadastrados;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void adicionaUsuario(Usuario usuario){
        cadastrados.add(usuario);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Data de Nascimento: "+ getDataNascimento();
    }
}
