package dao;

import java.util.Date;
import java.util.List;
import model.Auditoria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 * @author guilherme-souza
 */
public class AuditoriaDAO extends GenericoDAO<Auditoria>{
    
    public MensagemRetorno consultarNoIntervalo(Date inicio, Date fim){
        MensagemRetorno retorno = new MensagemRetorno();
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM Auditoria a "
                                           + "WHERE a.action_tstamp BETWEEN :dataInicio AND :dataFim");

            query.setDate("dataInicio", inicio);
            query.setDate("dataFim", fim);
            
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
    
    public MensagemRetorno excluirNoIntervalo(Date inicio, Date fim){
        MensagemRetorno retorno = new MensagemRetorno();
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            Query query = sessao.createQuery("DELETE FROM Auditoria a "
                                           + "WHERE a.action_tstamp BETWEEN :dataInicio AND :dataFim");

            query.setDate("dataInicio", inicio);
            query.setDate("dataFim", fim).executeUpdate();
            t.commit();
            
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally {
            sessao.close();
        }        
        return retorno;
    }
    
    public MensagemRetorno quantidadePorIntervalo(Date inicio, Date fim){
        MensagemRetorno retorno = new MensagemRetorno();
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Query query = sessao.createQuery("SELECT count(*) FROM Auditoria a  "
                                           + "WHERE a.action_tstamp BETWEEN :dataInicio AND :dataFim");

            query.setDate("dataInicio", inicio);
            query.setDate("dataFim", fim);

            retorno.setObjeto(query.uniqueResult());
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
