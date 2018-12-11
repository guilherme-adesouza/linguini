package socket.client;

import controller.PedidoController;
import java.net.DatagramSocket;
import java.net.SocketException;
import utils.controller.Sessao;
import view.jdMensagem;
import view.jdPedidosCozinha;

/**
 * @author guilherme-souza
 */
public class UDPClienteListener extends Thread {

    private static final int LISTENER_PORT = 7070;
            
    @Override
    public void run() {
        System.out.println("UDPClienteListener inicialiazado... ");
        try {
            DatagramSocket listenerSocket = new DatagramSocket(LISTENER_PORT);
            UDPCliente.enviarPacote(listenerSocket, "receiver".getBytes());
            while(true) {
                byte[] bytes = new byte[UDPCliente.TAM_BUFFER];
                bytes = UDPCliente.receberPacote(listenerSocket);
                this.rotinaListener(bytes);
            }
        }
        catch(SocketException e) {
            System.out.println("CLIENT ERROR 500");
            e.printStackTrace();
        }
    }
    
    //padrão da mensagem
    // mensagem/id
    private void rotinaListener(byte[] bytes){
        String msg = new String(bytes);
        int idPedido = Integer.parseInt(msg.split("/")[1]);
        if(msg.contains("pedido")){
            jdPedidosCozinha tela = Sessao.getTela();
            if(tela != null) {
                tela.pedidoRecebido(idPedido);
            }
        } else if(msg.contains("recebido")) {
            new PedidoController().atualizarStatus(idPedido, PedidoController.ADICIONADO);
        } else if(msg.contains("finalizado")) {
            new PedidoController().atualizarStatus(idPedido, PedidoController.FINALIZADO);
        }
    }
    
    private void rotinaTeste(byte[] bytes){
        String msg = new String(bytes);
        jdMensagem telaMensagem = new jdMensagem(null, true, msg);
        telaMensagem.setVisible(true);
    }
}
