package utils.view;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.*;

public class Formatacao {

    static DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
    private static final String MASK_TELEFONE = "(##) ####-####";
    private static final String MASK_CNPJ = "##.###.###/####-##";
    private static final String MASK_CPF = "###.###.###-##";
    private static final String MASK_CEP = "#####-###";
    private static final String MASK_DATA = "##/##/####";
    private static final String MASK_DATA_DIAMES = "##/##";
    private static final String MASK_HORA = "##:##";
    private static final String MASK_PLACA = "UUU-####";
    private static final String MASK_DATAHORA= MASK_DATA+" "+MASK_HORA;
            
    public static JFormattedTextField getFormatado(String formato) {
        JFormattedTextField campoFormatado = null;
        MaskFormatter format = new MaskFormatter();

        format.setPlaceholderCharacter(' ');
        format.setValueContainsLiteralCharacters(false);

        try {
            format.setMask(formato);
            campoFormatado = new JFormattedTextField(format);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return campoFormatado;
    }

    public static void formatarDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static String formatarDecimal(double valor) {
        NumberFormat formatter = new DecimalFormat("###0.00");
        return (formatter.format(valor));
    }

    public static JFormattedTextField getTelefone() {
        return getFormatado(MASK_TELEFONE);
    }

    public static JFormattedTextField getCNPJ() {
        return getFormatado(MASK_CNPJ);
    }

    public static JFormattedTextField getCPF() {
        return getFormatado(MASK_CPF);
    }

    public static JFormattedTextField getData() {
        return getFormatado(MASK_DATA);
    }
    
    public static JFormattedTextField getData_Diames() {
        return getFormatado(MASK_DATA_DIAMES);
    }

    public static JFormattedTextField getDataHora() {
        return getFormatado(MASK_DATAHORA);
    }
    
    public static JFormattedTextField getHora() {
        return getFormatado(MASK_HORA);
    }
    
    public static JFormattedTextField getCEP() {
        return getFormatado(MASK_CEP);
    }
    
    private static void formatar(JFormattedTextField campo, String mascara)
    {
        try 
        {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask(mascara);
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }  
    }

    public static void formatarHora(JFormattedTextField campo)
    {
        formatar(campo,MASK_HORA); 
    }

    public void formatoDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static void formatarData(JFormattedTextField campo) {
        formatar(campo,MASK_DATA); 
    }
    
    public static void formatarData_Diames(JFormattedTextField campo) {
        formatar(campo,MASK_DATA_DIAMES); 
    }
    
    public static void formatarPlaca(JFormattedTextField campo) {
        formatar(campo,MASK_PLACA); 
    }

    public static void formatarCpf(JFormattedTextField campo) {
        formatar(campo,MASK_CPF); 
    }

    public static void formatarCnpj(JFormattedTextField campo) {
        formatar(campo,MASK_CNPJ); 
    }

    public static void formatarTelefone(JFormattedTextField campo) {
        formatar(campo,MASK_TELEFONE); 
    }
    
    public static void formatarCEP(JFormattedTextField campo) {
        formatar(campo,MASK_CEP); 
    }

    public static String ajustaDataDMA(String data) {
        String dataFormatada = null;
        try {
            Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String ajustaDataAMD(String data) {
        String dataFormatada = null;
        try {
            Date dataDMA = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(dataDMA);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String removerFormatacao(String dado) {
        String retorno = "";
        for (int i = 0; i < dado.length(); i++) {
            if (dado.charAt(i) != '.' && dado.charAt(i) != '/' && dado.charAt(i) != '-' && dado.charAt(i) != '(' && dado.charAt(i) != ')') 
            {
                if(dado.charAt(i) == ',')
                {
                    retorno += '.';
                }
                else
                {
                    retorno += dado.charAt(i);
                }
            }
        }
        return (retorno);
    }

    public static String getDataAtual() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = df.format(now);

        return dataHoje;
    }

    public static String getDataHoraAtual() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataHoje = df.format(now);

        return dataHoje;
    }
    
    public static String representarBoolean(Boolean b, String para_true, String para_false)
    {
        String r = para_false;
        if(b)
        {
            r = para_true;
        }
        return r;
    }
    
    public static String representarBoolean(String b, String para_true, String para_false)
    {
        String r = para_false;
        if(b.equals("t"))
        {
            r = para_true;
        }
        return r;
    }
}

