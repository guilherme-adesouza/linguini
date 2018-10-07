package controller;

import dao.AuditoriaDAO;
import dao.MensagemRetorno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import model.Auditoria;
import model.AuditoriaArquivada;

/**
 * @author guilherme-souza
 */
public class AuditoriaController implements Controller<Auditoria>{

    private AuditoriaDAO auditoriaDAO;
    private String tabela="Auditoria";
    
    public AuditoriaController(){
        this.auditoriaDAO = new AuditoriaDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Auditoria objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno excluir(Auditoria objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public AuditoriaArquivada converterEmAuditoriaArquivada(Auditoria auditoria){
        AuditoriaArquivada auditoriaArquivada = new AuditoriaArquivada();
        auditoriaArquivada.setAction(auditoria.getAction());
        auditoriaArquivada.setAction_tstamp(auditoria.getAction_tstamp());
        auditoriaArquivada.setNew_data(auditoria.getNew_data());
        auditoriaArquivada.setOriginal_data(auditoria.getOriginal_data());
        auditoriaArquivada.setSchema_name(auditoria.getSchema_name());
        auditoriaArquivada.setTable_name(auditoria.getTable_name());
        auditoriaArquivada.setUser_name(auditoria.getUser_name());
        return auditoriaArquivada;
    }
    
    public MensagemRetorno arquivarNoIntervalo(Date inicio, Date fim){
        MensagemRetorno m = auditoriaDAO.consultarNoIntervalo(inicio, fim);
        if(m.isSucesso()){
            List<AuditoriaArquivada> arquivados = new ArrayList<>();
            for(Object o : m.getLista()){
                AuditoriaArquivada a = converterEmAuditoriaArquivada((Auditoria) o);
                arquivados.add(a);
            }
            m = new AuditoriaArquivadaController().arquivar(arquivados);
            if(m.isSucesso()){
                m = auditoriaDAO.excluirNoIntervalo(inicio, fim);
            }
        }
        return m;
    }
    
    public Integer quantidadePorIntervalo(Date inicio, Date fim) {
        return new Integer(auditoriaDAO.quantidadePorIntervalo(inicio, fim).getObjeto().toString());
    }    
}
