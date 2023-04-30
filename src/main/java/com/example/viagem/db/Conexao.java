package com.example.viagem.db;

import java.sql.*;
import java.util.ArrayList;

public class Conexao {

    public Connection recuperaConexao() {

        try {
            return DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BDviagem", "postgres", "123456");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> resultSet(String coluna, String tabela){
        ArrayList<String> list = new ArrayList<>();
        try {
            PreparedStatement pre = recuperaConexao().prepareStatement("SELECT "+ coluna +" FROM " + tabela +";");
            ResultSet res = pre.executeQuery();
            while (res.next()){
                String s = res.getString(1);
                list.add(s);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }
}
