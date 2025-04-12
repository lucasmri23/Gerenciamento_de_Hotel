package Controller;

import Model.Reservas;
import Model.TipoQuarto;
import Model.DAO.FuncionarioDAO;
import Model.DAO.ReservaDAO;
import Model.DAO.TipoQuartoDAO;
import Model.DB.ConexaoBanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ControllTipo {
    public static void inserirTipo(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID do Tipo do Quarto: ");
        int id = scanner.nextInt();
        System.out.print("Descrição: ");
        scanner.nextLine();
        String descricao = scanner.nextLine();
        
        TipoQuarto novotipoQuarto = new TipoQuarto(id, descricao);
    
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAO();
            String retorno = tipoQuartoDAO.cadastrar(novotipoQuarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void excluirTipo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Id do tipo de quarto que deseja Remover do Banco de Dados:");
        int remov = scanner.nextInt();
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAO();
            String retorno = tipoQuartoDAO.excluir(conexao,remov);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarTipos(){
        System.out.println("Lista de Tipos de quarto:");
        try {
            Connection conexao = ConexaoBanco.obterConexao();

            TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAO();
            tipoQuartoDAO.listar(conexao);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarTipo(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Tipo do Quarto que deseja editar: ");
        int id = scanner.nextInt();

        System.out.print("Nova Descrição: ");
        scanner.nextLine();
        String descricao = scanner.nextLine();
        
        TipoQuarto tipoQuartoAtualizado = new TipoQuarto(id, descricao);


        try (Connection conexao = ConexaoBanco.obterConexao()) {
            TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAO();
            String retorno = tipoQuartoDAO.atualizar(tipoQuartoAtualizado, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
