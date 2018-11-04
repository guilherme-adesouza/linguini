package api;

import dao.MensagemRetorno;
import org.json.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author guilherme-souza
 */
public class PrevisaoTempoAPI {
    
    private final String url = "http://api.openweathermap.org/data/2.5";
    private final String cidade = "3459035"; //lajeado
    private final String apiKey = "047aee25e46d6df9678cf5fe3faa467f";
    private final String lang = "pt";
    
    private final ApiRepository api = new OkHttpAPI();
    
    public static void main(String[] args) throws IOException {
        PrevisaoTempoAPI previsao = new PrevisaoTempoAPI();
            previsao.atual();
    }
    
    public MensagemRetorno atual() throws IOException {
        String finalUrl = url+"/weather?id="+cidade+"&lang="+lang+"&APPID="+apiKey+"&units=metric";
        String resposta = api.get(finalUrl, ApiRepository.JSON, null);
        System.out.println(resposta);
        MensagemRetorno msg = new MensagemRetorno();
        
        try {
            JSONObject json = new JSONObject(resposta);
            msg.setObjeto(this.JSONtoObject(json));
            msg.setSucesso(true);
        } catch(JSONException e) {
            msg.setMensagem("As chamadas a API foram esgotadas! Aguarde o tempo necessário para nova requisição");
        }        
        return msg;
    }
    
    private JSONArray getWeather(JSONObject json){
        return json.getJSONArray("weather");
    }
    
    private String getDescription(JSONObject json){
        JSONObject jsonWeather = new JSONObject(this.getWeather(json).get(0).toString());
        return jsonWeather.getString("description");
    }
    
    private double getTemperatura(JSONObject json){
        return json.getJSONObject("main").getDouble("temp");
    }
    
    private double getTemperaturaMaxima(JSONObject json){
        return json.getJSONObject("main").getDouble("temp_max");
    }
    
    private double getTemperaturaMinima(JSONObject json){
        return json.getJSONObject("main").getDouble("temp_min");
    }
    
    public MensagemRetorno proximos5Dias() throws IOException {
        String finalUrl = url+"/forecast?id="+cidade+"&lang="+lang+"&APPID="+apiKey+"&units=metric";
        String resposta = api.get(finalUrl, ApiRepository.JSON, null);
        System.out.println(resposta);
        MensagemRetorno msg = new MensagemRetorno();
        try {
            JSONArray list = new JSONObject(resposta).getJSONArray("list");
            for (Object object : list) {
                JSONObject json = (JSONObject) object;
                PrevisaoTempo previsao = this.JSONtoObject(json); 
                previsao.setDia(new Date(json.getLong("dt") * 1000));
                msg.getLista().add(previsao);
            }
            msg.setSucesso(true);
        } catch(JSONException e) {
            msg.setMensagem("As chamadas a API foram esgotadas! Aguarde o tempo necessário para nova requisição");
        }
        return msg;
    }
    
    private String proximosXDias(int dias) throws IOException {
        String finalUrl = url+"/forecast/daily?id="+cidade+"&lang="+lang+"&APPID="+apiKey+"&units=metric&cnt="+dias;
        return api.get(finalUrl, ApiRepository.JSON, null);
    }
    
    private PrevisaoTempo JSONtoObject(JSONObject json){
        PrevisaoTempo previsaoTempo = new PrevisaoTempo();
            
        previsaoTempo.setCidade(json.getString("name"));
        previsaoTempo.setTempo(this.getDescription(json));
        previsaoTempo.setTemperatura(this.getTemperatura(json));
        previsaoTempo.setTemperaturaMaxima(this.getTemperaturaMinima(json));
        previsaoTempo.setTemperaturaMinima(this.getTemperaturaMinima(json));
        
        return previsaoTempo;
    }
}
