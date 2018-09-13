package dao;

import model.PermissaoBotao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

/**
 * @author guilherme-souza
 */
public class PermissaoBotaoDAO extends GenericoDAO<PermissaoBotao>{
    
    
    public MensagemRetorno consultarPorGrupo(int idGrupo, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela+" WHERE grupo_id = :idParam");

            query.setInteger("idParam", idGrupo);
            
            retorno.setObjeto((Object) query.uniqueResult());
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
