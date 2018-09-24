package dao;

import java.util.List;
import model.PermissaoBotao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

/**
 * @author guilherme-souza
 */
public class PermissaoBotaoDAO extends GenericoDAO<PermissaoBotao>{
    
    public MensagemRetorno atualizarPorTabela (int id, boolean visivel) {
        MensagemRetorno msg = this.consultarPorId(id, "PermissaoBotao");
        if(msg.isSucesso()){
            PermissaoBotao pb = (PermissaoBotao) msg.getObjeto();
            pb.setVisivel(visivel);
            msg = this.atualizar(pb);
            return msg;
        }
        else {
            return msg;
        }
    }
    
    public MensagemRetorno consultarPorGrupoTela(int idGrupo, int idTela, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("SELECT pb"
                                        + " FROM " + tabela+" pb INNER JOIN pb.botoesId AS btn INNER JOIN btn.telasId AS tela "
                                        + " WHERE pb.grupoId = :idParam AND tela.id = :idTela");

            query.setInteger("idParam", idGrupo);
            query.setInteger("idTela", idTela);

            retorno.setLista((List) query.list());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally {
            sessao.close();
        }
        return retorno;
    }
}
