package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Model.Hospede;
import Model.Quarto;
import Model.DAO.FuncionarioDAO;
import Model.DAO.HospedeDAO;
import Model.DAO.QuartoDAO;
import Model.DB.ConexaoBanco;

public class ControllQuarto{
    public static void inserirQuarto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero do Quarto: ");
        int id = scanner.nextInt();
        System.out.print("ID da Reserva: ");
        int idReserva = scanner.nextInt();
        System.out.print("ID do Tipo do Quarto: ");
        int idTipo = scanner.nextInt();

        Quarto novoquarto = new Quarto(id, idReserva, idTipo);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            QuartoDAO quartoDAO = new QuartoDAO();
            String retorno = quartoDAO.cadastrar(novoquarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirQuarto(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número do quarto que deseja Remover do Banco de Dados:");
        long remov = scanner.nextInt();
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            QuartoDAO quartoDAO = new QuartoDAO();
            String retorno = quartoDAO.excluir(conexao,remov);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarQuartos(){
        System.out.println("Lista de Quartos:");
        try {
            Connection conexao = ConexaoBanco.obterConexao();

            QuartoDAO quartoDAO = new QuartoDAO();
            quartoDAO.listar(conexao);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void atualizarQuarto(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Número do quarto que deseja editar:");
        int id = scanner.nextInt();
        
        System.out.print("Novo id da reserva: ");
        int idReserva = scanner.nextInt();
        System.out.print("Novo id do tipo do quarto: ");
        int idTipo = scanner.nextInt();

        Quarto quartoAtualizado = new Quarto(id, idReserva, idTipo);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            QuartoDAO quartoDAO = new QuartoDAO();
            String retorno = quartoDAO.atualizar(quartoAtualizado, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
