package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Reservas;

public class ReservaDAO implements IDAO<Reservas> {

    @Override
    public String cadastrar(Reservas reserva, Connection conexao) {
        String sql = "INSERT INTO gerenciamento_de_reservas(id_reserva, data_reserva, data_retirada, fk_hospede, fk_funcionario, status) VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, reserva.getIdReserva());
            preparedStatement.setObject(2, reserva.getDataReserva());
            preparedStatement.setObject(3, reserva.getDataRetirada());
            preparedStatement.setString(4, reserva.getCpfHospede());
            preparedStatement.setString(5, reserva.getCpfFuncionario());
            preparedStatement.setInt(6, reserva.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Reserva cadastrada com sucesso!";
            } else {
                return "Falha ao cadastrar a reserva!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar a reserva: " + ex.getMessage();
        }
    }

    @Override
    public String atualizar(Reservas reserva, Connection conexao) {
        try {
            String sql = "UPDATE gerenciamento_de_reservas SET data_reserva = ?, data_retirada = ?, fk_hospede = ?, fk_funcionario = ?, status = ? WHERE id_reserva = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setObject(1, reserva.getDataReserva());
            preparedStatement.setObject(2, reserva.getDataRetirada());
            preparedStatement.setString(3, reserva.getCpfHospede());
            preparedStatement.setString(4, reserva.getCpfFuncionario());
            preparedStatement.setInt(5, reserva.getStatus());
            preparedStatement.setInt(6, reserva.getIdReserva());

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, int remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_reservas WHERE id_reserva = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Resreva removida do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o reserva do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir a reserva: " + ex.getMessage();
        }
    }

    @Override
    public void listar(Connection conexao) {
        String sql = "SELECT " +
            "r.id_reserva, r.data_reserva, r.data_retirada, r.fk_hospede, r.fk_funcionario, r.status, " +
            "q.num_quarto, t.descricao AS tipo_quarto " +
            "FROM gerenciamento_de_reservas r " +
            "INNER JOIN gerenciamento_de_quartos_da_reserva q ON r.id_reserva = q.fk_reserva " +
            "INNER JOIN gerenciamento_de_tipos_de_quarto t ON q.fk_tipo = t.id_tipo";
        
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int idReserva = resultSet.getInt("id_reserva");
                String dataReserva = resultSet.getString("data_reserva");
                String dataRetirada = resultSet.getString("data_retirada");
                String hospede = resultSet.getString("fk_hospede");
                String funcionario = resultSet.getString("fk_funcionario");
                int status = resultSet.getInt("status");
                int numQuarto = resultSet.getInt("num_quarto");
                String tipoQuarto = resultSet.getString("tipo_quarto");

                System.out.println("Reserva ID: " + idReserva + " | Data Reserva: " + dataReserva + 
                                    " | Data Retirada: " + dataRetirada + " | Hóspede: " + hospede + 
                                    " | Funcionário: " + funcionario + " | Status: " + status + 
                                    " | Número do Quarto: " + numQuarto + " | Tipo de Quarto: " + tipoQuarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
