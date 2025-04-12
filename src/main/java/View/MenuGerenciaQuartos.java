package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllQuarto;

public class MenuGerenciaQuartos{
    static Scanner scanner = new Scanner(System.in);

    public int opcao = 0;
    
    public void menuQuarto(){

        do{
            System.out.println("\n---- Gerenciamento de Quartos ----");
            System.out.println("[1] - Inserir Dados do Quartos");
            System.out.println("[2] - Atuaizar Dados do Quartos");
            System.out.println("[3] - Excluir Dados do Quartos");
            System.out.println("[4] - Exibir Dados do Quartos");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        ControllQuarto.inserirQuarto();
                        break;
                    case 2: // Atualizar
                        ControllQuarto.atualizarQuarto();
                        break;
                    case 3: // Excluir
                        ControllQuarto.excluirQuarto();
                        break;
                    case 4: // Exibir
                        ControllQuarto.listarQuartos();
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
