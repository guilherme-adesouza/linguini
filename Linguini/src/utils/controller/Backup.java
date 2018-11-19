package utils.controller;

import dao.MensagemRetorno;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import main.Linguini;

/**
 * @author guilherme-souza
 */
public class Backup {
    
    public static void main(String[] args) throws URISyntaxException {
        CodeSource codeSource = Linguini.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        String jarDir = jarFile.getParentFile().getPath();
        Backup.bancoDeDados(jarDir);
    }
    
    public static MensagemRetorno restaurarAplicacao(String nomeArquivo){
        MensagemRetorno msg = new MensagemRetorno();
        return msg; 
    }
    
    //from stackoverflow (https://stackoverflow.com/questions/14924770/simple-backup-and-restore-for-mysql-database-from-java)
    public static MensagemRetorno restaurarBancoDeDados(String localArquivo){
        /*NOTE: Creating Database Constraints*/
        String dbName = "linguini";
        String dbUser = "postgres";
        
        /*NOTE: Used to create a cmd command*/
        String[] executeCmd = {"pg_restore","-1","-d",dbName,"--username",dbUser,"-w",localArquivo};
        
        MensagemRetorno msg = executarComandoBanco(executeCmd);
        
        if(msg.isSucesso()) {
            msg.setMensagem("Restauração de backup executada com sucesso");      
        }
        return msg; 
    }
    
    public static MensagemRetorno aplicacao(String localBackup){
        MensagemRetorno msg = new MensagemRetorno();
        try {
            CodeSource codeSource = Linguini.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            ArrayList<String> files = new ArrayList();
            if (jarFile.isDirectory()) {
                files.addAll(Arrays.asList(jarFile.list()));
                msg = ziparArquivos(localBackup, files);
            } else {
                msg.setSucesso(false);
                msg.setMensagem("Não foi possível realizar o backup da aplicação.");
            }
        } catch(URISyntaxException e) {
            e.printStackTrace();
            msg.setSucesso(false);
            msg.setMensagem("Erro ao realizar backup da aplicação. Erro:"+e.getMessage());
        }
        return msg; 
    }     
    
    //from stackoverflow (https://stackoverflow.com/questions/14924770/simple-backup-and-restore-for-mysql-database-from-java)
    public static MensagemRetorno bancoDeDados(String localBackup){
        /*NOTE: Creating Database Constraints*/
        String dbName = "linguini";
        String dbUser = "postgres";
        /*NOTE: Creating Path Constraints for backup saving*/
        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
        Date d = new Date();
        String fileName = d.getTime()+"-linguini-backup-bd.tar";
        String savePath = localBackup + "/" + fileName ;
        /*NOTE: Used to create a cmd command*/
        String[] executeCmd = {"pg_dump","--username",dbUser,"-w","--format","tar","--file",savePath,dbName};
        
        MensagemRetorno msg = executarComandoBanco(executeCmd);
        
        if(msg.isSucesso()) {
            msg = ziparArquivo(localBackup, savePath);
            if(msg.isSucesso()) {
                new File(savePath).delete();
                msg.setMensagem("Backup executado com sucesso");                      
            } else {
                msg.setMensagem("Falha ao comprimir backup. Tente novamente");
            }
        }
        return msg; 
    }
    
    private static MensagemRetorno executarComandoBanco(String[] executeCmd){
        MensagemRetorno msg = new MensagemRetorno();
        System.out.print("execute: ");
        for (String string : executeCmd) {
            System.out.print(string+" ");
        }
        System.out.println("");
        /*NOTE: Executing the command here*/
        ProcessBuilder runtimeProcess = new ProcessBuilder(executeCmd);
        runtimeProcess.environment().put("PGPASSWORD", "postgres");
        try {
            int processComplete = runtimeProcess.start().waitFor();
            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                msg.setSucesso(true);
                msg.setMensagem("Comando postgres executado com sucesso");
            } else {
                msg.setMensagem("Falha ao executar comando postgres");
            }
        } catch (IOException | InterruptedException ex) {
            msg.setMensagem("Falha ao executar comando postgres. "+ ex.getMessage());           
        }
        return msg;
    }
    
    private static MensagemRetorno ziparArquivo(String localArquivo, String arquivo) {
        ArrayList<String> arquivos = new ArrayList();
        arquivos.add(arquivo);
        return ziparArquivos(localArquivo, arquivos);
    }
    
    
    private static MensagemRetorno ziparArquivos(String localArquivo, ArrayList<String> arquivos) {
        MensagemRetorno msg = new MensagemRetorno();
        try {
            // let's create a ZIP file to write data
            FileOutputStream fos = new FileOutputStream(localArquivo+"/"+new Date().getTime() + "-linguini.zip");
            ZipOutputStream zipOS = new ZipOutputStream(fos);
            for(String arquivo : arquivos){
                writeToZipFile(arquivo, zipOS);                
            }
            zipOS.close();
            fos.close();
            msg.setSucesso(true);
        } catch (Exception e) {
            msg.setSucesso(false);
            msg.setMensagem("Ocorreu um erro ao comprimir o backup. Erro: "+ e.getMessage());
            e.printStackTrace();
        }
        return msg;
    }
    
    /**
     * Add a file into Zip archive in Java.
     * 
     * @param path
     * @param zipStream
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void writeToZipFile(String path, ZipOutputStream zipStream)
            throws FileNotFoundException, IOException {

        System.out.println("Writing file : '" + path + "' to zip file");

        File aFile = new File(path);
        FileInputStream fis = new FileInputStream(aFile);
        ZipEntry zipEntry = new ZipEntry(path.substring(path.lastIndexOf("/") + 1, path.length()));
        zipStream.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipStream.write(bytes, 0, length);
        }

        zipStream.closeEntry();
        fis.close();
    }
}
