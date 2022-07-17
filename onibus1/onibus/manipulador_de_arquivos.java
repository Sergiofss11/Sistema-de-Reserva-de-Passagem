package onibus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class manipulador_de_arquivos {

    public static void escrever(String onibus[], String caminho) {
        try {
            FileOutputStream arquivo = new FileOutputStream(caminho);
                PrintWriter pr = new PrintWriter(arquivo);

                for (int i = 0; i < onibus.length; i++) {
                    pr.print(onibus[i] + "\n");
                }

                pr.close();
                arquivo.close();
            
            System.out.println("Arquivo gravado com Sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo");
        }
    }

    public static String[] leitor(String caminho) {
        String[] onibus = new String[10];
        try {
            FileInputStream arquivo = new FileInputStream(caminho);
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            String linha;

            int aux = 0;
            do {
                linha = br.readLine();

                if (linha != null) {
                    onibus[aux] = linha;
                    System.out.println("Lido = " + linha);
                }
                aux++;
            } while (linha != null);

            br.close();
            arquivo.close();
            System.out.println("Arquivo Lido Com Sucesso");

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }

        return onibus;

    }
}
