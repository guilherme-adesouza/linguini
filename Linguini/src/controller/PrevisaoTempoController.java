package controller;

import api.GeradorPrevisaoTempo;
import api.PrevisaoTempo;
import api.PrevisaoTempoAPI;
import dao.MensagemRetorno;
import java.io.IOException;

/**
 * @author guilherme-souza
 */
public class PrevisaoTempoController {
    
    private PrevisaoTempoAPI api;
    
    public static void main(String[] args) throws IOException {
        PrevisaoTempoController c = new PrevisaoTempoController();
        c.consultarAgora();
    }
    
    public PrevisaoTempoController() {
        this.api = new PrevisaoTempoAPI();
    }
    
    public MensagemRetorno consultar5Dias() throws IOException {
        MensagemRetorno msg = api.proximos5Dias();
        if(msg.isSucesso()) {
            for (Object object : msg.getLista()) {
                PrevisaoTempo p = (PrevisaoTempo) object;
                GeradorPrevisaoTempo.gerarArquivo(p);
            }
        }
        return msg;
    }
    
    public MensagemRetorno consultarAgora() throws IOException {
        MensagemRetorno msg = api.atual();
        if(msg.isSucesso()) {
            PrevisaoTempo p = (PrevisaoTempo) msg.getObjeto();
            GeradorPrevisaoTempo.gerarArquivo(p);
        }
        return msg;
    }
}
