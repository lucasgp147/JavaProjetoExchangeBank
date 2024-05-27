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
import java.text.DecimalFormat;

public class MainView extends JFrame {

    private UsuarioManager usuarioManager;
    private Usuario usuario;
    private JLabel lblSaldoReais;
    private JLabel lblSaldoBTC;
    private JLabel lblSaldoETH;
    private JLabel lblSaldoXRP;
    private DecimalFormat decimalFormat;

    public MainView(UsuarioManager usuarioManager, Usuario usuario) {
        this.usuarioManager = usuarioManager;
        this.usuario = usuario;
        this.decimalFormat = new DecimalFormat("#0.00");

        setTitle("Exchange de Criptomoedas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblNome = new JLabel("Nome: " + usuario.getNome());
        panel.add(lblNome, gbc);

        gbc.gridy++;
        JLabel lblCpf = new JLabel("CPF: " + usuario.getCpf());
        panel.add(lblCpf, gbc);

        gbc.gridy++;
        lblSaldoReais = new JLabel("Saldo em Reais: " + decimalFormat.format(usuario.getSaldoReais()));
        panel.add(lblSaldoReais, gbc);

        gbc.gridy++;
        lblSaldoBTC = new JLabel("Saldo em BTC: " + decimalFormat.format(usuario.getSaldoBTC()));
        panel.add(lblSaldoBTC, gbc);

        gbc.gridy++;
        lblSaldoETH = new JLabel("Saldo em ETH: " + decimalFormat.format(usuario.getSaldoETH()));
        panel.add(lblSaldoETH, gbc);

        gbc.gridy++;
        lblSaldoXRP = new JLabel("Saldo em XRP: " + decimalFormat.format(usuario.getSaldoXRP()));
        panel.add(lblSaldoXRP, gbc);

        gbc.gridy++;
        JButton btnOperacoes = new JButton("Operações");
        panel.add(btnOperacoes, gbc);

        gbc.gridy++;
        JButton btnLogout = new JButton("Logout");
        panel.add(btnLogout, gbc);

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
        lblSaldoReais.setText("Saldo em Reais: " + decimalFormat.format(usuario.getSaldoReais()));
        lblSaldoBTC.setText("Saldo em BTC: " + decimalFormat.format(usuario.getSaldoBTC()));
        lblSaldoETH.setText("Saldo em ETH: " + decimalFormat.format(usuario.getSaldoETH()));
        lblSaldoXRP.setText("Saldo em XRP: " + decimalFormat.format(usuario.getSaldoXRP()));
    }
}