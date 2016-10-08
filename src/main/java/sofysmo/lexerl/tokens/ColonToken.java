package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class ColonToken implements Yytoken {
    private int line;
    private int charBegin;
    private int charEnd;
    public ColonToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }

    @Override
    public String toString()
    {
        return "Colon(" + line + ";"+charBegin + ";" + charEnd+");";
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
