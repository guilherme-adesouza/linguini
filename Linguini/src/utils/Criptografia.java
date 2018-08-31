package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author guilherme-souza
 */
public class Criptografia {
    /**
     * Compara a criptografia de uma {@code String} passada é igual a {@code 
     * String} encriptografada passada.  Retorna {@code
     * true} quando as duas palavras (criptografadas) forem iguais, 
     * caso contrário {@code false}.
     * 
     * @param palavra
     * @param encriptada
     * @return 
     */
    public static boolean equals(String palavra, String encriptada) {
        return criptografar(palavra).equals(encriptada);
    }
    
    public static String criptografar(String palavra){
        return SHA256(palavra);
    }
    
    private static String SHA256(String palavra) {
        String cripto = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(palavra.getBytes(StandardCharsets.UTF_8));
            cripto = bytesToHex(encodedhash);
        }
        catch(NoSuchAlgorithmException e){
            return "";
        }
        finally {
            return cripto;            
        }        
    }
    
    private static String MD5(String palavra){
        return palavra;
    }
    
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
