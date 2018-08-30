package dao;

import model.Pessoa;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 * @author guilherme-souza
 */
public class PessoaDAO extends GenericoDAO<Pessoa> implements SoftDelete{

    public MensagemRetorno excluir(int id){
        return this.inativar(id);
    }
    
    @Override
    public MensagemRetorno excluir(Pessoa p){
        return this.inativar(Integer.parseInt(p.getId().toString()));
    }

    @Override
    public MensagemRetorno inativar(int id) {
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);

            Query query = sessao.createQuery("UPDATE Pessoa p SET p.situacao=false WHERE id = :idParam");
            int qtd = query.setParameter("idParam", (long) id).executeUpdate();

            t.commit();
            retorno.setSucesso(true);
            retorno.setMensagem("Registro excluído com sucesso!");
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
}
