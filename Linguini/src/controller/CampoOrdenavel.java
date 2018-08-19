package controller;

/**
 * @author guilherme-souza
 */
public class CampoOrdenavel {
    private String nome;
    private String campo;

    public CampoOrdenavel(String nome, String campo) {
        this.nome = nome;
        this.campo = campo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
