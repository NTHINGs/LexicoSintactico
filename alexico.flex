package analizadorlex;
import java.lang.System;


%%
//permite cambiar el nombre de la función de yylex que reconoce los tokens (next token)
%function nextToken
//permite cambiar el nombre de la clase del analizador léxico, desde Yylex.
%class Analizador
%public
//se define in integer para el contador de tokens
%{
private int contador;
boolean error;

public boolean getError(){
     return error;
}
%}
//con init inicializamos variables
%init{
contador = 0;
error=false;
%init}
//fin de fichero
%eof{
%eof}
//Activa el contador de líneas, almacena en al variable entera yyline el índice de la primera //línea del token reconocido
%line
//activa el contador de caracteres, por defecto desactivado, almacena en al variable entera yychar el índice del primer caracter del token reconocido
%char
Letramayus=[A-Z]
Letramin=[a-z]
Digitos=[0-9]
Identificadores=({Letramayus})({Letramin}+)(({Letramin}*)({Digitos}*))+
Enteros=({Digitos})+
Reales=({Digitos})+(".")({Digitos})+
Realescientificos=({Digitos})+(".")({Digitos})+("E"("+")|("-"))({Digitos}{Digitos})
String=("\"")(.)+("\"")
Relacionales=(">"|"<"|">="|"<="|"<>"|"==")
Aritmeticos=("+"|"-"|"*"|"/")
Puntuacion=(","|"."|";"|":")
Agrupacion=("{"|"}"|"("|")"|"["|"]")
%%

{Identificadores} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"IDENTIFICADOR", yyline, yychar);
}

{Enteros} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"NUMERO ENTERO", yyline, yychar);
}

{Reales} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"NUMERO REAL", yyline, yychar);
}

{Realescientificos} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"NUMERO REAL CIENTIFICO", yyline, yychar);
}

{String} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"STRING", yyline, yychar);
}

"F" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: F", yyline, yychar);
}

"OPEN" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: OPEN", yyline, yychar);
}

"CLOSE" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: CLOSE", yyline, yychar);
}

"IDENT" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: IDENT", yyline, yychar);
}

"ENDIDENT" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ENDIDENT", yyline, yychar);
}

"INT" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: INT", yyline, yychar);
}

"CHAR" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: CHAR", yyline, yychar);
}

"FLOAT" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: FLOAT", yyline, yychar);
}

"BOOLEAN" { error=false; contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: BOOLEAN", yyline, yychar);
}

"WHILE" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: WHILE", yyline, yychar);
}

"ENDWHILE" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ENDWHILE", yyline, yychar);
}

"REPEAT" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: REPEAT", yyline, yychar);
}

"UNTIL" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: UNTIL", yyline, yychar);
}

"IF" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: IF", yyline, yychar);
}

"ELSE" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ELSE", yyline, yychar);
}

"ENDIF" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ENDIF", yyline, yychar);
}

"=" { error=false;contador++;
                    return new Yytoken(contador, yytext(),"OPERADOR DE ASIGNACION", yyline, yychar);
}

{Relacionales} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"OPERADOR RELACIONAL", yyline, yychar);
}

{Aritmeticos} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"OPERADOR ARITMETICO", yyline, yychar);
}

{Puntuacion} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"SIGNO DE PUNTUACION", yyline, yychar);
}

{Agrupacion} { error=false;contador++;
                    return new Yytoken(contador, yytext(),"SIGNO DE AGRUPACION", yyline, yychar);
}

" " { 
}

/*con la siguiente linesa ignoramos los espacios en blanco*/
(" ") {System.out.println("espacio");}
/*con esta ignoramos los saltos de linea, tabulaciones,*/
[\t\r\n\f] {}
/*error lexico:*/
. {error=true;}