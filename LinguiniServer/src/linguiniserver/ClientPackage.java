package linguiniserver;

import java.net.DatagramPacket;

/**
 * @author guilherme-souza
 */
public class ClientPackage {
    
    private byte[] data;
    private UDPClient client;

    public ClientPackage(DatagramPacket clientPackage) {
        this.data = clientPackage.getData();
        this.client = new UDPClient(clientPackage);
    }
    
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public UDPClient getClient() {
        return client;
    }

    public void setClient(UDPClient client) {
        this.client = client;
    }

}
