package Gramatica_DASM;
import Estructuras.Errores;
import java.util.LinkedList;
import java_cup.runtime.*;
%%
%{
public static String Rut;
public LinkedList<Errores>errores_lexicos=new LinkedList<Errores>();
%}
%public
%class lexico_DASM
%unicode
%line
%column
%apiprivate
%cup
%caseless
%eofval{
	return null;
%eofval}
NUMERO=[0-9]
LETRA=[a-zA-Z]
NUMERO_COMPLETO=({NUMERO})+
PALABRA=({NUMERO}|{LETRA})+
%%
"$"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.dolar, yyline, yycolumn,yytext());}
"add"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.add, yyline, yycolumn,yytext());}
"diff"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.diff, yyline, yycolumn,yytext());}
"mult"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.mult, yyline, yycolumn,yytext());}
"div"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.div, yyline, yycolumn,yytext());}
"mod"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.mod, yyline, yycolumn,yytext());}
"lt"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.lt, yyline, yycolumn,yytext());}
"gt"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.gt, yyline, yycolumn,yytext());}
"lte"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.lte, yyline, yycolumn,yytext());}
"gte"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.gte, yyline, yycolumn,yytext());}
"eqz"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.eqz, yyline, yycolumn,yytext());}
"and"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.and, yyline, yycolumn,yytext());}
"or"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.or, yyline, yycolumn,yytext());}
"not"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.not, yyline, yycolumn,yytext());}
"br"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.br, yyline, yycolumn,yytext());}
"br_if"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.br_if, yyline, yycolumn,yytext());}
"get_local"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.get_local, yyline, yycolumn,yytext());}
"get_global"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.get_global, yyline, yycolumn,yytext());}
"set_local"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.set_local, yyline, yycolumn,yytext());}
"set_global"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.set_global, yyline, yycolumn,yytext());}
"tee_local"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.tee_local, yyline, yycolumn,yytext());}
"tee_global"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.tee_global, yyline, yycolumn,yytext());}
"function"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.function, yyline, yycolumn,yytext());}
"end"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.end, yyline, yycolumn,yytext());}
"print"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.print, yyline, yycolumn,yytext());}
"call"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.call, yyline, yycolumn,yytext());}
"\"%c\""
{System.out.print(yytext()); return new Symbol(simbolo_DASM.i_caracter, yyline, yycolumn,yytext());}
"%d"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.i_entero, yyline, yycolumn,yytext());}
"%f"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.i_flotante, yyline, yycolumn,yytext());}
"calc"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.calc, yyline, yycolumn,yytext());}
"ret"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.retorno, yyline, yycolumn,yytext());}
"quadrate"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.quadrate, yyline, yycolumn,yytext());}
"oval"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.oval, yyline, yycolumn,yytext());}
"string"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.texto, yyline, yycolumn,yytext());}
"point"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.point, yyline, yycolumn,yytext());}
"line"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.line, yyline, yycolumn,yytext());}
"principal"
{System.out.print(yytext()); return new Symbol(simbolo_DASM.principal, yyline, yycolumn,yytext());}
{NUMERO_COMPLETO}
{System.out.print(yytext()); return new Symbol(simbolo_DASM.numero_completo, yyline, yycolumn,yytext());}
{PALABRA}
{System.out.print(yytext()); return new Symbol(simbolo_DASM.palabra, yyline, yycolumn,yytext());}

[ \t\r\n\f EOF]
{ /* ignore white space. */ }
.   {
    Errores error=new Errores("Error Lexico!!","Error Lexico",(yyline+1),(yycolumn+1),yytext());
    errores_lexicos.add(error);
    System.out.println("Linea: " + (yyline+1) + " Columna: " + (yycolumn+1) + " - Error Lexico en: " + yytext());}