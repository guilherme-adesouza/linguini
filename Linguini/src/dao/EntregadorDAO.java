package dao;

import model.Entregador;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 * @author guilherme-souza
 */
public class EntregadorDAO extends GenericoDAO<Entregador>{
    
    @Override
    public MensagemRetorno salvar(Entregador entregador){
        MensagemRetorno retorno = new PessoaDAO().salvar(entregador.getPessoa());
        Session sessao = null;
        if(retorno.isSucesso()){
            try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);

            sessao.saveOrUpdate(entregador);
            t.commit();

            retorno.setSucesso(true);
            retorno.setMensagem("Salvo com sucesso!");
            } catch (HibernateException he) {
                retorno.setMensagem(he.getMessage());
                he.printStackTrace();
            } finally {
                sessao.close();
            }
        }      
        return retorno; 
    }
    
    @Override
    public MensagemRetorno excluir(int id, String tabela){
        return new PessoaDAO().excluir(id);
    }
    
    @Override
    public MensagemRetorno excluir(Entregador entregador){
        return new PessoaDAO().excluir(entregador.getPessoa());
    }
    
    @Override
    public MensagemRetorno consultarPorId(int id, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela+" WHERE pessoa_id = :idParam");

            query.setInteger("idParam", id);
            
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
