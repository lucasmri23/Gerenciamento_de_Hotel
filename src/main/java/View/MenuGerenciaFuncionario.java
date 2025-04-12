package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllFuncionario;


public class MenuGerenciaFuncionario{
    static Scanner scanner = new Scanner(System.in);
    
    public int opcao = 0;

    public void menuFuncionario(){

        do{
            System.out.println("\n---- Gerenciamento de Funcionário ----");
            System.out.println("[1] - Inserir Dados do Funcionário");
            System.out.println("[2] - Atuaizar Dados do Funcionário");
            System.out.println("[3] - Excluir Dados do Funcionário");
            System.out.println("[4] - Exibir Dados dos Funcionários");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir 
                        ControllFuncionario.inserirFuncionario();
                        break;
                    case 2: // Atualizar
                        ControllFuncionario.atualizarFuncionario();
                        break;
                    case 3: // Excluir
                        ControllFuncionario.excluirFuncionario();
                        break;
                    case 4: // Exibir
                        ControllFuncionario.listarFuncionarios();
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
