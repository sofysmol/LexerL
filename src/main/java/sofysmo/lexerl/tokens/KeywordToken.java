package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class KeywordToken implements Yytoken {
    private String kw;
    private int line;
    private int charBegin;
    private int charEnd;
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

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCharBegin() {
        return charBegin;
    }

    public void setCharBegin(int charBegin) {
        this.charBegin = charBegin;
    }

    public int getCharEnd() {
        return charEnd;
    }

    public void setCharEnd(int charEnd) {
        this.charEnd = charEnd;
    }
}


