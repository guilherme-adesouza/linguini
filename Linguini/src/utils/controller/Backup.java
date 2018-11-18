package utils.controller;

import dao.MensagemRetorno;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Date;
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
        String[] executeCmd = {"pg_restore","-d",dbName,"--username",dbUser,"-w",localArquivo};
        
        MensagemRetorno msg = executarComandoBanco(executeCmd);
        
        if(msg.isSucesso()) {
            msg.setMensagem("Restauração de backup executada com sucesso");      
        }
        return msg; 
    }
    
    public static MensagemRetorno aplicacao(String localArquivo){
        MensagemRetorno msg = new MensagemRetorno();
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
            msg.setMensagem("Backup executado com sucesso");      
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
}
