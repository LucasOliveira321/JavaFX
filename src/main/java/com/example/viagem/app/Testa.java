package com.example.viagem.app;

import com.example.viagem.objetos.Usuario;

import java.time.LocalDate;

public class Testa {
    public static void main(String[] args) {
        Usuario user = new Usuario("teste","teste","teste",LocalDate.of(1996,05,15));
        user.adicionaUsuario(user);

        System.out.println(user.getCadastrados());
    }
}
