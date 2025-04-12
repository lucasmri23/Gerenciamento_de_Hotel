package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllHospede;

public class MenuGerenciaHospede{

    static Scanner scanner = new Scanner(System.in);
    
    public int opcao = 0;

    public void menuHospede(){

        do{
            System.out.println("\n---- Gerenciamento de Hóspedes ----");
            System.out.println("[1] - Inserir Dados do Hóspede");
            System.out.println("[2] - Atuaizar Dados do Hóspede");
            System.out.println("[3] - Excluir Dados do Hóspede");
            System.out.println("[4] - Exibir Dados do Hóspede");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        ControllHospede.inserirHospede();
                        break;
                    case 2: // Atualizar
                        ControllHospede.atualizarHospede();
                        break;
                    case 3: // Excluir
                        ControllHospede.excluirHospede();
                        break;
                    case 4: // Exibir
                        ControllHospede.listarHospedes();
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
