package analizadorlex;
import java.lang.System;


%%
//permite cambiar el nombre de la función de yylex que reconoce los tokens (next token)
%function nextToken
//permite cambiar el nombre de la clase del analizador léxico, desde Yylex.
%class Analizador
//se define in integer para el contador de tokens
%{
private int contador;
%}
//con init inicializamos variables
%init{
contador = 0;
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
Identificadores=({Letramayus})({Letramin})+({Digitos})*
Enteros=({Digitos})+
Reales=({Digitos})+(".")({Digitos})+
Realescientificos=({Digitos})+(".")({Digitos})+("E"("+")|("-"))({Digitos}{Digitos})
String=("\"").("\"")
Relacionales=(">"|"<"|">="|"<="|"<>"|"==")
Aritmeticos=("+"|"-"|"*"|"/")
Puntuacion=(","|"."|";"|":")
Agrupacion=("{"|"}"|"("|")"|"["|"]")
%%

{Identificadores} { contador++;
                    return new Yytoken(contador, yytext(),"IDENTIFICADOR", yyline, yychar);
}

{Enteros} { contador++;
                    return new Yytoken(contador, yytext(),"NUMERO ENTERO", yyline, yychar);
}

{Reales} { contador++;
                    return new Yytoken(contador, yytext(),"NUMERO REAL", yyline, yychar);
}

{Realescientificos} { contador++;
                    return new Yytoken(contador, yytext(),"NUMERO REAL CIENTIFICO", yyline, yychar);
}

{String} { contador++;
                    return new Yytoken(contador, yytext(),"STRING", yyline, yychar);
}

"F" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: F", yyline, yychar);
}

"OPEN" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: OPEN", yyline, yychar);
}

"CLOSE" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: CLOSE", yyline, yychar);
}

"IDENT" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: IDENT", yyline, yychar);
}

"ENDIDENT" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ENDIDENT", yyline, yychar);
}

"INT" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: INT", yyline, yychar);
}

"CHAR" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: CHAR", yyline, yychar);
}

"FLOAT" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: FLOAT", yyline, yychar);
}

"BOOLEAN" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: BOOLEAN", yyline, yychar);
}

"WHILE" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: WHILE", yyline, yychar);
}

"ENDWHILE" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ENDWHILE", yyline, yychar);
}

"REPEAT" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: REPEAT", yyline, yychar);
}

"UNTIL" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: UNTIL", yyline, yychar);
}

"IF" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: IF", yyline, yychar);
}

"ELSE" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ELSE", yyline, yychar);
}

"ENDIF" { contador++;
                    return new Yytoken(contador, yytext(),"PALABRA RESERVADA: ENDIF", yyline, yychar);
}

"=" { contador++;
                    return new Yytoken(contador, yytext(),"OPERADOR DE ASIGNACION", yyline, yychar);
}

{Relacionales} { contador++;
                    return new Yytoken(contador, yytext(),"OPERADOR RELACIONAL", yyline, yychar);
}

{Aritmeticos} { contador++;
                    return new Yytoken(contador, yytext(),"OPERADOR ARITMETICO", yyline, yychar);
}

{Puntuacion} { contador++;
                    return new Yytoken(contador, yytext(),"SIGNO DE PUNTUACION", yyline, yychar);
}

{Agrupacion} { contador++;
                    return new Yytoken(contador, yytext(),"SIGNO DE AGRUPACION", yyline, yychar);
}

" " { 
}

/*con la siguiente linesa ignoramos los espacios en blanco*/
(" ") {System.out.println("espacio");}
/*con esta ignoramos los saltos de linea, tabulaciones,*/
[\t\r\n\f] {}
/*error lexico:*/
. {System.out.println("error");}