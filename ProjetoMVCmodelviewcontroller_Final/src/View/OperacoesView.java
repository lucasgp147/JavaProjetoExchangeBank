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

public class OperacoesView extends JFrame {

    private UsuarioManager usuarioManager;
    private Usuario usuario;
    private MainView mainView;
    private DecimalFormat decimalFormat;

    public OperacoesView(UsuarioManager usuarioManager, Usuario usuario, MainView mainView) {
        this.usuarioManager = usuarioManager;
        this.usuario = usuario;
        this.mainView = mainView;
        this.decimalFormat = new DecimalFormat("#0.00");

        setTitle("Operações - Exchange de Criptomoedas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblDepositar = new JLabel("Depositar Reais:");
        JTextField txtDepositar = new JTextField();
        JButton btnDepositar = new JButton("Depositar");

        panel.add(lblDepositar, gbc);
        gbc.gridx = 1;
        panel.add(txtDepositar, gbc);
        gbc.gridx = 2;
        panel.add(btnDepositar, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblSacar = new JLabel("Sacar Reais:");
        JTextField txtSacar = new JTextField();
        JButton btnSacar = new JButton("Sacar");

        panel.add(lblSacar, gbc);
        gbc.gridx = 1;
        panel.add(txtSacar, gbc);
        gbc.gridx = 2;
        panel.add(btnSacar, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblConverterBTC = new JLabel("Converter Reais para BTC:");
        JTextField txtConverterBTC = new JTextField();
        JButton btnConverterBTC = new JButton("Converter");

        panel.add(lblConverterBTC, gbc);
        gbc.gridx = 1;
        panel.add(txtConverterBTC, gbc);
        gbc.gridx = 2;
        panel.add(btnConverterBTC, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblConverterETH = new JLabel("Converter Reais para ETH:");
        JTextField txtConverterETH = new JTextField();
        JButton btnConverterETH = new JButton("Converter");

        panel.add(lblConverterETH, gbc);
        gbc.gridx = 1;
        panel.add(txtConverterETH, gbc);
        gbc.gridx = 2;
        panel.add(btnConverterETH, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblConverterXRP = new JLabel("Converter Reais para XRP:");
        JTextField txtConverterXRP = new JTextField();
        JButton btnConverterXRP = new JButton("Converter");

        panel.add(lblConverterXRP, gbc);
        gbc.gridx = 1;
        panel.add(txtConverterXRP, gbc);
        gbc.gridx = 2;
        panel.add(btnConverterXRP, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblConverterBTCParaReais = new JLabel("Converter BTC para Reais:");
        JTextField txtConverterBTCParaReais = new JTextField();
        JButton btnConverterBTCParaReais = new JButton("Converter");

        panel.add(lblConverterBTCParaReais, gbc);
        gbc.gridx = 1;
        panel.add(txtConverterBTCParaReais, gbc);
        gbc.gridx = 2;
        panel.add(btnConverterBTCParaReais, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblConverterETHParaReais = new JLabel("Converter ETH para Reais:");
        JTextField txtConverterETHParaReais = new JTextField();
        JButton btnConverterETHParaReais = new JButton("Converter");

        panel.add(lblConverterETHParaReais, gbc);
        gbc.gridx = 1;
        panel.add(txtConverterETHParaReais, gbc);
        gbc.gridx = 2;
        panel.add(btnConverterETHParaReais, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblConverterXRPParaReais = new JLabel("Converter XRP para Reais:");
        JTextField txtConverterXRPParaReais = new JTextField();
        JButton btnConverterXRPParaReais = new JButton("Converter");

        panel.add(lblConverterXRPParaReais, gbc);
        gbc.gridx = 1;
        panel.add(txtConverterXRPParaReais, gbc);
        gbc.gridx = 2;
        panel.add(btnConverterXRPParaReais, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel(), gbc); // Espaço vazio
        gbc.gridx = 1;
        JButton btnVoltar = new JButton("Voltar");
        panel.add(btnVoltar, gbc);

        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(txtDepositar.getText());
                if (usuarioManager.depositarReais(usuario.getCpf(), valor)) {
                    JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                    usuario.setSaldoReais(usuario.getSaldoReais() + valor);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar depósito.");
                }
            }
        });

        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(txtSacar.getText());
                if (usuarioManager.sacarReais(usuario.getCpf(), valor)) {
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                    usuario.setSaldoReais(usuario.getSaldoReais() - valor);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar saque. Saldo insuficiente.");
                }
            }
        });

        btnConverterBTC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(txtConverterBTC.getText());
                double taxa = valor * 0.02;
                double cotacaoBTC = usuarioManager.getTaxaAleatoria(usuarioManager.getCotacaoBTC());
                double valorFinal = (valor - taxa) / cotacaoBTC;
                int confirm = JOptionPane.showConfirmDialog(null, "Taxa: " + decimalFormat.format(taxa) + " Reais. Valor final: " + decimalFormat.format(valorFinal) + " BTC.\nDeseja continuar?");
                if (confirm == JOptionPane.YES_OPTION) {
                    if (usuarioManager.converterReaisParaBTC(usuario.getCpf(), valor)) {
                        JOptionPane.showMessageDialog(null, "Conversão realizada com sucesso!");
                        usuario.setSaldoReais(usuario.getSaldoReais() - valor);
                        usuario.setSaldoBTC(usuario.getSaldoBTC() + valorFinal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar conversão. Saldo insuficiente.");
                    }
                }
            }
        });

        btnConverterETH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(txtConverterETH.getText());
                double taxa = valor * 0.01;
                double cotacaoETH = usuarioManager.getTaxaAleatoria(usuarioManager.getCotacaoETH());
                double valorFinal = (valor - taxa) / cotacaoETH;
                int confirm = JOptionPane.showConfirmDialog(null, "Taxa: " + decimalFormat.format(taxa) + " Reais. Valor final: " + decimalFormat.format(valorFinal) + " ETH.\nDeseja continuar?");
                if (confirm == JOptionPane.YES_OPTION) {
                    if (usuarioManager.converterReaisParaETH(usuario.getCpf(), valor)) {
                        JOptionPane.showMessageDialog(null, "Conversão realizada com sucesso!");
                        usuario.setSaldoReais(usuario.getSaldoReais() - valor);
                        usuario.setSaldoETH(usuario.getSaldoETH() + valorFinal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar conversão. Saldo insuficiente.");
                    }
                }
            }
        });

        btnConverterXRP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(txtConverterXRP.getText());
                double taxa = valor * 0.01;
                double cotacaoXRP = usuarioManager.getTaxaAleatoria(usuarioManager.getCotacaoXRP());
                double valorFinal = (valor - taxa) / cotacaoXRP;
                int confirm = JOptionPane.showConfirmDialog(null, "Taxa: " + decimalFormat.format(taxa) + " Reais. Valor final: " + decimalFormat.format(valorFinal) + " XRP.\nDeseja continuar?");
                if (confirm == JOptionPane.YES_OPTION) {
                    if (usuarioManager.converterReaisParaXRP(usuario.getCpf(), valor)) {
                        JOptionPane.showMessageDialog(null, "Conversão realizada com sucesso!");
                        usuario.setSaldoReais(usuario.getSaldoReais() - valor);
                        usuario.setSaldoXRP(usuario.getSaldoXRP() + valorFinal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar conversão. Saldo insuficiente.");
                    }
                }
            }
        });

        btnConverterBTCParaReais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorBTC = Double.parseDouble(txtConverterBTCParaReais.getText());
                double cotacaoBTC = usuarioManager.getTaxaAleatoria(usuarioManager.getCotacaoBTC());
                double valorReais = valorBTC * cotacaoBTC;
                double taxa = valorReais * 0.03;
                valorReais -= taxa;
                int confirm = JOptionPane.showConfirmDialog(null, "Taxa: " + decimalFormat.format(taxa) + " Reais. Valor final: " + decimalFormat.format(valorReais) + " Reais.\nDeseja continuar?");
                if (confirm == JOptionPane.YES_OPTION) {
                    if (usuarioManager.converterBTCParaReais(usuario.getCpf(), valorBTC)) {
                        JOptionPane.showMessageDialog(null, "Conversão realizada com sucesso!");
                        usuario.setSaldoBTC(usuario.getSaldoBTC() - valorBTC);
                        usuario.setSaldoReais(usuario.getSaldoReais() + valorReais);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar conversão. Saldo insuficiente.");
                    }
                }
            }
        });

        btnConverterETHParaReais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorETH = Double.parseDouble(txtConverterETHParaReais.getText());
                double cotacaoETH = usuarioManager.getTaxaAleatoria(usuarioManager.getCotacaoETH());
                double valorReais = valorETH * cotacaoETH;
                double taxa = valorReais * 0.02;
                valorReais -= taxa;
                int confirm = JOptionPane.showConfirmDialog(null, "Taxa: " + decimalFormat.format(taxa) + " Reais. Valor final: " + decimalFormat.format(valorReais) + " Reais.\nDeseja continuar?");
                if (confirm == JOptionPane.YES_OPTION) {
                    if (usuarioManager.converterETHParaReais(usuario.getCpf(), valorETH)) {
                        JOptionPane.showMessageDialog(null, "Conversão realizada com sucesso!");
                        usuario.setSaldoETH(usuario.getSaldoETH() - valorETH);
                        usuario.setSaldoReais(usuario.getSaldoReais() + valorReais);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar conversão. Saldo insuficiente.");
                    }
                }
            }
        });

        btnConverterXRPParaReais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valorXRP = Double.parseDouble(txtConverterXRPParaReais.getText());
                double cotacaoXRP = usuarioManager.getTaxaAleatoria(usuarioManager.getCotacaoXRP());
                double valorReais = valorXRP * cotacaoXRP;
                double taxa = valorReais * 0.02;
                valorReais -= taxa;
                int confirm = JOptionPane.showConfirmDialog(null, "Taxa: " + decimalFormat.format(taxa) + " Reais. Valor final: " + decimalFormat.format(valorReais) + " Reais.\nDeseja continuar?");
                if (confirm == JOptionPane.YES_OPTION) {
                    if (usuarioManager.converterXRPParaReais(usuario.getCpf(), valorXRP)) {
                        JOptionPane.showMessageDialog(null, "Conversão realizada com sucesso!");
                        usuario.setSaldoXRP(usuario.getSaldoXRP() - valorXRP);
                        usuario.setSaldoReais(usuario.getSaldoReais() + valorReais);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao realizar conversão. Saldo insuficiente.");
                    }
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.atualizarSaldos();
                mainView.setVisible(true);
                OperacoesView.this.dispose();
            }
        });

        add(panel);
    }
}