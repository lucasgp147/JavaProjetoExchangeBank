/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



public class Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private double saldoReais;
    private double saldoBTC;
    private double saldoETH;
    private double saldoXRP;

    public Usuario(String nome, String cpf, String senha, double saldoReais, double saldoBTC, double saldoETH, double saldoXRP) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.saldoReais = saldoReais;
        this.saldoBTC = saldoBTC;
        this.saldoETH = saldoETH;
        this.saldoXRP = saldoXRP;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldoReais() {
        return saldoReais;
    }

    public void setSaldoReais(double saldoReais) {
        this.saldoReais = saldoReais;
    }

    public double getSaldoBTC() {
        return saldoBTC;
    }

    public void setSaldoBTC(double saldoBTC) {
        this.saldoBTC = saldoBTC;
    }

    public double getSaldoETH() {
        return saldoETH;
    }

    public void setSaldoETH(double saldoETH) {
        this.saldoETH = saldoETH;
    }

    public double getSaldoXRP() {
        return saldoXRP;
    }

    public void setSaldoXRP(double saldoXRP) {
        this.saldoXRP = saldoXRP;
    }
}