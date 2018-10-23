package linguiniserver;


/**
 * @author guilherme-souza
 */
public class LinguiniServer {
    public static void main(String[] args) {
        System.out.println("Initializing Linguini Server: UDP Tabajara... ");
        UDPServer s = new UDPServer();
        s.start();
    }
}
