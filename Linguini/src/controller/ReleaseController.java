package controller;

import dao.MensagemRetorno;
import dao.ReleaseDAO;
import java.io.File;
import java.util.List;
import javax.swing.JTable;
import model.Release;

/**
 * @author guilherme-souza
 */
public class ReleaseController implements Controller<Release> {

    ReleaseDAO releaseDAO = new ReleaseDAO();
    
    public ReleaseController(){
        this.releaseDAO = new ReleaseDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Release release) {
        return this.releaseDAO.salvar(release);
    }

    @Override
    public MensagemRetorno excluir(Release release) {
        return this.releaseDAO.excluir(release);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.releaseDAO.excluir(id, "Release");
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        //
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.releaseDAO.consultarTodos("Release");
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.releaseDAO.consultarPorId(id, "Release");
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MensagemRetorno gerarReleasePorArquivo(File arquivoRelease){
        MensagemRetorno msg = new MensagemRetorno();
        return msg;
    }
}
