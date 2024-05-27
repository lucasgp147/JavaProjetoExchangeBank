/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Lucas
 */

import Model.UsuarioManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private UsuarioManager usuarioManager;

    public LoginView(UsuarioManager usuarioManager) {
        this.usuarioManager = usuarioManager;

        setTitle("Login - Exchange de Criptomoedas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JButton btnRegistrar = new JButton("Registrar");

        panel.add(lblCpf);
        panel.add(txtCpf);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(btnLogin);
        panel.add(btnRegistrar);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = txtCpf.getText();
                String senha = new String(txtSenha.getPassword());
                var usuario = usuarioManager.buscarUsuario(cpf, senha);
                if (usuario != null) {
                    MainView mainView = new MainView(usuarioManager, usuario);
                    mainView.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
                }
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterView registerView = new RegisterView(usuarioManager);
                registerView.setVisible(true);
                dispose();
            }
        });

        add(panel);
    }
}