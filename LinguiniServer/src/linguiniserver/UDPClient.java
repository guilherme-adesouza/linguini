package linguiniserver;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * @author guilherme-souza
 */
public class UDPClient {
    private InetAddress ipCliente;
    private int portaCliente;
    
    public UDPClient(DatagramPacket packet) {
        this.ipCliente = packet.getAddress();
        this.portaCliente = packet.getPort();
    }

    public InetAddress getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(InetAddress ipCliente) {
        this.ipCliente = ipCliente;
    }

    public int getPortaCliente() {
        return portaCliente;
    }

    public void setPortaCliente(int portaCliente) {
        this.portaCliente = portaCliente;
    }
    
    public String getName(){
        return this.ipCliente.getCanonicalHostName();
    }

    @Override
    public String toString() {
        return "Client " + this.getName() +"\n"+
               "IP:" + this.getIpCliente().getHostAddress() +"\n"+
               "PORT: " + this.getPortaCliente();
    }
}
