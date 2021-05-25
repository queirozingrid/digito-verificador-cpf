# digito-verificador-cpf
Gerador dos dois dígitos verificadores do CPF, em Java.
Trabalhei conceitos de:
  - orientação a objetos;
  - comandos de condição e repetição;
  - manipulação de tipos de variáveis;
  - try except;
  - lógica de programação

Os cálculos foram baseados no conceito a seguir:

  Etapa 1: cálculo de DV1
    Soma 1: soma dos produtos de cada dígito por um peso de 2 a 10, na ordem inversa (do nono
      para o primeiro). Multiplique a “Soma 1” por 10 e calcule o resto da divisão do resultado por 11.
      Se der 10, DV1 é zero, caso contrário o DV1 é o próprio resto.
  
  Etapa 2: cálculo de DV2
    Soma 2: soma dos produtos de cada dígito por um peso de 3 a 11, também na ordem inversa.
      Adicione a “Soma 2” ao dobro do DV1, multiplique por 10 e calcule o resto da divisão do resultado
      por 11. Se der 10, DV2 é zero, caso contrário o DV2 é o próprio resto.
  
  Etapa 3: Multiplique DV1 por 10, some com DV2 e você tem o número de controle do CPF
