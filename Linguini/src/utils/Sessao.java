package utils;

import model.Usuario;

/**
 * @author guilherme-souza
 */
public class Sessao {
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Sessao.usuario = usuario;
    }
}
