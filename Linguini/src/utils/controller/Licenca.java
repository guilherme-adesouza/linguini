package utils.controller;

import controller.UsuarioController;
import dao.MensagemRetorno;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import model.Usuario;

/**
 *
 * @author Vitor
 */
public class Licenca {

    public String linha;
    private Usuario user;
    private UsuarioController userCtr;
    String textoStringDecodificado;
    byte[] arrayBytesDecodificado;
    Date dataFinal;

    public boolean validaLicenca() {
        this.user = new Usuario();
        this.userCtr = new UsuarioController();
        Date data = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            BufferedReader br = new BufferedReader(new FileReader("Licenca.txt"));
            while (br.ready()) {
                linha = br.readLine();
                System.out.println(linha);
            }
            br.close();
        } catch (IOException ioe) {
            new GeradorLog(ioe);
            ioe.printStackTrace();
            return false;
        }
        
        criaLicenca();
        
        try {
            this.arrayBytesDecodificado = Base64.getDecoder().decode(linha);            
        } catch (Exception e) {
            new GeradorLog(e);
            System.err.print(e);
            return false;
        }
        this.textoStringDecodificado = new String(arrayBytesDecodificado);
        System.out.println("Texto decodificado " + textoStringDecodificado);
        String[] textoSeparado = textoStringDecodificado.split(" - ");

        try {
            dataFinal = sdf2.parse(textoSeparado[1]+" 23:59");
        } catch (ParseException ex) {
            new GeradorLog(ex);
            return false;
        }

        MensagemRetorno msg = this.userCtr.consultarPorID(1);
        this.user = (Usuario) msg.getObjeto();
        
        if (user.getNome().equals(textoSeparado[0]) && !data.after(this.dataFinal)) {
            System.out.println("ok");
            System.out.println(dataFinal + "f erro nd" + data);
            return true;
        } else {
            System.out.println("erro");
            criaLicenca();
            System.out.println(dataFinal + "f erro nd" + data);
            return false;
        }
    }

    public void criaLicenca() {
        String texto = "teste - 04/12/2018";
        String codificado = Base64.getEncoder().encodeToString(texto.getBytes());
        System.out.println("texto codificado = " + codificado);
    }

}