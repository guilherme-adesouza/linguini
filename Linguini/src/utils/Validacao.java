/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Fabricio Pretto
 */
public class Validacao {

    private static final int[] PESO_CPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] PESO_CNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validarCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), PESO_CPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, PESO_CPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }
        Integer digito1 = calcularDigito(cnpj.substring(0, 12), PESO_CNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, PESO_CNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarDataDMA (int d, int m, int a) {
        boolean correto = true;
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarDataFormatada (String dataComFormato) {
        String[] data = dataComFormato.split("/");
        return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
    }
    
    public static boolean validarHorario (String h)
    {
        String[] horario = h.split(":");
        
        int horas = 0;
        int minutos = 0;
        
        if(!horario [0].trim().isEmpty())
        {
            horas = Integer.parseInt(horario [0].trim());
        }

        if(!horario [1].trim().isEmpty())
        {
            minutos = Integer.parseInt(horario [1].trim());
        }
        
        boolean ok = !(horas>24 || horas<0 || minutos>60 || minutos<0);
        
        return ok;
    }

    public static void validarTelefone(JFormattedTextField campo) {
        if (campo.getText().trim().length() < 13) {
            Formatacao.formatarTelefone(campo);
        }
    }
    
    public static boolean validaCamposObrigatorios(JTextComponent[] componentes)
    {
        boolean preenchidos = true;
        for (JTextComponent componente : componentes)
        {
            if(componente.getText().isEmpty())
            {
                preenchidos = false;
                break;
            }
        }
        return preenchidos;
    }
    
    //Em um evento KeyTyped, apenas numerais serão digitados
    public static void digitaNumeral(java.awt.event.KeyEvent evt)
    {
        char vchar = evt.getKeyChar();
        
        if(!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE))
        {
            evt.consume();
        }
    }
    
    private static boolean validaDateChooser(JDateChooser date){
        return date.getDate() != null;
    }
    
    private static boolean validaCampoText (JTextComponent campo){
        return campo.getText() != null && !campo.getText().trim().isEmpty();
    }
    
    public static boolean camposPreenchidos(JDateChooser[] campos)
    {
        boolean preenchidos = true;
        for (JDateChooser campo : campos) {
            if(!validaDateChooser(campo)){
                campo.setBackground(Color.YELLOW);
                preenchidos = false;
            }
        }
        return preenchidos;
    }
    
    public static boolean camposPreenchidos(JTextField[] campos)
    {
        boolean ok = true;
        for (JTextField campo : campos) {
            if(validaCampoText(campo)){
                if(ok){
                    campo.requestFocus();
                }
                campo.setBackground(Color.YELLOW);
                ok = false;
            }
        }
        return ok;
    }
    
    public static void camposPreenchidos(JComponent[] campos)
    {
        boolean ok = true;
        for (JComponent campo : campos) {
            if(campo instanceof JTextComponent){
                if(validaCampoText((JTextComponent)campo)){
                    if(ok){
                        campo.requestFocus();
                    }
                    campo.setBackground(Color.YELLOW);
                    ok = false;
                }
            }  
            else if(campo instanceof JDateChooser){
                if(validaDateChooser((JDateChooser) campo)){
                    if(ok){
                        campo.requestFocus();
                    }
                    campo.setBackground(Color.YELLOW);
                    ok = false;
                }
            }
        }
    }
    
    public static String parseNumVazio(JTextComponent s, int a)
    {
        if(s.getText().isEmpty())
        {
            s.setText(a+"");
        }    
        return s.getText();
    }
    
    public static boolean contarNumeros(String x, int qta) {
        int qtdDigitos = 0;
        for (int i = 0; i < x.length(); i++) {
            //char dig = x.charAt(i);  
            if (Character.isDigit(x.charAt(i))) {
                if (++qtdDigitos == qta) {
                    return true;
                }
            }
        }
        return false;
    }
}
