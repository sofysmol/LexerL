/* this is the scanner example from the JLex website 
   (with small modifications to make it more readable) */
package sofysmo.lexerl;
import sofysmo.lexerl.tokens.*;
import sofysmo.lexerl.exceptions.*;
%%

%{
    private int line_begin = 0;
    private int char_begin = 0;
    private String comment = "";
%} 

%line
%char
%unicode
%state MULTILINE_COMMENT
%public
%column

ALPHA=[A-Za-z]
DIGIT=[0-9]
IGNOR=[\n\r\t\b\012\s]
NUM = {DIGIT}+{DIGIT}*
IDENT = {ALPHA}({ALPHA}|{DIGIT}|_)*
SP=" "
OP=["+","-","*","/","%","==","!=",">",">=","<","<=","&&","||","**"]
KW="skip"|"write"|"read"|"while"|"do"|"then"|"else"|"if"
ONELINE_COMMENT="//"+([^\n])*
MULTILINE_COMMENT_TEXT=([^*)]|"*"[^)])+
%%
<YYINITIAL> {
  {ONELINE_COMMENT} {return (Yytoken)(new CommentToken(yytext().substring(2),yyline,yycolumn+2,yyline,yycolumn+yylength()-2)); }
   "(*" {yybegin(MULTILINE_COMMENT);  line_begin = yyline; char_begin = yycolumn; comment="";}
   "*)" {throw new TokenException(yytext(),yyline, yycolumn, yycolumn+yylength());}
   "**" { return (Yytoken)(new OpToken("Power",yyline,yycolumn,yycolumn+1)); }
  ":=" {return (Yytoken)(new OpToken("Assignment", yyline,yycolumn,yycolumn+1));}
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
  "<=" { return (Yytoken)(new OpToken("LessOrEq",yyline,yycolumn,yycolumn+1)); }
  "<"  { return (Yytoken)(new OpToken("Less",yyline,yycolumn,yycolumn)); }
  ">=" { return (Yytoken)(new OpToken("GreaterOrEq",yyline,yycolumn,yycolumn+1)); }
  ">"  { return (Yytoken)(new OpToken("Greater",yyline,yycolumn,yycolumn)); }
  "&&"  { return (Yytoken)(new OpToken("And",yyline,yycolumn,yycolumn+1)); }
  "||"  { return (Yytoken)(new OpToken("Or",yyline,yycolumn,yycolumn+1)); }
  "%" { return (Yytoken)(new OpToken("Mod",yyline,yycolumn,yycolumn)); }
  {KW} {return (Yytoken)(new KeywordToken(yytext(), yyline, yycolumn, yycolumn+yylength()-1));}
  {IDENT} {return (Yytoken)(new VarToken(yytext(), yyline, yycolumn, yycolumn+yylength()-1));}
  {NUM} {return (Yytoken)(new NumToken(yytext(),yyline, yycolumn, yycolumn+yylength()-1));}
  {IGNOR} {}


  . {throw new TokenException(yytext(),yyline, yycolumn, yycolumn+yylength());}
}
<MULTILINE_COMMENT> {
          "(*" { }
          "*)" {
                  yybegin(YYINITIAL);
                  return (Yytoken)(new CommentToken(comment,line_begin,char_begin,yyline,yycolumn-1));
               }
           {MULTILINE_COMMENT_TEXT} { comment+=yytext();}
        }


