
import javax.lang.model.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Leitura {

    public static void main(String[] args) {
        Lista listaWords = new Lista();
        String linhas[] = new String[100000];
        int numLinhas = 1;
        Integer numPaginas = 1;
        StringBuffer stopWords = new StringBuffer();


        Path path1 = Paths.get("stopwords.txt");// java.txt
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                stopWords.append(line + ",");
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }


        Path path2 = Paths.get("fiveweeksinaballoon.txt");// java.txt
        try (BufferedReader reader = Files.newBufferedReader(path2, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                linhas[numLinhas] = line;

                numLinhas++;
                if (numLinhas % 40 == 0) {
                    numPaginas++;
                }
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

        int n = 0;
        for (int i = 1; i <= numPaginas; i++) {
            System.out.println("--------------------- Pagina " + i + " ---------------------");
            for (int j = 0; j < 40 && n < numLinhas; j++, n++) {
                System.out.println(linhas[n]);
            }
        }

        for (int i = 1; i < numLinhas; i++) {
            System.out.println("\nPalavras da linha " + i + ": ");
            linhas[i] = linhas[i].replaceAll("\\t", " "); // substitui tab por espaco em branco
            linhas[i] = linhas[i].replaceAll(",", ""); // para remover vírgulas
            String[] tokens = linhas[i].split(" "); // divide a string pelo espaco em branco
            for (String s : tokens) {
                s = s.toLowerCase();

                if (stopWords.toString().contains(s)) {
                    continue;
                }
                System.out.println("->" + s);
                listaWords.add(s, String.valueOf(Math.floor(i / 40) + 1));

            }
        }
    }
}
