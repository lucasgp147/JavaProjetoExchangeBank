/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Lucas
 */
import Model.UsuarioManager;
import View.LoginView;


public class Main {
    public static void main(String[] args) {
        // URL de conexão com o ElephantSQL
        String dbUrl = "jdbc:postgresql://isabelle.db.elephantsql.com/pouaxrxb?user=pouaxrxb&password=wAXeNAZrtlbycvb5Wklrqh0PbA1xsC1K";

        UsuarioManager usuarioManager = new UsuarioManager(dbUrl);
        LoginView loginView = new LoginView(usuarioManager);
        loginView.setVisible(true);
    }
}