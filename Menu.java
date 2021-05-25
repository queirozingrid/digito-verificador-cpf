import java.util.*;
public class Menu {
    public void escolher(){

        Scanner input = new Scanner(System.in);
        int opcao = 0;
        
        System.out.println("\n********************* MENU *********************\n");
        System.out.println("[1]     Verificar o dígito verificador do CPF");
        System.out.println("[2]     Informações do desenvolvedor");
        System.out.println("[3]     SAIR");

        opcao = input.nextInt();
        if(opcao==1){
            Cpf cpf = new Cpf();
            cpf.verificarDigito();
        }
        input.close();        
    }
}
