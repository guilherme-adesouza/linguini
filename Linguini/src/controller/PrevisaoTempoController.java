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
    
    private final PrevisaoTempoAPI api;
    
    public PrevisaoTempoController() {
        this.api = new PrevisaoTempoAPI();
    }
    
    public MensagemRetorno consultar5Dias() throws IOException {
        MensagemRetorno msg = api.proximos5Dias();
        if(msg.isSucesso()) {
            msg.getLista().forEach((object) -> {
                //GeradorPrevisaoTempo.gerarArquivo((PrevisaoTempo) object);
            });
        }
        return msg;
    }
    
    public MensagemRetorno consultarAgora() throws IOException {
        MensagemRetorno msg = api.atual();
        if(msg.isSucesso()) {
            PrevisaoTempo p = (PrevisaoTempo) msg.getObjeto();
            //GeradorPrevisaoTempo.gerarArquivo(p);
        }
        return msg;
    }
}
