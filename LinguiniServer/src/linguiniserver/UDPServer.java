package linguiniserver;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer extends Thread {
    
    public static final int PORT = 5000;
    public static final int TAM_BUFFER = 4096;
    public static final String UPLOAD_FOLDER= "uploads/";

    @Override
    public void run() {
        

        try {
            System.out.println("OS: " + System.getProperty("os.name") +"\n"+
                    "Version: " + System.getProperty("os.version")+"\n"+
                    "Architecture: " + System.getProperty("os.arch")+"\n"+
                    "Port: " + UDPServer.PORT+"\n");            
            
            DatagramSocket serverSocket = new DatagramSocket(PORT);

            while (true) {

                System.out.println("Waiting new communication...");
                                
                ClientPackage clientPackage = UDPServer.receberPacote(serverSocket);  
                //new client
                System.out.println("clientPackage: "+clientPackage);
                UDPClient client = clientPackage.getClient();
                System.out.println(client+"\n");
                
                String recebido = new String(clientPackage.getData());
                
                String mensagem = "";

                switch (recebido.trim().toLowerCase()) {
                    case "upload":
                        
                        System.out.println("Upload request. Waiting filename...");

                        String file = new String(UDPServer.receberPacote(serverSocket).getData());
                        System.out.println("File: " + file);
                        
                        byte[] bufferEntrada =  UDPServer.receberPacote(serverSocket).getData();
                        
                        FileOutputStream out = new FileOutputStream( UDPServer.UPLOAD_FOLDER  + file.trim(), true);

                        while (!(new String(bufferEntrada)).trim().equals("finish")) {
                            out.write(bufferEntrada);
                            
                            //send to receive next package
                            UDPServer.enviarPacote(serverSocket, client, bufferEntrada);                            
                            //wait client answer
                            bufferEntrada = UDPServer.receberPacote(serverSocket).getData();                            
                        }

                        out.close();

                        mensagem = "Upload successfully";
                        break;
                    case "download":
                        System.out.println("Upload request. Waiting filename...");

                        ClientPackage downloadPackage = UDPServer.receberPacote(serverSocket);                      
                        file = new String(downloadPackage.getData());
                        System.out.println("File: " + file);

                        byte[] bufferSaida = new byte[TAM_BUFFER];
                        byte[] bytes = fileToBytes(file.trim());
                        int count = 0;

                        for (byte b : bytes) {
                            bufferSaida[count] = b;
                            count++;

                            if (count == TAM_BUFFER) {
                                //send buffer
                                UDPServer.enviarPacote(serverSocket, downloadPackage.getClient(), bytes);
                                //receive confirmation
                                UDPServer.receberPacote(serverSocket);
                                
                                bufferSaida = new byte[TAM_BUFFER];
                                count = 0;
                            }
                        }

                        //send last buffer
                        UDPServer.enviarPacote(serverSocket, downloadPackage.getClient(), bytes);
                        //receive confirmation
                        UDPServer.receberPacote(serverSocket);

                        //send confirmation of last buffer
                        UDPServer.enviarPacote(serverSocket, downloadPackage.getClient(), "finish".getBytes());
                        serverSocket.close();
                        
                        break;

                    case "list":
                        File folder = new File(UDPServer.UPLOAD_FOLDER);
                        File[] listOfFiles = folder.listFiles();

                        for (int i = 0; i < listOfFiles.length; i++) {
                            mensagem += (i + 1) + ": " + listOfFiles[i].getName() + "\n";
                        }

                        break;
                    default:
                        mensagem = "Help:\n";
                        mensagem += "Digit 'upload' to send a file\n";
                        mensagem += "Digit 'download' to download a file\n";
                        mensagem += "Digit 'list' to see all files\n";
                        break;
                }
                
                UDPServer.enviarPacote(serverSocket, client, mensagem.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static boolean enviarPacote(DatagramSocket serverSocket, UDPClient client, byte[] conteudo){
        try {
            byte[] bufferSaida = new byte[TAM_BUFFER];
            bufferSaida = conteudo;
            DatagramPacket sendPacket = new DatagramPacket(bufferSaida, bufferSaida.length, client.getIpCliente(), client.getPortaCliente());
            serverSocket.send(sendPacket);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    } 
    
    private static ClientPackage receberPacote(DatagramSocket serverSocket){        
        try {
            byte[] bufferEntrada = new byte[TAM_BUFFER];
            
            DatagramPacket receivePacket = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            serverSocket.receive(receivePacket);
            
            ClientPackage clientPackage = new ClientPackage(receivePacket);
            return clientPackage;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public static byte[] fileToBytes(String path) {
        File file = new File(UDPServer.UPLOAD_FOLDER+"/"+path);

        byte[] b = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Error Reading The File.");
            e1.printStackTrace();
        }
        return b;
    }
}
