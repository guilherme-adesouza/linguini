package utils;

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
        return SHA(palavra);
    }
    
    private static String SHA(String palavra) {
        return palavra;
    }
    
    private static String MD5(String palavra){
        return palavra;
    }
}
