package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Model.Funcionario;
import Model.Hospede;
import Model.DAO.FuncionarioDAO;
import Model.DAO.HospedeDAO;
import Model.DB.ConexaoBanco;

public class ControllHospede {
    public static void inserirHospede() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("CPF do Hóspede: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome do Hóspede: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone do Hóspede: ");
        String telefone = scanner.nextLine();
        System.out.print("Email do Hóspede: ");
        String email = scanner.nextLine();

        Hospede novohospede = new Hospede(cpf, nome, telefone, email);
        
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            HospedeDAO hospedeDAO = new HospedeDAO();
            String retorno = hospedeDAO.cadastrar(novohospede, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirHospede(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do Hospede que deseja Remover do Banco de Dados:");
        String remov = scanner.nextLine();
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            HospedeDAO hospedeDAO = new HospedeDAO();
            String retorno = hospedeDAO.excluir(conexao,remov);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarHospedes(){
        System.out.println("Lista de Hóspedes:");
        try {
            Connection conexao = ConexaoBanco.obterConexao();

            HospedeDAO hospedeDAO = new HospedeDAO();
            hospedeDAO.listar(conexao);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarHospede(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do Hospede que deseja editar os dados:");
        String cpf = scanner.nextLine();
        
        System.out.print("Novo Nome do Hospede: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Telefone do Hospede: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo Email do Hospede: ");
        String email = scanner.nextLine();

        Hospede hospedeAtualizado = new Hospede(cpf, nome, telefone, email);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            HospedeDAO hospedeDAO = new HospedeDAO();
            String retorno = hospedeDAO.atualizar(hospedeAtualizado, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}