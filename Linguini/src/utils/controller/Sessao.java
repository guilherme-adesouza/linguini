package utils.controller;

import javassist.bytecode.Bytecode;
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
    private static Licenca licenca;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        new UDPClienteListener().start();
        Sessao.usuario = usuario;
    }

    public static void setTela(jdPedidosCozinha tela) {
        Sessao.tela = tela;
    }

    public static jdPedidosCozinha getTela() {
        return tela;
    }

    public static void setLicenca(Licenca licenca) {
        new Licenca();
        Sessao.licenca = licenca;
    }
    public static Licenca getLicenca() {
        return licenca;
    }
}
