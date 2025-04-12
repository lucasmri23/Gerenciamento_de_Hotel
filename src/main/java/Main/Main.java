package Main;
import View.*;
import Model.*;
import Model.DB.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        Connection conexao = null;
        try {
        conexao = ConexaoBanco.obterConexao(); // conexão com o banco
        if (conexao != null) {
            System.out.println("Conexão bem-sucedida!");
            CriaTabela.criarTabelas(conexao); // cria as tabelas
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    } catch (SQLException ex) {
        System.out.println("Ocorreu um problema: " + ex.getMessage());
    } finally {
        ConexaoBanco.fecharConexao(); // fecha conexão
    }   
        CriaTabela criaTabela = new CriaTabela();
        
        menuPrincipal.Menu();
    }

}
