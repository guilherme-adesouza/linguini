package socket.client;

import dao.MensagemRetorno;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPCliente {
    
    public static final String IP_SERVIDOR = "127.0.0.1";
    public static final int PORTA_SERVER = 5000;
    public static final int PORTA_CLIENTE = 6060;
    public static final int TAM_BUFFER = 4096;
    public static final String DOWNLOAD_FOLDER = "downloads/";
    
    public static void main(String[] args) {
//        File file = new File(UDPCliente.DOWNLOAD_FOLDER+"/file.txt");
//        UDPCliente.uploadArquivo(file);
        
        UDPCliente.downloadArquivo("upload.txt");

//        try {
//            enviarPacote(clientSocket, "teste".getBytes());
//            byte[] resposta = receberPacote(clientSocket);
//            System.out.println("Resposta: " + new String(resposta));
//            clientSocket.close();
//        } catch(SocketException e) {
//            System.err.print(e);
//        }        
    }
    
    public static MensagemRetorno uploadArquivo(File arquivo) {
       
        //verifica se arquivo existe
        byte[] bytes = fileToBytes(arquivo);
        boolean fileEmpty = true;
        for (byte fileByte : bytes) {
            if(fileByte != 0) {
                fileEmpty = false;
                break;
            }
        }
        
        MensagemRetorno msg = new MensagemRetorno();

        if(!fileEmpty) {
            try {
                DatagramSocket clientSocket = new DatagramSocket(UDPCliente.PORTA_CLIENTE);

                //enviar acao para servidor UDP
                UDPCliente.enviarPacote(clientSocket, "upload".getBytes());

                //enviar nome do arquivo para servidor UDP
                UDPCliente.enviarPacote(clientSocket, arquivo.getName().getBytes());

                //inicia processo de envio do arquivo
                int count = 0;

                byte[] bufferSaida = new byte[TAM_BUFFER];

                for (byte b : bytes) {
                    bufferSaida[count] = b;
                    count++;

                    if (count == TAM_BUFFER) {
                        //envia buffer
                        UDPCliente.enviarPacote(clientSocket, bufferSaida);
                        //recebe confirmação
                        UDPCliente.receberPacote(clientSocket);

                        bufferSaida = new byte[TAM_BUFFER];
                        count = 0;
                    }
                }
                //envia último buffer
                UDPCliente.enviarPacote(clientSocket, bufferSaida);
                //recebe confirmação
                UDPCliente.receberPacote(clientSocket);

                //envia confirmação de término buffer
                UDPCliente.enviarPacote(clientSocket, "finish".getBytes());
                clientSocket.close();

                msg.setSucesso(true);
                msg.setMensagem("CAMINHO DO SERVIDOR PARA PEGAR ARQUIVO");
            }
            catch (Exception e){            
                System.err.print(e);
                msg.setSucesso(false);
                msg.setMensagem(e.getMessage());            
            }
        }
        else {
            System.out.println("ERROU!");
            msg.setSucesso(false);
            msg.setMensagem("Arquivo não existe!");
        }
        return msg;
    }
    
    public static MensagemRetorno downloadArquivo(String nomeArquivo) {
        MensagemRetorno msg = new MensagemRetorno();
        try {
            DatagramSocket clientSocket = new DatagramSocket(UDPCliente.PORTA_CLIENTE);
            //enviar acao para servidor UDP
            UDPCliente.enviarPacote(clientSocket, "download".getBytes());

            //enviar nome do arquivo para servidor UDP
            UDPCliente.enviarPacote(clientSocket, nomeArquivo.trim().getBytes());
            
            byte[] bufferEntrada = UDPCliente.receberPacote(clientSocket);

            FileOutputStream out = new FileOutputStream(UDPCliente.DOWNLOAD_FOLDER + nomeArquivo.trim(), true);

            while (bufferEntrada != null && !(new String(bufferEntrada)).trim().equals("finish")) {
                out.write(bufferEntrada);
                
                //enviar para receber próximo pacote
                UDPCliente.enviarPacote(clientSocket, "next".getBytes());
                //receber resposta do servidor
                bufferEntrada = UDPCliente.receberPacote(clientSocket);
            }
            out.close();

            //caminho do arquivo recebido do servidor para salvar no BD
            bufferEntrada = UDPCliente.receberPacote(clientSocket);

            clientSocket.close();
            
            msg.setSucesso(true);
            msg.setMensagem(new String(bufferEntrada));
        }
        catch (IOException e){
            System.err.print(e);
            msg.setSucesso(false);
            msg.setMensagem(e.getMessage());
        }
        return msg;
    }
    
    private static boolean enviarPacote(DatagramSocket clientSocket, byte[] conteudo){
        try {
            InetAddress ipServidor = InetAddress.getByName(UDPCliente.IP_SERVIDOR);
            byte[] bufferSaida = new byte[TAM_BUFFER];
            
            bufferSaida = conteudo;
            DatagramPacket sendPacket = new DatagramPacket(bufferSaida, bufferSaida.length, ipServidor, PORTA_SERVER);
            clientSocket.send(sendPacket);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    } 
    
    private static byte[] receberPacote(DatagramSocket clientSocket ){
        try {
            byte[] bufferEntrada = new byte[TAM_BUFFER];
            
            DatagramPacket receivePacket = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            clientSocket.receive(receivePacket);
            return receivePacket.getData();
        }
        catch(Exception e) {
            return null;
        }
    } 
    
    public static byte[] fileToBytes(File file) {
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