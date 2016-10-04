import java_cup.runtime.*;

%%
%public
%class Lexer
%unicode
%cup
%line
%column
%function next_token
%type java_cup.runtime.Symbol

%eofval{
    return new Symbol(sym.EOF);
%eofval}
%eofclose

%state CADENA

%{
  StringBuffer cadena = new StringBuffer();
  int numErr = 0;
%}




FinDeLinea = \r|\n|\r\n
Espacio = {FinDeLinea}|[ \t\f]
Identificador = [:jletter:][:jletterdigit:]*
Numero = 0 | [1-9][0-9]*

ComentarioInicio = \/\*\* | \*
ComentarioFin = {FinDeLinea} | \*\/
ComentarioDeLinea = \/\/.*{FinDeLinea}
Comentario = {ComentarioInicio}([^(\*\/)])*{ComentarioFin} | {ComentarioDeLinea}

LiteralBooleana = verdadero | falso

OperadorBinario = \+ | - | \* | % 
OperadorComparacion = > | < | == | >= | <=
OperadorLogico = y | o 

%%

<YYINITIAL> {
  {Espacio}                 {}  
  {Comentario}              {}
  "programa"                {return new Symbol(sym.PROGRAMA, yyline, yycolumn);}
  "mientras"                {return new Symbol(sym.MIENTRAS, yyline, yycolumn);}
  "{"			                  {return new Symbol(sym.LLAVE_IZQ, yyline, yycolumn);}
  "}"		                    {return new Symbol(sym.LLAVE_DER, yyline, yycolumn);}
  "escribe"	                {return new Symbol(sym.OP_ESCRITURA, yyline, yycolumn);}
  "para"                    {return new Symbol(sym.PARA, yyline, yycolumn);}
  "desde"                   {return new Symbol(sym.DESDE, yyline, yycolumn);}
  "hasta"                   {return new Symbol(sym.HASTA, yyline, yycolumn);}
  "si"                      {return new Symbol(sym.SI, yyline, yycolumn);}
  "si no"                   {return new Symbol(sym.SI_NO, yyline, yycolumn);}
  "entonces"                {return new Symbol(sym.ENTONCES, yyline, yycolumn);}
  "logico"                  {return new Symbol(sym.LOGICO, yyline, yycolumn);}
  "entero"                  {return new Symbol(sym.ENTERO, yyline, yycolumn);}
  "cadena"                  {return new Symbol(sym.CADENA, yyline, yycolumn);}
  "lee"                     {return new Symbol(sym.OP_LECTURA, yyline, yycolumn);}
  ";"			                  {return new Symbol(sym.MARCADOR_FIN_SENTENCIA, yyline, yycolumn);}
  \"                        {cadena.setLength(0);yybegin(CADENA);}
  "("                       {return new Symbol(sym.PAREN_IZQ, yyline, yycolumn);}
  ")"                       {return new Symbol(sym.PAREN_DER, yyline, yycolumn);}
  "nulo"                    {return new Symbol(sym.LITERAL_NULA, yyline, yycolumn);}
  {Numero}                  {return new Symbol(sym.LITERAL_ENTERA, yyline, yycolumn, yytext().toString());}
  "no"                      {return new Symbol(sym.OPERADOR_UNARIO, yyline, yycolumn);}
  {OperadorBinario}         {return new Symbol(sym.OPERADOR_BINARIO, yyline, yycolumn, yytext().toString());}
  {OperadorComparacion}     {return new Symbol(sym.OPERADOR_COMPARACION, yyline, yycolumn, yytext().toString());}
  {OperadorLogico}          {return new Symbol(sym.OPERADOR_LOGICO, yyline, yycolumn, yytext().toString());}
  "="                       {return new Symbol(sym.ASIGNACION, yyline, yycolumn);}
  {LiteralBooleana}         {return new Symbol(sym.LITERAL_BOOLEANA, yyline, yycolumn, yytext().toString());}
  {Identificador}           {return new Symbol(sym.ID, yyline, yycolumn, yytext().toString());}
}

<CADENA> {
\"		{yybegin(YYINITIAL);return new Symbol(sym.LITERAL_CADENA, yyline, yycolumn,cadena.toString());}
[^\n\r\"\\]+ {cadena.append(yytext());}

}

/* si la entrada no cumple ninguna de las reglas se considera un error */
[^]                              {numErr++;return new Symbol(sym.error, yyline, yycolumn,yytext());}