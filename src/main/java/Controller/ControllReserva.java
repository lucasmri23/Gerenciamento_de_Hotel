package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Model.Quarto;
import Model.Reservas;
import Model.DAO.FuncionarioDAO;
import Model.DAO.QuartoDAO;
import Model.DAO.ReservaDAO;
import Model.DB.ConexaoBanco;

public class ControllReserva {
public static void inserirReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID da Reserva: ");
        int idReserva = scanner.nextInt();
        System.out.print("Data de entrada: ");
        LocalDate dataEntrada = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Data de retirada: ");
        LocalDate dataRetirada = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("CPF do Hóspede: ");
        scanner.nextLine();
        String cpfHospede = scanner.nextLine();
        System.out.print("CPF do Funcionário: ");
        String cpfFuncionario = scanner.nextLine();
        System.out.print("iD (0 - INATIVO / 1 - ATIVO): ");
        int status = scanner.nextInt();
    
        Reservas novareserva = new Reservas(idReserva, dataEntrada, dataRetirada, cpfHospede, cpfFuncionario, status);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            ReservaDAO reservaDAO = new ReservaDAO();
            String retorno = reservaDAO.cadastrar(novareserva, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirReserva(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Id da reserva que deseja Remover do Banco de Dados:");
        int remov = scanner.nextInt();
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            ReservaDAO reservaDAO = new ReservaDAO();
            String retorno = reservaDAO.excluir(conexao,remov);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarReservas(){
            System.out.println("Lista de Reservas:");
            try {
                Connection conexao = ConexaoBanco.obterConexao();
    
                ReservaDAO reservaDAO = new ReservaDAO();
                reservaDAO.listar(conexao);
    
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
    }

    public static void atualizarReserva(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o id da reserva que deseja editar:");
        int idReserva = scanner.nextInt();
        
        System.out.print("Nova Data de entrada: ");
        LocalDate dataEntrada = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Nova Data de retirada: ");
        LocalDate dataRetirada = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Novo CPF do Hóspede: ");
        scanner.nextLine();
        String cpfHospede = scanner.nextLine();
        System.out.print("Novo CPF do Funcionário: ");
        String cpfFuncionario = scanner.nextLine();
        System.out.print("Novo iD (0 - INATIVO / 1 - ATIVO): ");
        int status = scanner.nextInt();

        Reservas reservasAtualizado = new Reservas(idReserva, dataEntrada, dataRetirada, cpfHospede, cpfFuncionario, status);


        try (Connection conexao = ConexaoBanco.obterConexao()) {
            ReservaDAO reservaDAO = new ReservaDAO();
            String retorno = reservaDAO.atualizar(reservasAtualizado, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

