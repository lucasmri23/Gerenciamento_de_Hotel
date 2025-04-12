package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.TipoQuarto;

public class TipoQuartoDAO implements IDAO<TipoQuarto>{
    
    @Override
    public String cadastrar(TipoQuarto tipoQuarto, Connection conexao) {
        try {
            String sql = "INSERT INTO gerenciamento_de_tipos_de_quarto (id_tipo, descricao) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, tipoQuarto.getId());
            preparedStatement.setString(2, tipoQuarto.getDescricao());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Tipo de quarto cadastrado com sucesso!";
            } else {
                return "Falha ao cadastrar o tipo de quarto!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o tipo de quarto: " + ex.getMessage();
        }
    }

    @Override
    public String atualizar(TipoQuarto tipoQuarto, Connection conexao) {
        try {
            String sql = "UPDATE gerenciamento_de_tipos_de_quarto SET descricao = ? WHERE id_tipo = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, tipoQuarto.getDescricao());
            preparedStatement.setInt(2, tipoQuarto.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Tipo do Quarto atualizado com sucesso!";
            } else {
                return "Falha ao atualizar o tipo do quarto!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao atualizar o tipo do quarto: " + ex.getMessage();
        }
    }

    @Override
    public String excluir(Connection conexao, String remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, long remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, int remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_tipos_de_quarto WHERE id_tipo = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Tipo de quarto removido do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o tipo de quarto do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir o tipo de quarto: " + ex.getMessage();
        }
    }

    @Override
    public void listar(Connection conexao) {
    try {
        Statement declaracao = conexao.createStatement();

        String sql = "SELECT * FROM gerenciamento_de_tipos_de_quarto";
        
        ResultSet resultado = declaracao.executeQuery(sql);

        while (resultado.next()) {
            int id = resultado.getInt("id_tipo");
            String descricao = resultado.getString("descricao");

            System.out.println("\nTipo do quarto: " + id + " | Descrição do quarto: " + descricao);
        }
        resultado.close();
        declaracao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
}
