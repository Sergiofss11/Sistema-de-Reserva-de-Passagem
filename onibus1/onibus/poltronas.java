package onibus;

import java.util.Scanner;

public class poltronas {

    // Imprime status das poltronas e dá opção de escoher
    public static int SelecionarPoltrona(String onibus[]) {

        Scanner sc = new Scanner(System.in);

        int poltrona;

        // Imprime o ônibus com suas poltronas e status
        for (int i = 0; i < onibus.length; i++) {
            System.out.println("[ " + (i + 1) + " - " + onibus[i] + " ]");
        }

        do {
            try {

                System.out.print("Selecione a poltrona desejada: ");
                poltrona = sc.nextInt();
                if (poltrona > onibus.length || poltrona < 1) {
                    System.out.println("As poltronas são de 1 até " + onibus.length);
                }
            } catch (Exception e) {
                System.out.print("Digite o número correspondente a opção!");
                sc.nextLine();
                poltrona = onibus.length + 1;
            }
        } while (poltrona > onibus.length || poltrona < 1);

        // Retorna número da poltrona selecionada
        return poltrona;
    }

    public static void mostrar(String onibus[]) {

        // Imprime o ônibus com suas poltronas e status atualizados
        for (int i = 0; i < onibus.length; i++) {
            System.out.println("[ " + (i + 1) + " - " + onibus[i] + " ]");
        }
    }

    public static int[] SelecionarIntervalo(String onibus[]) {

        Scanner pr = new Scanner(System.in);
        // validacao teclado = new validacao();

        int intervalo[] = new int[2];

        // Imprime o ônibus com suas poltronas e status
        for (int i = 0; i < onibus.length; i++) {
            System.out.println("[ " + (i + 1) + " - " + onibus[i] + " ]");
        }

        // Verifica e seleciona a poltrona inicial
        do {
            try {
                System.out.print("Selecione a poltrona inicial: ");
                intervalo[0] = pr.nextInt();
                if (onibus.length <= intervalo[0] || intervalo[0] <= 0) {
                    System.out.print("A poltrona inicial deve ser maior que 0 e menor que " + onibus.length);
                }
            } catch (Exception e) {
                System.out.println("Digite o número correspondente a opção!");
                pr.nextLine();
                intervalo[0] = onibus.length + 1;
            }
        } while (onibus.length <= intervalo[0] || intervalo[0] <= 0);

        // Verifica e seleciona a poltrona final
        do {
            try {
                System.out.print("Selecione a poltrona final: ");
                intervalo[1] = pr.nextInt();
                if (onibus.length < intervalo[1] || intervalo[0] >= intervalo[1]) {
                    System.out.println(
                            "A poltrona final deve ser maior que " + intervalo[0] + " e menor que " + onibus.length);
                }
            } catch (Exception e) {
                System.out.print("Digite o número correspondente a opção!\n");
                pr.nextLine();
                intervalo[1] = onibus.length + 1;
            }
        } while (onibus.length < intervalo[1] || intervalo[0] >= intervalo[1]);

        // Retorna número da poltrona selecionada
        return intervalo;
    }

}