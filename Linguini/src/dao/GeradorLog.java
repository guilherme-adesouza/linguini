package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author vitor-olavo
 */
public class GeradorLog {

    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    public GeradorLog(String erros) {
        escreverLog(erros);
    }
    
    public GeradorLog(Exception e){
        escreverLog(e.getMessage()+"\n"+e.getStackTrace());
    }

    public void escreverLog(String erros) {
        
        GregorianCalendar gc = new GregorianCalendar();
        
        String today = gc.get(Calendar.YEAR)+"-"+gc.get(Calendar.MONTH)+"-"+gc.get(Calendar.DAY_OF_MONTH);
        try {
            
            arquivo = new File("log"+today+".txt");
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

            bufferedWriter.write("Data do erro: ");
            bufferedWriter.write(gc.getTime().toString());
            bufferedWriter.newLine();
            bufferedWriter.write("Mensagem de erro: ");
            bufferedWriter.write(erros);

            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException ex) {
            try {
                //Se nao exite o arquivo, cria-o
                arquivo.createNewFile();
                escreverLog(erros);
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
