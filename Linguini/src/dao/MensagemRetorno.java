package dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guilherme-souza
 */
public class MensagemRetorno {

    private String mensagem;
    private boolean sucesso;
    private List<Object> lista;
    private Object objeto;
    
    public MensagemRetorno(){
        this.mensagem = "";
        this.sucesso = false;
        this.lista = new ArrayList<>();
        this.objeto = null;
    }
    
    public MensagemRetorno(boolean sucesso){
        this.sucesso = sucesso;
        this.mensagem = "";
        this.lista = new ArrayList<>();
        this.objeto = null;
    }
    
    public MensagemRetorno(String mensagem, boolean sucesso){
        this.mensagem = mensagem;
        this.sucesso = sucesso;
        this.lista = new ArrayList<>();
        this.objeto = null;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
    

    @Override
    public String toString() {
        String msg = "";
        if(!this.sucesso) {
            msg = "Erro! \n"+
                  "Mensagem: "+this.mensagem;  
        }
        else {
            msg = "Sucesso! \n"+
                  "Lista: "+this.lista+"\n"+
                  "Objeto: "+this.objeto;
        }
        return msg;
    }
}
