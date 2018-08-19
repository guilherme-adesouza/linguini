package dao;

import org.hibernate.Session;

/**
 * @author guilherme-souza
 */
public interface SoftDelete {
    public MensagemRetorno inativar(int id);
}
