package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Hospede;

public class HospedeDAO implements IDAO<Hospede>{

    @Override
    public String cadastrar(Hospede hospede, Connection conexao) {
            try {
                String sql = "INSERT INTO gerenciamento_de_hospedes (cpf, nome, telefone, email) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setString(1, hospede.getCpf());
                preparedStatement.setString(2, hospede.getNome());
                preparedStatement.setString(3, hospede.getTelefone());
                preparedStatement.setString(4, hospede.getEmail());
                
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return "Hospede cadastrado com sucesso!";
                } else {
                    return "Falha ao cadastrar o hospede!";
                }
            } catch (SQLException ex) {
                return "Ocorreu um erro ao cadastrar o hospede: " + ex.getMessage();
            }
        }

    @Override
    public String atualizar(Hospede hospede, Connection conexao) {
        try {
            String sql = "UPDATE gerenciamento_de_hospedes SET nome = ?, telefone = ?, email = ? WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, hospede.getNome());
            preparedStatement.setString(2, hospede.getTelefone());
            preparedStatement.setString(3, hospede.getEmail());
            preparedStatement.setString(4, hospede.getCpf());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Hospede atualizado com sucesso!";
            } else {
                return "Falha ao atualizar o hospede!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao atualizar o hospede: " + ex.getMessage();
        }
    }

    @Override
    public String excluir(Connection conexao, String remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_hospedes WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Hospede removido do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o hospede do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir o hospede: " + ex.getMessage();
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

        String sql = "SELECT * FROM gerenciamento_de_hospedes";
        
        ResultSet resultado = declaracao.executeQuery(sql);

        while (resultado.next()) {
            String cpf = resultado.getString("cpf");
            String nome = resultado.getString("nome");
            String telefone = resultado.getString("telefone");
            String email = resultado.getString("email");

            System.out.println("\nCPF: " + cpf + " | Nome do Hóspede: " + nome + " | Telefone: " + telefone + " | Email:" + email);
        }
        resultado.close();
        declaracao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
}
