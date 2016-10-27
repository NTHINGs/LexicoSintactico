
/* --------------------------Codigo de Usuario----------------------- */
package analizadorsintactico;

import java_cup.runtime.*;
import java.io.Reader;
import java.lang.System;

      
%% //inicio de opciones
   
/* ------ Seccion de opciones y declaraciones de JFlex -------------- */  
   
/* 
    Cambiamos el nombre de la clase del analizador a Lexer
*/

/*
    Activar el contador de lineas, variable yyline
    Activar el contador de columna, variable yycolumn
*/
%line
%column
%unicode
%public
%class AnalizadorLexico
/* 
   Activamos la compatibilidad con Java CUP para analizadores
   sintacticos(parser)
*/
%cup
%eof{
%eof}
%char   
/*
    Declaraciones

    El codigo entre %{  y %} sera copiado integramente en el 
    analizador generado.
*/
%{
    /*  Generamos un java_cup.Symbol para guardar el tipo de token 
        encontrado */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Generamos un Symbol para el tipo de token encontrado 
       junto con su valor */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

/*
    Macro declaraciones
  
    Declaramos expresiones regulares que despues usaremos en las
    reglas lexicas.
*/
   
/*  Un salto de linea es un \n, \r o \r\n dependiendo del SO   */
Salto = \r|\n|\r\n
   
/* Espacio es un espacio en blanco, tabulador \t, salto de linea 
    o avance de pagina \f, normalmente son ignorados */
Espacio = {Salto} | [ \t\f]
   
/* Una literal entera es un numero 0 oSystem.out.println("\n*** Generado " + archNombre + "***\n"); un digito del 1 al 9 
    seguido de 0 o mas digitos del 0 al 9 */
Enteros = 0 | [1-9][0-9]*

//Definiciones del otro analizador
Letramayus=[A-Z]
Letramin=[a-z]
Digitos=[0-9]
Identificadores=({Letramayus})({Letramin}+)(({Letramin}*)({Digitos}*))+
Reales=({Digitos})+(".")({Digitos})+
Realescientificos=({Digitos})+(".")({Digitos})+("E"("+")|("-"))({Digitos}{Digitos})
String=("\"")(.)+("\"")
Relacionales=(">"|"<"|">="|"<="|"<>"|"==")
Aritmeticos=("+"|"-"|"*"|"/")
%% //fin de opciones
/* -------------------- Seccion de reglas lexicas ------------------ */
   
    {Identificadores} { return symbol(sym.NONIDENTIFICADOR, new token(yytext(),yychar,yyline));}

    {Enteros} {return symbol(sym.NONENTERO,new token(yytext(),yychar,yyline));}

    {Reales} {return symbol(sym.NONREAL,new token(yytext(),yychar,yyline));}

    {Realescientificos} {return symbol(sym.NONREALCIENT,new token(yytext(),yychar,yyline));}

    {String} {return symbol(sym.NONSTRING,new token(yytext(),yychar,yyline));}

    "F" {return symbol(sym.NONEFE,new token(yytext(),yychar,yyline));}

    "OPEN" {return symbol(sym.NONOPEN,new token(yytext(),yychar,yyline));}

    "CLOSE" {return symbol(sym.NONCLOS,new token(yytext(),yychar,yyline));}

    "IDENT" {return symbol(sym.NONIDENT,new token(yytext(),yychar,yyline));}

    "ENDIDENT" {return symbol(sym.NONENDIDENT,new token(yytext(),yychar,yyline));}

    "INT" {return symbol(sym.NONINT,new token(yytext(),yychar,yyline));}

    "CHAR" {return symbol(sym.NONCHAR,new token(yytext(),yychar,yyline));}

    "FLOAT" {return symbol(sym.NONFLOAT,new token(yytext(),yychar,yyline));}

    "BOOLEAN" {return symbol(sym.NONBOOLEAN,new token(yytext(),yychar,yyline));}

    "WHILE" {return symbol(sym.NONWHILE,new token(yytext(),yychar,yyline));}

    "ENDWHILE" {return symbol(sym.NONENDWHILE,new token(yytext(),yychar,yyline));}

    "REPEAT" {return symbol(sym.NONREPEAT,new token(yytext(),yychar,yyline));}

    "UNTIL" {return symbol(sym.NONUNTIL,new token(yytext(),yychar,yyline));}

    "IF" {return symbol(sym.NONIF,new token(yytext(),yychar,yyline));}

    "ELSE" {return symbol(sym.NONELSE,new token(yytext(),yychar,yyline));}

    "ENDIF" {return symbol(sym.NONENDIF,new token(yytext(),yychar,yyline));}

    "=" {return symbol(sym.NONIGUAL,new token(yytext(),yychar,yyline));}

    {Relacionales} {return symbol(sym.NONREL,new token(yytext(),yychar,yyline));}

    {Aritmeticos} {return symbol(sym.NONARIT,new token(yytext(),yychar,yyline));}

    "." {return symbol(sym.NONPUNTO,new token(yytext(),yychar,yyline));}

    "," {return symbol(sym.NONCOMA,new token(yytext(),yychar,yyline));}

    ";" {return symbol(sym.NONPUNTOYCOMA,new token(yytext(),yychar,yyline));}

    ":" {return symbol(sym.NONDOSPUNTOS,new token(yytext(),yychar,yyline));}

    "(" {return symbol(sym.NONPARABRE,new token(yytext(),yychar,yyline));}
    
    ")" {return symbol(sym.NONPARCIERRA,new token(yytext(),yychar,yyline));}
    /* No hace nada si encuentra el espacio en blanco */
    {Espacio}       { /* ignora el espacio */ } 


/* Si el token contenido en la entrada no coincide con ninguna regla
    entonces se marca un token ilegal */
     . {System.out.println(yytext()+"error");}