/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Lucas
 */

import Model.Usuario;
import Model.UsuarioManager;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private UsuarioManager usuarioManager;
    private Usuario usuario;
    private JLabel lblSaldoReais;
    private JLabel lblSaldoBTC;
    private JLabel lblSaldoETH;
    private JLabel lblSaldoXRP;

    public MainView(UsuarioManager usuarioManager, Usuario usuario) {
        this.usuarioManager = usuarioManager;
        this.usuario = usuario;

        setTitle("Exchange de Criptomoedas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 1));

        JLabel lblNome = new JLabel("Nome: " + usuario.getNome());
        JLabel lblCpf = new JLabel("CPF: " + usuario.getCpf());
        lblSaldoReais = new JLabel("Saldo em Reais: " + usuario.getSaldoReais());
        lblSaldoBTC = new JLabel("Saldo em BTC: " + usuario.getSaldoBTC());
        lblSaldoETH = new JLabel("Saldo em ETH: " + usuario.getSaldoETH());
        lblSaldoXRP = new JLabel("Saldo em XRP: " + usuario.getSaldoXRP());
        JButton btnOperacoes = new JButton("Operações");
        JButton btnLogout = new JButton("Logout");

        panel.add(lblNome);
        panel.add(lblCpf);
        panel.add(lblSaldoReais);
        panel.add(lblSaldoBTC);
        panel.add(lblSaldoETH);
        panel.add(lblSaldoXRP);
        panel.add(btnOperacoes);
        panel.add(btnLogout);

        btnOperacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacoesView operacoesView = new OperacoesView(usuarioManager, usuario, MainView.this);
                operacoesView.setVisible(true);
                setVisible(false); // Ocultar a janela principal temporariamente
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView loginView = new LoginView(usuarioManager);
                loginView.setVisible(true);
                MainView.this.dispose();
            }
        });

        add(panel);
    }

    public void atualizarSaldos() {
        lblSaldoReais.setText("Saldo em Reais: " + usuario.getSaldoReais());
        lblSaldoBTC.setText("Saldo em BTC: " + usuario.getSaldoBTC());
        lblSaldoETH.setText("Saldo em ETH: " + usuario.getSaldoETH());
        lblSaldoXRP.setText("Saldo em XRP: " + usuario.getSaldoXRP());
    }
}