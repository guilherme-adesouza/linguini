/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author pretto
 */
public class Calendario {

    SimpleDateFormat sdData = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdHora = new SimpleDateFormat("HH:mm");
    Calendar cal = new GregorianCalendar();

    public String obterDataAtualDMA() {
        return String.valueOf(sdData.format(cal.getTime()));
    }

    public String obterDataAtualMais(int dias) {
        cal.add(Calendar.DAY_OF_MONTH, dias);
        return (sdData.format(cal.getTime()));
    }

    public String obterDataAtualMenos(int dias) {
        cal.add(Calendar.DAY_OF_MONTH, -dias);
        return (sdData.format(cal.getTime()));
    }

    public String obterHoraAtual() {
        Date data = new Date();
        return (String.valueOf(sdHora.format(data)));
    }
    
    public Date getDateDeString(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public String getDataDeDate(Date data) {
        // ESTOU USANDO
        DateFormat dfe = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = dfe.format(data);

        return dataHoje;

    }
    public String getDataHoraDeDate(Date data) {
        // ESTOU USANDO
        DateFormat dfe = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataHoje = dfe.format(data);

        return dataHoje;

    }
}
