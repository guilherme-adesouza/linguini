package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author vitor-olavo
 */
public class GeradorPrevisaoTempo {

    static File arquivo;
    static FileReader fileReader;
    static BufferedReader bufferedReader;
    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;

    public static void gerarArquivo(PrevisaoTempo previsao) {
        
        try {
            
            arquivo = new File("weather-api/previsao-"+previsao.getDia().getTime()+".txt");
            fileReader = new FileReader(arquivo);
            bufferedReader = new BufferedReader(fileReader);
            ArrayList texto = new ArrayList();
            while (bufferedReader.ready()) {
                texto.add(bufferedReader.readLine());
            }

            fileWriter = new FileWriter(arquivo);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < texto.size(); i++) {
                bufferedWriter.write(texto.get(i).toString());
                bufferedWriter.newLine();

            }

            bufferedWriter.write(previsao.toString());

            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException ex) {
            try {
                //Se nao exite o arquivo, cria-o
                arquivo.createNewFile();
                gerarArquivo(previsao);
            } catch (IOException ex1) {
                //Se não conseguir digitar fecha tudo
                //motivo: disco cheio
                System.exit(0);
            }
        } catch (IOException er) {
            System.exit(0);
        }
    }
}
