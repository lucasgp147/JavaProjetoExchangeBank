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

public class RegisterView extends JFrame {
    private UsuarioManager usuarioManager;

    public RegisterView(UsuarioManager usuarioManager) {
        this.usuarioManager = usuarioManager;

        setTitle("Registro - Exchange de Criptomoedas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnVoltar = new JButton("Voltar");

        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblCpf);
        panel.add(txtCpf);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(btnRegistrar);
        panel.add(btnVoltar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();
                String senha = new String(txtSenha.getPassword());
                Usuario usuario = new Usuario(nome, cpf, senha, 0, 0, 0, 0);
                if (usuarioManager.adicionarUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso!");
                    LoginView loginView = new LoginView(usuarioManager);
                    loginView.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar usuário. CPF já registrado.");
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView loginView = new LoginView(usuarioManager);
                loginView.setVisible(true);
                dispose();
            }
        });

        add(panel);
    }
}