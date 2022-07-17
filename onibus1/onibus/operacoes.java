package onibus;

public class operacoes {
    // Realiza a compra
    public static String[] comprar(String onibus[], int poltrona) {
        // Primeiro verifica se é diferente de Disponível, se for igual pode vender
        String teste = new String(onibus[poltrona - 1]);

        if (!onibus[poltrona - 1].equals("Disponivel")) {
            System.out.println("\nERRO - Escolha uma poltrona Disponivel !!\n");
            System.out.println("Disponivel" == teste.intern());
        } else {
            onibus[poltrona - 1] = "Vendido";
            poltronas.mostrar(onibus);
        }

        // Retorna o array atualizado
        return onibus;
    }

    // Realiza a reserva
    public static String[] reservar(String onibus[], int poltrona) {
        // Primeiro verifica se é diferente de Disponível, se for igual pode reservar
        if (!onibus[poltrona - 1].equals("Disponivel")) {
            System.out.println("\nERRO - Escolha uma poltrona Disponivel !!\n");
        } else {
            onibus[poltrona - 1] = "Reservado";
            poltronas.mostrar(onibus);
        }

        // Retorna o array atualizado
        return onibus;
    }

    // Cancela a reserva ou venda
    public static String[] cancelar(String onibus[], int poltrona, String nomeOnibus) {

        // Primeiro verifica se é igual à disposível, se for diferente pode cancelar
        if (onibus[poltrona - 1].equals("Disponivel")) {
            System.out.println("\nERRO - Escolha uma poltrona Reservada ou Vendida !!\n");
        } else {
            onibus[poltrona - 1] = "Disponível";
            poltronas.mostrar(onibus);

            // Adiciona (soma um) para o valor de cancelamentos para o relatório
            if (nomeOnibus == "Hogwarts") {
                reservasCanceladas.onb1++;
            } else if (nomeOnibus == "Quintos") {
                reservasCanceladas.onb2++;
            }

        }

        // Retorna o array atualizado
        return onibus;
    }

    public static String[] reservarIntervalo(String onibus[], int intervalo[]) {

        // Primeiro verifica se é diferente de Disponível, se for igual pode reservar
        for (int index = intervalo[0]; index <= intervalo[1]; index++) {
            if (!onibus[index - 1].equals("Disponivel")) {
                System.out.print("\nERRO - Escolha uma poltrona Disponivel!! Poltrona " + index + " "
                        + onibus[index - 1] + "\n");
            } else {
                onibus[index - 1] = "Reservado";
            }
        }

        poltronas.mostrar(onibus);
        // Retorna o array atualizado
        return onibus;
    }

    // Gera o relatório
    public static void relatorio(String onibus1[], String onibus2[]) {
        int d1 = 0, d2 = 0, v1 = 0, v2 = 0, r1 = 0, r2 = 0;

        // Verifica e adiciona valor à opção no ônibus 1
        for (int i = 0; i < onibus1.length; i++) {
            if (onibus1[i].equals("Disponivel")) {
                d1++;
            } else if (onibus1[i].equals("Reservado")) {
                r1++;
            } else if (onibus1[i].equals("Vendido")) {
                v1++;
            }
        }

        // Verifica e adiciona valor à opção no ônibus 2
        for (int i = 0; i < onibus2.length; i++) {
            if (onibus2[i].equals("Disponivel")) {
                d2++;
            } else if (onibus2[i].equals("Reservado")) {
                r2++;
            } else if (onibus2[i].equals("Vendido")) {
                v2++;
            }
        }

        // Printa o relatório
        System.out.println("--------------------------RELATORIO----------------------------\n"
                + "                                                               \n"
                + "------------------------LINHA HOGWARTS-------------------------\n"
                + "                                                               \n"
                + "POLTRONAS DISPONIVEIS -> " + d1 + "                                \n"
                + "POLTRONAS VENDIDAS    -> " + v1 + "                                \n"
                + "POLTRONAS RESERVADAS  -> " + r1 + "                                \n"
                + "RESERVAS CANCELADAS   -> " + reservasCanceladas.onb1 + "           \n"
                + "                                                               \n"
                + "------------------------LINHA QUINTOS--------------------------\n"
                + "                                                               \n"
                + "POLTRONAS DISPONIVEIS -> " + d2 + "                                \n"
                + "POLTRONAS VENDIDAS    -> " + v2 + "                                \n"
                + "POLTRONAS RESERVADAS  -> " + r2 + "                                \n"
                + "RESERVAS CANCELADAS   -> " + reservasCanceladas.onb2 + "           \n"
                + "                                                               \n"
                + "---------------------------------------------------------------\n");
    }

}
