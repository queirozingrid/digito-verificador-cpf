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

                    double acumuladoraDiv1 = 0; // acumuladora(guardar a soma) dígito verificador 1
                    double acumuladoraDiv2 = 0; // mesma coisa, só que para o dígito verificador 2
                    double numControle = 0;
                    for (i=1; i <= quantidadeDigitos; i++){
                        cpfDouble = (int)cpfDouble; // o excesso de casas decimais estava fazendo o cálculo dar errado, portanto,
                                                    // a cada início do loop, ele converte para inteiro
                        acumuladoraDiv1 = ((cpfDouble%10)*(i+1)) + acumuladoraDiv1;
                        acumuladoraDiv2 = ((cpfDouble%10)*(i+2)) + acumuladoraDiv2;
                        // --- abaixo, a explicação das duas linhas de código acima!! ---
                        // o cálculo do resto da divisão de cpfDouble por 10 deve-se ao fato
                        // de que este valor será o último número do cpf.
                        // por ex:
                        // o resto da divisão de 398136146 por 10, será 6
                        // -----------------------------------------------------------------
                        // a multiplicação por i+1 ou i+2 é porque os pesos variam entre 2 e 10,
                        // sendo que o i começa com 1, então acrescentamos +1 na primeira soma e
                        // +2 na segunda soma
                        // depois soma-se com o que já tem, por isso, o nome é acumuladora
                        cpfDouble = cpfDouble/10;
                        // a divisão inteira do cpf por 10 consiste em
                        // diminuir um dígito no final
                        // do número todo. Por ex: se era 1234,
                        // agora vai ser 123 e asim por diante
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
                    // abaixo, coloquei pra mostrar os dígitos para fins de confirmacão se o
                    // cálculo estava funcionando. Está!
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
