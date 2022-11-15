package view.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitaCaracteres extends PlainDocument {

    public enum TipoEntrada {
        NOME, EMAIL, DATA, NUMERO;
    };

    private int qtdCaracteres;
    private TipoEntrada tpEntrada;

    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tpEntrada = tpEntrada;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null || getLength() == qtdCaracteres) {
            return;
        }
        int totalCarac = getLength() + str.length();
        //filtro de caracteres
        String regex = "";
        switch(tpEntrada){
            case NOME:          regex = "[^\\p{IsLatin} ]"; break;
            case EMAIL:         regex = "[^a-z\\-._@|^0-9]"; break;
            //case EMAIL:         regex = "[^\\p{IsLatin}@.\\-_][^0-9]"; break;
            case DATA:          regex = "[^0-9/]"; break;     
            case NUMERO:       regex = "[^0-9]"; break;         
        }
        //fazendo a substituição
        str = str.replaceAll(regex,"");
        
        if (totalCarac <= qtdCaracteres){
            super.insertString(offs, str, a); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }else{
        String nova = str.substring(0, qtdCaracteres);
        super.insertString(offs, nova, a);
        }
        
        
    }
    
}
