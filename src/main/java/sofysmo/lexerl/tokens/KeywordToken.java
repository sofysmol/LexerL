package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class KeywordToken implements Yytoken {
    public String kw;
    public int line;
    public int charBegin;
    public int charEnd;
    public KeywordToken(String kw, int line, int charBegin, int charEnd)
    {
        this.kw = kw;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "KW_"+kw.substring(0, 1).toUpperCase() + kw.substring(1)+"(" + line + ";"+charBegin + ";" + charEnd+");";
    }
}

