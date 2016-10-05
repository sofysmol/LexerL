/* this is the scanner example from the JLex website 
   (with small modifications to make it more readable) */
package sofysmo.lexerl;
import sofysmo.lexerl.tokens.*;
import sofysmo.lexerl.exceptions.*;
%%

%{
    private int _count = 0;
%} 

%line
%char
%unicode
%public
%column

ALPHA=[A-Za-z]
DIGIT=[0-9]
IGNOR=[\n\r\t\b\012\s]
NUM = {DIGIT}+{DIGIT}*
IDENT = {ALPHA}({ALPHA}|{DIGIT}|_)*
SP=" "
OP=["+","-","*","/","%","==","!=",">",">=","<","<=","&&","||"]
KW="skip"|"write"|"read"|"while"|"do"|"then"|"else"|"if"
%%
<YYINITIAL> {
  ":" { return (Yytoken)(new SemicolonToken(yyline,yycolumn,yycolumn)); }
  ";" { return (Yytoken)(new ColonToken(yyline,yycolumn,yycolumn)); }
  "(" { return (Yytoken)(new LeftParenToken(yyline,yycolumn,yycolumn)); }
  ")" { return (Yytoken)(new RightParenToken(yyline,yycolumn,yycolumn)); }
  "+" { return (Yytoken)(new OpToken("Plus",yyline,yycolumn,yycolumn)); }
  "-" { return (Yytoken)(new OpToken("Minus",yyline,yycolumn,yycolumn)); }
  "*" { return (Yytoken)(new OpToken("Mult",yyline,yycolumn,yycolumn)); }
  "/" { return (Yytoken)(new OpToken("Div",yyline,yycolumn,yycolumn)); }
  "=" { return (Yytoken)(new OpToken("Eq",yyline,yycolumn,yycolumn)); }
  "!=" { return (Yytoken)(new OpToken("NotEq",yyline,yycolumn,yycolumn+1)); }
  "<"  { return (Yytoken)(new OpToken("Less",yyline,yycolumn,yycolumn)); }
  "<=" { return (Yytoken)(new OpToken("LessOrEq",yyline,yycolumn,yycolumn+1)); }
  ">"  { return (Yytoken)(new OpToken("Greater",yyline,yycolumn,yycolumn)); }
  ">=" { return (Yytoken)(new OpToken("GreaterOrEq",yyline,yycolumn,yycolumn+1)); }
  "&&"  { return (Yytoken)(new OpToken("And",yyline,yycolumn,yycolumn+1)); }
  "||"  { return (Yytoken)(new OpToken("Or",yyline,yycolumn,yycolumn+1)); }
  "%" { return (Yytoken)(new OpToken("Mod",yyline,yycolumn,yycolumn)); }
  {KW} {return (Yytoken)(new KeywordToken(yytext(), yyline, yycolumn, yycolumn+yylength()));}
  {IDENT} {return (Yytoken)(new VarToken(yytext(), yyline, yycolumn, yycolumn+yylength()));}
  {NUM} {return (Yytoken)(new NumToken(yytext(),yyline, yycolumn, yycolumn+yylength()));}
  {IGNOR} {}
  . {throw new TokenException(yytext(),yyline, yycolumn, yycolumn+yylength());}
}


