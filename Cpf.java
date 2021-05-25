import java.util.*;
import java.util.InputMismatchException;

public class Cpf {
    public int verificarDigito(){
        Scanner input = new Scanner(System.in);
        int i=1;
        int cont = 0;
        //boolean validadeCpf=false;
        //do{
            try {
                //validadeCpf=true;
                System.out.println("Digite os primeiros 9 números do seu CPF para obter os dígitos verificadores.\nOBS: DIGITE APENAS OS NÚMEROS, SEM ESPAÇOS NEM SÍMBOLOS\n");
    
                int cpf = input.nextInt(); // ler o cpf
                double cpfDouble = cpf; // a atividade pede que o usuário entre com um inteiro
                                        //porém, pra trabalhar com resto, precisa ser double
                                        //então, a conversão
                
                System.out.println("*************************************");
                while (cpf!=0){ // contar quantos dígitos tem o cpf
                    cpf = cpf/10;
                    cont++;
                }
                if(cont!=9){
                    System.out.println("O CPF deve conter 9 números. Nada mais, nada menos. Tente novamente.");
                    //validadeCpf = false;
                    //   menu.escolher();
                }
                else{
                    //validadeCpf = true;
                    // Número para fins de testes: 398136146
                    // Div1 precisa ser 6 e Div2 precisa ser 8
                    double acumuladoraDiv1 = 0;
                    double acumuladoraDiv2 = 0;
                    double numControle = 0;
                    while (i<10){
                        cpfDouble = (int)cpfDouble;
                        acumuladoraDiv1 = ((cpfDouble%10)*(i+1)) + acumuladoraDiv1;
                        acumuladoraDiv2 = ((cpfDouble%10)*(i+2)) + acumuladoraDiv2;
                        //System.out.println("atualização 2: " + acumuladoraDiv2 + "\n");
                        // ao tirar o resto da divisão, obtém-se o último dígito do CPF
                        // multiplica-se então por números a partir de 2 e 3
                        // (como i=1, acrescentei +1 e +2, para funcionar)
                        // o resultado, soma-se com o que "já tem"
                        // na variável acumuladora (que vai acumular)
                        cpfDouble = cpfDouble/10;
                        //cpf = cpf/10;
                        // a divisão inteira do cpf por 10 consiste em
                        // diminuir um dígito no final
                        // do número todo. Por ex: se era 1234,
                        // agora vai ser 123 e asim por diante
                        i++;
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
    
            } catch (InputMismatchException e) {
                System.out.println("DEVE CONTER APENAS NÚMEROS, TENTE NOVAMENTE!!!");
                 
                    try {
                        Thread.sleep(3000);
                        Cpf cpf2 = new Cpf();
                        cpf2.verificarDigito();
                        //Menu menu = new Menu();
                        //menu.escolher();
                        //menu.escolher();
                    } catch (Exception erro) {
                        //
                    }
                //validadeCpf = false;
                //validadeCpf = true; 
                // menu.escolher();
            }

       // } while(validadeCpf==false);
        Menu menu = new Menu();
        menu.escolher();
       
        input.close();
        return 1;
    }
}
