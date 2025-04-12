package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllTipo;

public class MenuGerenciaTipo{
    static Scanner scanner = new Scanner(System.in);

    public int opcao = 0;
    
    public void menuTipo(){
        do{
            System.out.println("\n---- Gerenciamento de Tipos de Quarto ----");
            System.out.println("[1] - Inserir Dados do Tipo do Quarto");
            System.out.println("[2] - Atuaizar Dados do Tipo do Quarto");
            System.out.println("[3] - Excluir Dados do Tipo do Quarto");
            System.out.println("[4] - Exibir Dados do Tipo do Quarto");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        ControllTipo.inserirTipo();
                        break;
                    case 2: // Atualizar
                        ControllTipo.atualizarTipo();
                        break;
                    case 3: // Excluir
                        ControllTipo.excluirTipo();
                        break;
                    case 4: // Exibir
                        ControllTipo.listarTipos();
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
