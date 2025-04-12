package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Quarto;
public class QuartoDAO implements IDAO<Quarto> {
    
    @Override
    public String cadastrar(Quarto quarto, Connection conexao) {
        try {
            String sql = "INSERT INTO gerenciamento_de_quartos_da_reserva (num_quarto, fk_reserva, fk_tipo) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setLong(1, quarto.getIdQuarto());
            preparedStatement.setInt(2, quarto.getIdReserva());
            preparedStatement.setInt(3, quarto.getIdTipo());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Quarto cadastrado com sucesso!";
            } else {
                return "Falha ao cadastrar o quarto!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o quarto: " + ex.getMessage();
        }
    }

    @Override
    public String atualizar(Quarto quarto, Connection conexao) {
        try {
            String sql = "UPDATE gerenciamento_de_quartos_da_reserva SET fk_reserva = ?, fk_tipo = ? WHERE num_quarto = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, quarto.getIdReserva());
            preparedStatement.setInt(2, quarto.getIdTipo());
            preparedStatement.setInt(3, quarto.getIdQuarto());

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, long remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_quartos_da_reserva WHERE num_quarto = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setLong(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Quarto removido do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o Quarto do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir o Quarto: " + ex.getMessage();
        }
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

        String sql = "SELECT * FROM gerenciamento_de_quartos_da_reserva";
        
        ResultSet resultado = declaracao.executeQuery(sql);

        while (resultado.next()) {
            long id = resultado.getLong("num_quarto");
            int idReserva = resultado.getInt("fk_reserva");
            int tipo = resultado.getInt("fk_tipo");

            System.out.println("\nNumero do quarto: " + id + " | Id da reserva: " + idReserva + " | Tipo do quarto: " + tipo);
        }
        resultado.close();
        declaracao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    }
    
}
