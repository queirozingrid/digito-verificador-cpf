import java.util.*;
import java.lang.NumberFormatException;

public class Cpf {
    public int verificarDigito(){
        Scanner input = new Scanner(System.in);
        int i=1;
            try {
                System.out.println("Digite os primeiros 9 números do seu CPF para obter os dígitos verificadores.\nOBS: DIGITE APENAS OS NÚMEROS, SEM ESPAÇOS NEM SÍMBOLOS\n");
                String cpfEmTexto = input.nextLine(); // ler o cpf
                int cpf = Integer.parseInt(cpfEmTexto);
                
                double cpfDouble = cpf; // para trabalhar com resto, precisa ser double
                
                int quantidadeDigitos = cpfEmTexto.length();
                if(quantidadeDigitos>9 || quantidadeDigitos<8){ // verifica se a quantidade de dígitos é diferente de 9
                    System.out.println("O CPF deve conter 9 números. Nada mais, nada menos. Tente novamente.\n");
                    try {
                        Thread.sleep(3000);
                        Cpf cpf2 = new Cpf();
                        cpf2.verificarDigito();
                        
                    } catch (Exception erro) {
                        //
                    }

                }
                else{
                    // Número para fins de testes: 398136146
                    // Div1 precisa ser 6 e Div2 precisa ser 8
                    // Div = dígito verificador

                    double acumuladoraDiv1 = 0; //
                    double acumuladoraDiv2 = 0; //
                    double numControle = 0;
                    for (i=1; i <= quantidadeDigitos; i++){
                        cpfDouble = (int)cpfDouble;

                        acumuladoraDiv1 = ((cpfDouble%10)*(i+1)) + acumuladoraDiv1;
                        acumuladoraDiv2 = ((cpfDouble%10)*(i+2)) + acumuladoraDiv2;

                        cpfDouble = cpfDouble/10;

                    }
                    double div1 = ((acumuladoraDiv1*10) %11);
                    double div2 = ((((acumuladoraDiv2) + div1*2) * 10) % 11);
                    
                    if(div1==10){
                        div1 = 0;
                    }

                    if(div2==10){
                        div2 = 0;
                    }
    
                    numControle = ((div1*10) + div2);

                    System.out.println("dig 1: " + div1);
                    System.out.println("dig 2: " + div2);
                    System.out.println("Número de controle do CPF: " + numControle);
                }
    
            } catch (NumberFormatException e) {
                System.out.println("DEVE CONTER APENAS NÚMEROS, TENTE NOVAMENTE!!!\n");
                 
                    try {
                        Thread.sleep(3000);
                        Cpf cpf2 = new Cpf();
                        cpf2.verificarDigito();
                        
                    } catch (Exception erro) {
                        //
                    }
                    // volta para que o usuário entre novamente com o número do CPF
            }
            Menu menu = new Menu();
            menu.escolher();
        
            input.close();
            return 1;
    }
}
