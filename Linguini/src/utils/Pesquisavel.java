package utils;

/**
 * @author guilherme-souza
 */
public interface Pesquisavel
{
    public void carregar(int codigo, String campo_alvo);
    public void limpaCampos(int codigo);
}
