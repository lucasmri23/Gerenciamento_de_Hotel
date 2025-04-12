package Model.DB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriaTabela {
        public static void criarTabelas(Connection conexao) {
        try {
            DatabaseMetaData metaData = conexao.getMetaData();

            ResultSet resultSet = metaData.getTables(null, null, "gerenciamento_de_hospedes", null);
            
            if (!resultSet.next()) {
                criarGerenciamentoDeHospedes(conexao);
            } else {
                System.out.println("Tabela gerenciamento_de_hospedes já existe.");
            }
            
            resultSet = metaData.getTables(null, null, "gerenciamento_de_funcionarios", null);
            
            if (!resultSet.next()) {
                criarGerenciamentoDeFuncionarios(conexao);
            } else {
                System.out.println("Tabela gerenciamento_de_funcionarios já existe.");
            }
            
            resultSet = metaData.getTables(null, null, "gerenciamento_de_reservas", null);
            
            if (!resultSet.next()) {
                criarGerenciamentoDeReservas(conexao);
            } else {
                System.out.println("Tabela gerenciamento_de_reservas já existe.");
            }

            resultSet = metaData.getTables(null, null, "gerenciamento_de_tipos_de_quarto", null);
            
            if (!resultSet.next()) {
                criarGerenciamentoDeTipodesDeQuarto(conexao);
            } else {
                System.out.println("Tabela gerenciamento_de_tipos_de_quarto já existe.");
            }
            
            resultSet = metaData.getTables(null, null, "gerenciamento_de_quartos_da_reserva", null);
            
            if (!resultSet.next()) {
                criarGerenciamentoDeQuartosDaReserva(conexao);
            } else {
                System.out.println("Tabela gerenciamento_de_quartos_da_reserva já existe.");
            }
            
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema ao verificar ou criar as tabelas: " + ex.getMessage());
        }
    }
    

    private static void criarGerenciamentoDeHospedes(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate(
                "CREATE TABLE gerenciamento_de_hospedes(" +
                "cpf  varchar(13) NOT NULL  PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL," +
                "telefone VARCHAR(50) NOT NULL," +
                "email VARCHAR(50) NOT NULL" +
                ")");
        System.out.println("Tabela gerenciamento_de_hospedes criada com sucesso.");
    }
    
    private static void criarGerenciamentoDeFuncionarios(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate(
                "CREATE TABLE gerenciamento_de_funcionarios(" +
                "cpf varchar(13) PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL," +
                "cargo VARCHAR(50) NOT NULL" +
                ")");
        System.out.println("Tabela gerenciamento_de_funcionarios criada com sucesso.");
    }

    private static void criarGerenciamentoDeReservas(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate(
                "CREATE TABLE gerenciamento_de_reservas(" +
                "id_reserva INTEGER PRIMARY KEY," +
                "data_reserva DATE NOT NULL," +
                "data_retirada DATE NOT NULL," +
                "fk_hospede varchar(13) NOT NULL," +
                "fk_funcionario varchar(13) NOT NULL," +
                "status INTEGER NOT NULL,"+
                "FOREIGN KEY (fk_hospede) REFERENCES gerenciamento_de_hospedes (cpf)," +
                "FOREIGN KEY (fk_funcionario) REFERENCES gerenciamento_de_funcionarios(cpf)" +
                ")");
        System.out.println("Tabela gerenciamento_de_reservas criada com sucesso.");
    }

    private static void criarGerenciamentoDeTipodesDeQuarto(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate(
                "CREATE TABLE gerenciamento_de_tipos_de_quarto(" +
                "id_tipo INTEGER PRIMARY KEY," +
                "descricao VARCHAR(50) NOT NULL" +
                ")");
        System.out.println("Tabela gerenciamento_de_tipos_de_quarto criada com sucesso.");
    }

    private static void criarGerenciamentoDeQuartosDaReserva(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate(
                "CREATE TABLE gerenciamento_de_quartos_da_reserva(" +
                "num_quarto INTEGER PRIMARY KEY," +
                "fk_reserva INTEGER," +
                "fk_tipo INTEGER NOT NULL," +
                "FOREIGN KEY (fk_reserva) REFERENCES gerenciamento_de_reservas(id_reserva)," +
                "FOREIGN KEY (fk_tipo) REFERENCES gerenciamento_de_tipos_de_quarto(id_tipo)" +
                ")");
        System.out.println("Tabela gerenciamento_de_quartos_da_reserva criada com sucesso.");
    }

}
