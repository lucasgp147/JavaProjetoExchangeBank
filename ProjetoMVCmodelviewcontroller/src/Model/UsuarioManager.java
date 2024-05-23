/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioManager {
    private Connection connection;

    public UsuarioManager(String dbUrl) {
        try {
            connection = DriverManager.getConnection(dbUrl);
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS usuarios " +
                         "(cpf TEXT PRIMARY KEY NOT NULL, " +
                         " nome TEXT NOT NULL, " +
                         " senha TEXT NOT NULL, " +
                         " saldoReais REAL, " +
                         " saldoBTC REAL, " +
                         " saldoETH REAL, " +
                         " saldoXRP REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean adicionarUsuario(Usuario usuario) {
        if (buscarUsuarioPorCpf(usuario.getCpf()) != null) {
            return false; // CPF já registrado
        }
        String sql = "INSERT INTO usuarios (cpf, nome, senha, saldoReais, saldoBTC, saldoETH, saldoXRP) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getCpf());
            pstmt.setString(2, usuario.getNome());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setDouble(4, usuario.getSaldoReais());
            pstmt.setDouble(5, usuario.getSaldoBTC());
            pstmt.setDouble(6, usuario.getSaldoETH());
            pstmt.setDouble(7, usuario.getSaldoXRP());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscarUsuario(String cpf, String senha) {
        String sql = "SELECT * FROM usuarios WHERE cpf = ? AND senha = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("senha"),
                    rs.getDouble("saldoReais"),
                    rs.getDouble("saldoBTC"),
                    rs.getDouble("saldoETH"),
                    rs.getDouble("saldoXRP")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        String sql = "SELECT * FROM usuarios WHERE cpf = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("senha"),
                    rs.getDouble("saldoReais"),
                    rs.getDouble("saldoBTC"),
                    rs.getDouble("saldoETH"),
                    rs.getDouble("saldoXRP")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, senha = ?, saldoReais = ?, saldoBTC = ?, saldoETH = ?, saldoXRP = ? WHERE cpf = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setDouble(3, usuario.getSaldoReais());
            pstmt.setDouble(4, usuario.getSaldoBTC());
            pstmt.setDouble(5, usuario.getSaldoETH());
            pstmt.setDouble(6, usuario.getSaldoXRP());
            pstmt.setString(7, usuario.getCpf());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarUsuario(String cpf) {
        String sql = "DELETE FROM usuarios WHERE cpf = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean depositarReais(String cpf, double valor) {
        String sql = "UPDATE usuarios SET saldoReais = saldoReais + ? WHERE cpf = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, valor);
            pstmt.setString(2, cpf);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sacarReais(String cpf, double valor) {
        Usuario usuario = buscarUsuarioPorCpf(cpf);
        if (usuario != null && usuario.getSaldoReais() >= valor) {
            String sql = "UPDATE usuarios SET saldoReais = saldoReais - ? WHERE cpf = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setDouble(1, valor);
                pstmt.setString(2, cpf);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false; // Saldo insuficiente
    }
}