package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllReserva;

public class MenuGerenciaReserva{

    static Scanner scanner = new Scanner(System.in);
    
    public int opcao = 0;
    
    public void menuReserva(){

        do{
            System.out.println("\n---- Gerenciamento de Reserva ----");
            System.out.println("[1] - Inserir Dados da Reserva");
            System.out.println("[2] - Atuaizar Dados da Reserva");
            System.out.println("[3] - Excluir Dados da Reserva");
            System.out.println("[4] - Exibir Dados da Reserva");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir             
                        ControllReserva.inserirReserva();
                        break;
                    case 2: // Atualizar
                        ControllReserva.atualizarReserva();
                        break;
                    case 3: // Excluir
                        ControllReserva.excluirReserva();
                        break;
                    case 4: // Exibir
                        ControllReserva.listarReservas();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("NÚMERO INVÁLIDO. INSIRA UM VALOR ENTRE 0 E 4");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("ERRO: DADO INVÁLIDO");
                return;
            }
            
        }while(opcao != 0);

    }
}
