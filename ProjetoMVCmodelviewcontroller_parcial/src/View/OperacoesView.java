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

public class OperacoesView extends JFrame {

    private UsuarioManager usuarioManager;
    private Usuario usuario;
    private MainView mainView;

    public OperacoesView(UsuarioManager usuarioManager, Usuario usuario, MainView mainView) {
        this.usuarioManager = usuarioManager;
        this.usuario = usuario;
        this.mainView = mainView;

        setTitle("Operações - Exchange de Criptomoedas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel lblDepositar = new JLabel("Depositar Reais:");
        JTextField txtDepositar = new JTextField();
        JButton btnDepositar = new JButton("Depositar");

        JLabel lblSacar = new JLabel("Sacar Reais:");
        JTextField txtSacar = new JTextField();
        JButton btnSacar = new JButton("Sacar");

        JButton btnVoltar = new JButton("Voltar");

        panel.add(lblDepositar);
        panel.add(txtDepositar);
        panel.add(btnDepositar);
        panel.add(new JLabel());

        panel.add(lblSacar);
        panel.add(txtSacar);
        panel.add(btnSacar);
        panel.add(new JLabel());

        panel.add(new JLabel());
        panel.add(btnVoltar);

        

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