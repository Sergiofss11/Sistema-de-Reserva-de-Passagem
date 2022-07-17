package onibus;

import java.util.InputMismatchException;
import java.util.Scanner;

class reservasCanceladas {
    static int onb1 = 0, onb2 = 0;
}

public class projeto01 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int linha = 0;
        int opcao = 0;
        int poltrona;
        int conjunto = 0;
        int resp = 0;
        int intervalo[] = new int[2];
        String hogwarts[] = new String[10];
        String quinto[] = new String[10];
        String onb1 = "onibus/onibus1.txt";
        String onb2 = "onibus/onibus2.txt";

        hogwarts = manipulador_de_arquivos.leitor(onb1);
        quinto = manipulador_de_arquivos.leitor(onb2);

        System.out.println("\n\n-----------------SISTEMA DE ONIBUS DO BIOPARK-------------");
        do {
            // Seleciona a operação
            do {
                try {
                    System.out.print(
                            "\n1 = COMPRAR\n2 = RESERVAR\n3 = CANCELAR RESERVA\n4 = RELATÓRIO\n5 = VISUALIZAR ONIBUS\n\nSELECIONE UMA OPERAÇÃO: ");
                    opcao = in.nextInt();

                } catch (InputMismatchException e) {
                    System.out.print("Informe o número correspondente a opção!");
                    in.nextLine();
                }
            } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5);

            if (opcao == 4) {
                operacoes.relatorio(hogwarts, quinto);
            }
            // Seleciona a linha
            do {
                try {
                    System.out.print("\n1 = Hogwarts\n2 = Quinto dos Infernos\n\nSELECIONE UM DESTINO: ");
                    linha = in.nextInt();
                    if (linha != 1 && linha != 2) {
                        System.out.println("Escolha uma opção válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Informe o número correspondente a opção!");
                    in.nextLine();
                }
            } while (linha != 1 && linha != 2);

            // Confirma a Opção
            if (linha == 1) {
                System.out.println("\nVocê escolheu ir para Hogwarts.");
                if (opcao == 1) {
                    poltrona = poltronas.SelecionarPoltrona(hogwarts);
                    hogwarts = operacoes.comprar(hogwarts, poltrona);

                } else if (opcao == 2) {
                    do {
                        try {
                            System.out.println("1 = Reservar uma poltrona\n2 = Reservar um conjunto de poltronas");
                            conjunto = in.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Informe o número correspondente a opção!");
                            in.nextLine();
                        }
                    } while (conjunto != 1 && conjunto != 2);

                    if (conjunto == 2) {
                        intervalo = poltronas.SelecionarIntervalo(hogwarts);
                        hogwarts = operacoes.reservarIntervalo(hogwarts, intervalo);
                    } else {
                        poltrona = poltronas.SelecionarPoltrona(hogwarts);
                        hogwarts = operacoes.reservar(hogwarts, poltrona);
                    }

                } else if (opcao == 3) {
                    poltrona = poltronas.SelecionarPoltrona(hogwarts);
                    hogwarts = operacoes.cancelar(hogwarts, poltrona, "Hogwarts");

                } else if (opcao == 5) {
                    poltronas.mostrar(hogwarts);
                }
            } else if (linha == 2) {
                System.out.println("\nVocê escolheu ir para o Quinto dos Infernos.");

                if (opcao == 1) {
                    poltrona = poltronas.SelecionarPoltrona(quinto);
                    quinto = operacoes.comprar(quinto, poltrona);

                } else if (opcao == 2) {
                    do {
                        try {
                            System.out.println("1 = Reservar uma poltrona\n2 = Reservar um conjunto de poltronas");
                            conjunto = in.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Informe o número correspondente a opção!");
                            in.nextLine();
                        }
                    } while (conjunto != 1 && conjunto != 2);

                    if (conjunto == 2) {
                        intervalo = poltronas.SelecionarIntervalo(quinto);
                        quinto = operacoes.reservarIntervalo(quinto, intervalo);
                    } else {
                        poltrona = poltronas.SelecionarPoltrona(quinto);
                        quinto = operacoes.reservar(quinto, poltrona);
                    }

                } else if (opcao == 3) {
                    poltrona = poltronas.SelecionarPoltrona(quinto);
                    quinto = operacoes.cancelar(quinto, poltrona, "Quinto");

                } else if (opcao == 5) {
                    poltronas.mostrar(quinto);
                }
            }

            do {

                try {
                    System.out
                            .print("\n1 - REALIZAR OUTRA OPERAÇÃO \n2 - FINALIZAR O SISTEMA\nSELECIONE UMA OPERAÇÃO: ");
                    resp = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Informe o número correspondente a opção!");
                    in.nextLine();
                }
            } while (resp != 1 && resp != 2);
        } while (resp != 2);

        manipulador_de_arquivos.escrever(hogwarts, onb1);
        manipulador_de_arquivos.escrever(quinto, onb2);

    }
}
