package View;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    static Scanner scanner = new Scanner(System.in);

    public int opcao = 0;
    
    MenuGerenciaHospede menuHospede = new MenuGerenciaHospede();
    MenuGerenciaFuncionario menuFuncionario = new MenuGerenciaFuncionario();
    MenuGerenciaQuartos menuQuartos = new MenuGerenciaQuartos();
    MenuGerenciaReserva menuReserva = new MenuGerenciaReserva();
    MenuGerenciaTipo menuTipo = new MenuGerenciaTipo();

    public void Menu(){

        do{
            System.out.println("\n---- Gerenciamento do Hotel ----");
            System.out.println("[1] - Gerenciamento de Hóspedes");
            System.out.println("[2] - Gerenciamento de Funcionários");
            System.out.println("[3] - Gerenciamento de Tipos de Quarto");
            System.out.println("[4] - Gerenciamento de Reservas");
            System.out.println("[5] - Gerenciamento de Quartos da Reserva");
            System.out.println("[0] - Sair do Programa");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Gerenciamento de Hóspedes
                        menuHospede.menuHospede();
                        break;
                    case 2: // Gerenciamento de Funcionários
                        menuFuncionario.menuFuncionario();
                        break;
                    case 4: // Gerenciamento de Reservas
                        menuReserva.menuReserva();
                        break;
                    case 5: // Gerenciamento de Quarto
                        menuQuartos.menuQuarto();
                        break;  
                    case 3: // Gerenciamento de Tipo do Quarto
                        menuTipo.menuTipo();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("NÚMERO INVÁLIDO. INSIRA UM VALOR ENTRE 0 E 5");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("ERRO: DADO INVÁLIDO");
            }
            
        }while(opcao != 0);

    }


}
