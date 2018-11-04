package api;

import java.util.Date;

/**
 * @author guilherme-souza
 */
public class PrevisaoTempo {
    
    private String cidade;
    private String tempo;
    private Date dia;
    private double temperatura;
    private double temperaturaMaxima;
    private double temperaturaMinima;
    
    private static final String LAJEADO = "3459035";
    
    public PrevisaoTempo(){
        this.cidade = "Lajeado";
        this.tempo = "";
        this.dia = new Date();
        this.temperatura = 0;
        this.temperaturaMaxima = 0;
        this.temperaturaMinima = 0;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public String toString() {
        return "{ \n" + 
                    "\"cidade\": " + cidade + ",\n "
                    + "\"tempo\": \"" + tempo + "\",\n"
                    + "\"dia\": " + dia.getTime() + ",\n"
                    + "\"dia-extenso\": " + dia.toString() + ",\n"
                    + "\"temperatura\": " + temperatura + ",\n"
                    + "\"temperaturaMaxima\": " + temperaturaMaxima + ",\n"
                    + "\"temperaturaMinima\": " + temperaturaMinima + "\n "
                + "}";
    }
}
