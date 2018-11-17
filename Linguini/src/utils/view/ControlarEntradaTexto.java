package utils.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ControlarEntradaTexto extends PlainDocument {

    private int tamanhoMax = 10;

    public ControlarEntradaTexto(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        String stringAntiga = getText(0, getLength());
        int tamanhoNovo = stringAntiga.length() + str.length();

        if (tamanhoNovo <= tamanhoMax && Character.isLetter(str.charAt(0)) || str.equals(" ")) {
            super.insertString(offs, str.toUpperCase(), a);
        } else {
            super.insertString(offs, "", a);
        }
    }
}
