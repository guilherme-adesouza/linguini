package utils;

import model.Usuario;
import socket.client.UDPClienteListener;

/**
 * @author guilherme-souza
 */
public class Sessao {
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        new UDPClienteListener().start();
        Sessao.usuario = usuario;
    }
}
