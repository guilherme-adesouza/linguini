package controller;

import dao.AuditoriaArquivadaDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.AuditoriaArquivada;

/**
 * @author guilherme-souza
 */
public class AuditoriaArquivadaController implements Controller<AuditoriaArquivada> {

    private AuditoriaArquivadaDAO auditoriaArquivadaDAO;
    private String tabela="AuditoriaArquivada";
    
    public AuditoriaArquivadaController(){
        this.auditoriaArquivadaDAO = new AuditoriaArquivadaDAO();
    }
    
    @Override
    public MensagemRetorno salvar(AuditoriaArquivada auditoria) {
        return this.auditoriaArquivadaDAO.salvar(auditoria);
    }

    @Override
    public MensagemRetorno excluir(AuditoriaArquivada objeto) {
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
    
    public MensagemRetorno arquivar(List<AuditoriaArquivada> registros){
        MensagemRetorno m = new MensagemRetorno();
        for (AuditoriaArquivada registro : registros) {
            m = this.salvar(registro);
            if(!m.isSucesso()) {
                break;
            }
        }
        return m;
    }
}
