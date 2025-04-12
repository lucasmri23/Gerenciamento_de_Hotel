package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Funcionario;

public class FuncionarioDAO implements IDAO<Funcionario> {

    @Override
    public String cadastrar(Funcionario funcionario, Connection conexao) {
        try {
            String sql = "INSERT INTO gerenciamento_de_funcionarios (cpf, nome, cargo) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, funcionario.getCpf());
            preparedStatement.setString(2, funcionario.getNome());
            preparedStatement.setString(3, funcionario.getCargo());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Funcionário cadastrado com sucesso! ";
            } else {
                return "Falha ao cadastrar o funcionário!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o funcionário: " + ex.getMessage();
        }
    }

    @Override
    public String atualizar(Funcionario funcionario, Connection conexao) {
        try {
            String sql = "UPDATE gerenciamento_de_funcionarios SET nome = ?, cargo = ? WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCargo());
            preparedStatement.setString(3, funcionario.getCpf());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Funcionário atualizado com sucesso!";
            } else {
                return "Falha ao atualizar o funcionário!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao atualizar o funcionário: " + ex.getMessage();
        }
    }

    @Override
    public String excluir(Connection conexao, String remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_funcionarios WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Funcionário removido do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o funcionário do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir o funcionário: " + ex.getMessage();
        }
    }

    @Override
    public String excluir(Connection conexao, long remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, int remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void listar(Connection conexao) {
        try {
        Statement declaracao = conexao.createStatement();

        String sql = "SELECT * FROM gerenciamento_de_funcionarios";
        
        ResultSet resultado = declaracao.executeQuery(sql);

        while (resultado.next()) {
            String cpf = resultado.getString("cpf");
            String nome = resultado.getString("nome");
            String cargo = resultado.getString("cargo");

            System.out.println("\nCPF: " + cpf + " | Nome do funcionário: " + nome + " | Cargo: " + cargo);
        }
        resultado.close();
        declaracao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
}
