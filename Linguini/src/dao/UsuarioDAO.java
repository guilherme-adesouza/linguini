package dao;

import model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;
import utils.Criptografia;

/**
 * @author guilherme-souza
 */
public class UsuarioDAO extends GenericoDAO<Usuario> {
    
    @Override
    public MensagemRetorno salvar(Usuario usuario){
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            
            String senhaCriptografada = Criptografia.criptografar(usuario.getSenha());
            usuario.setSenha(senhaCriptografada);
            
            sessao.save(usuario);
            t.commit();

            retorno.setSucesso(true);
            retorno.setMensagem("Salvo com sucesso!");
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public MensagemRetorno consultarPorNome(Usuario usuario){
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM Usuario u WHERE u.nome = :nomeParam");

            query.setString("nomeParam", usuario.getNome());
            
            retorno.setObjeto((Object) query.uniqueResult());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
}
