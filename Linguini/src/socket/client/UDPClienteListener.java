package socket.client;

import java.net.DatagramSocket;
import java.net.SocketException;
import view.jdMensagem;

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
    
    private void rotinaListener(byte[] bytes){
        jdMensagem telaMensagem = new jdMensagem(null, true, new String(bytes));
        telaMensagem.setVisible(true);
    }
}
