package utils.controller;

import javax.swing.JFrame;
import model.Usuario;
import socket.client.UDPClienteListener;
import view.jdPedidosCozinha;

/**
 * @author guilherme-souza
 */
public class Sessao {
    private static Usuario usuario;
    private static jdPedidosCozinha tela;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        new UDPClienteListener().start();
        Sessao.usuario = usuario;
    }
    
    public static void setTela(jdPedidosCozinha tela){
        Sessao.tela = tela;
    }
    
    public static jdPedidosCozinha getTela(){
        return tela;
    }
}
