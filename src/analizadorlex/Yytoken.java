/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlex;

/**
 *
 * @author nthings
 */
public class Yytoken {
    Yytoken (int numToken,String text, String compo, int line, int charBegin){
        //Contador para el número de tokens reconocidos
        m_numToken = numToken;
        //String del token reconocido
        m_text = new String(text);
        //Tipo de componente léxico encontrado
        m_compo = compo;
        //Número de linea
        m_line = line;
        //Columna donde empieza el primer carácter del token
        m_charBegin = charBegin;
    }   

    //Métodos de los atributos de la clase
    public int m_numToken;
    public String m_text;
    public String m_compo;
    public int m_line;
    public int m_charBegin;
    //Metodo que devuelve los datos necesarios que escribiremos en un archivo de salida
    public String toString() {
        return "Token #"+m_numToken+": "+m_text+" C.Lexico: "+m_compo+" Line: "+m_line+" Column: "+m_charBegin;
    }
}
