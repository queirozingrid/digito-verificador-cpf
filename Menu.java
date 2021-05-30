import java.util.*;
public class Menu {
    public void escolher(){

        Scanner input = new Scanner(System.in);
        int opcao = 0;
        
        System.out.println("\n********************* MENU *********************\n");
        System.out.println("[1]     Verificar o dígito verificador do CPF");
        System.out.println("[2]     Informações do desenvolvedor");
        System.out.println("[3]     SAIR");

        // recebe a opcao que o usuário escolher
        opcao = input.nextInt();
        // verificar dígito do cpf
        if(opcao==1){
            Cpf cpf = new Cpf();
            cpf.verificarDigito();
        }
        // informações sobre mim!!!
        if(opcao==2){
            System.out.println("********************* INFORMAÇÕES DO DESENVOLVEDOR *********************\n");
            System.out.println("    Aluna: Ingrid Queiroz Caetano       Matrícula: 1-2021119626");
            Menu menu = new Menu();
            menu.escolher();
        }
        // sair fora
        if(opcao==3){
            System.exit(0);
        }
        // se a pessoa digitar qualquer coisa diferente de 1, 2 ou 3, o menu será exibido novamente
        // para que ela possa refazer sua escolha sem que o programa desligue sozinho
        else{
            System.out.println("********************* !!! ERRO !!! *********************\n");
            System.out.println("            OPÇÃO INVÁLIDA, TENTE NOVAMENTE!!!");
            Menu menu = new Menu();
            menu.escolher();
        }
        input.close();        
    }
}
